package co.com.ies.bingo.mongotest;

public class Friend {
    public String _id;
    public String name;
    public int age;
    public String gender;

    public Friend(String _id, String name, int age, String gender) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Friend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Friend set_id(String _id) {
        this._id = _id;
        return this;
    }

    public Friend setName(String name) {
        this.name = name;
        return this;
    }

    public Friend setAge(int age) {
        this.age = age;
        return this;
    }

    public Friend setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }


}
