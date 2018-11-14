package co.com.ies.bingo.mongotest;


import com.mongodb.*;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.QueryModifier;

import java.io.IOException;
import java.net.UnknownHostException;

public class JongoPruebas {
    public static void main(String[] arguments) throws IOException {
        DB db;
        Mongo mongo = new Mongo("127.0.0.1", 27017);
        db = mongo.getDB("marketing");
        db.dropDatabase();
        DBCollection collection = db.getCollection("users");
        User user = new User("jdoe", 18, new Address("10 rue des lilas", "Paris", "France"));

        //Creating a DBObject for User
        DBObject dbObject = new BasicDBObject();
        dbObject.put("username", user.getUsername());
        dbObject.put("age", user.getAge());


        //Creating a DBObject for address
        Address address = user.getAddress();
        BasicDBObject dbAddress = new BasicDBObject("way", address.getWay());
        dbAddress.put("city", address.getCity());
        dbAddress.put("country", address.getCountry());
        dbObject.put("address", dbAddress);

        collection.save(dbObject, WriteConcern.SAFE);

        MongoCollection collection2 = new Jongo(db).getCollection("users");
        User peter2 = new User("peter", 22, new Address("10 rue des lilas", "Paris", "France"));
        User patrick2 = new User("patrick", 89, new Address("122 Boulevard Haussmann", "Paris", "France"));
        User boris2 = new User("boris", 12, new Address("12 allée des coquelicots", "Aix-en-Provence", "France"));
        User robert2 = new User("robert", 55, new Address("12 allée des paquerettes", "Toulouse", "France"));

        collection2.save(peter2);
        collection2.save(patrick2);
        collection2.save(boris2);
        collection2.save(robert2);

        DB db2 = new MongoClient().getDB("dbname");

        Jongo jongo = new Jongo(db2);
        MongoCollection friends = jongo.getCollection("friends");

        MongoCursor<Friend> all = friends.find("{name: 'Joe'}").as(Friend.class);
        Friend one = friends.findOne("{name: 'Joe'}").as(Friend.class);

        Friend joe = new Friend("Joe", 27);

        friends.save(joe);
        joe.age = 28;
        friends.save(joe);

        friends.update("{name: 'Joe'}").with("{$inc: {age: 1}}");
        friends.update("{name: 'Joe'}").upsert().multi().with("{$inc: {age: 1}}");

        friends.update("{name: 'Joe'}").with(new Friend("alfa",1));
        friends.update("{name: 'Joe'}").with("{$set: {address: #}}", new Address("san juan", "medellin", "colombia"));

        friends.insert("{name: 'Joe', age: 18}");

        friends.insert(new Friend("felipe",37));
        friends.insert(new Friend("juen",5), new Friend("pedro",217));

        friends.remove("{name: 'Joe'}");


        MongoCursor<Friend> all2 = friends.find("{name: 'Joe'}").as(Friend.class);

        Friend joe2 = friends.findOne("{name: 'Joe'}").as(Friend.class);

        friends.find().projection("{lastname: 1, address: 1}").as(Friend.class);

        friends.find().skip(20).as(Friend.class);
        friends.find().limit(10).as(Friend.class);

        friends.find().with(new QueryModifier() {
            public void modify(DBCursor cursor) {
                cursor.batchSize(10);
                cursor.addSpecial("$maxScan", 1);
            }
        }).as(Friend.class);

        MongoCursor<Friend> cursor = friends.find().as(Friend.class);
//iterate over it
        cursor.close();

        friends.find("{name:#, age:#}", "Joe", 18); //→ will produce {name: 'Joe', age: 18}
        friends.find("{address: #}", new Address().setAddress("san juan")); //→ will marshall Address object




    }
}
