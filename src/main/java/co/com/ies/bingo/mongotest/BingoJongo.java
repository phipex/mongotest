package co.com.ies.bingo.mongotest;

import co.com.ies.bingo.mongotest.bingo75.bingo.bingo75.JuegoUnicoService;
import co.com.ies.bingo.mongotest.bingo75.bingo.bingo75.bingo.BaloteraException;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.LazyDBObject;
import com.mongodb.Mongo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.ResultHandler;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class BingoJongo {

	public static final String NOMBRE_ARCHIVO = "automatico";
	
	public static void main(String[] arg) throws UnknownHostException {
		bingoe();

		//
	}

	private static void bingoe() {
		try {
			bingo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//bingoe();
		}
	}

	
	private static void bingo2() throws  UnknownHostException{
		
		DB dbBingo;
		Mongo mongo = new Mongo("127.0.0.1", 27017);
		dbBingo = mongo.getDB("bingo");

		int[] balotas = {};
		
		int sorteo = 1;
		int maximoNumeroGanadores = 14;
		
		for (int orden = 1; orden <= 75; ++orden) {
			System.out.print(orden+",");
			final int siguienteBalota = balotas[orden];
			// guardar balota
			//creaTachados
			creaTachadosXBalota(dbBingo, siguienteBalota, orden, sorteo);
			
			
			//TODO busca ganadores
			if(true){//si hay ganadores
				//TODO guarda ganadores
				if(true){//si hay mas de 14 ganadores termine
					return;
					
				}
				
			}else{
				//TODO busca el puntero
				//TODO guarda el puntero
				
				
			}
			
			
		}
		
		
		
		
	}
	
	private static void bingo() throws UnknownHostException {
		// Crea conexionc
		DB dbBingo;
		Mongo mongo = new Mongo("127.0.0.1", 27017);
		dbBingo = mongo.getDB("bingo");

		// realiza funcion
		/*
		 * final CommandResult commandResult = dbBingo.doEval("agregadFigura(34,1)");
		 * System.out.println(commandResult);
		 */

/*		Jongo jongo = new Jongo(dbBingo);
		MongoCollection punteros = jongo.getCollection("punteros");
		
		final Find find = punteros.find("{order: 32}");
		
		MongoCursor<String> all0 = find.map(new ResultHandler<String>() {

			@Override
			public String map(DBObject arg0) {
				System.out.println("BingoJongo.java::map: all="+arg0);
				//System.out.println("BingoJongo.java::map: all="+arg0.toString());
				//Map<String, String> myMap = gson.fromJson(arg0.toString(), type);
				
				//System.out.println("BingoJongo.java::map: myMap= "+myMap);
				
				final LazyDBObject object = (LazyDBObject)arg0.get("_id");
				return  object.get("tabla").toString();
				
				//return arg0.toString();
				
			}
		});
		
		System.out.println("BingoJongo.java::bingo: all0 =" + all0);
		
		for (String string : all0) {
			System.out.println("BingoJongo.java::bingo: string = "+string);
		}
		
		
		System.out.println("BingoJongo.java::bingo: find = "+find);
		
		MongoCursor<String> all = find.as(String.class);
		
		System.out.println("BingoJongo.java::bingo: all = "+all);
		
		
		if(true){
			return;
		}*/
		
		List<Long> ganadoresXSorteo = new ArrayList<>();

		List<Long> tiemposSorteo = new ArrayList<>();

        final String s = crearArchivo();

        for (int intentos = 1; intentos <= 1; intentos++) {
			try {
				System.out.println("Sorteo No. "+intentos);
				JuegoUnicoService juego = new JuegoUnicoService();
				long inicio = Calendar.getInstance().getTimeInMillis();

				// TODO borrar tachados yborrar balotas en juego
				limpiaJuego(dbBingo);

				juego.inicializaJuego((long) intentos, "b,i,n,g,o");

				long ganadores = 0;
				long lorden = 0;
				int[] balotas10 =  {
				          		24,
				        		14,
				        		43,
				        		34,
				        		26,
				        		18,
				        		72,
				        		44,
				        		23,
				        		7,
				        		64,
				        		38,
				        		30,
				        		40,
				        		17,
				        		11,
				        		66,
				        		62,
				        		58,
				        		33,
				        		49,
				        		39,
				        		25,
				        		61,
				        		65,
				        		51,
				        		69,
				        		54,
				        		37,
				        		27,
				        		74,
				        		55,
				        		3,
				        		71,
				        		73,
				        		75,
				        		12,
				        		50,
				        		53,
				        		56,
				        		47,
				        		60,
				        		68,
				        		45,
				        		32,
				        		36,
				        		70,
				        		59,
				        		13,
				        		16,
				        		63,
				        		41,
				        		29,
				        		6,
				        		22,
				        		20,
				        		21,
				        		42,
				        		2,
				        		10,
				        		48,
				        		46,
				        		9,
				        		35,
				        		4,
				        		52,
				        		5,
				        		67,
				        		15,
				        		1
				};
				int[] balotas7 = {29,
						41,
						9,
						44,
						65,
						17,
						25,
						71,
						49,
						50,
						35,
						63,
						28,
						40,
						21,
						23,
						7,
						58,
						33,
						19,
						61,
						75,
						70,
						59,
						54,
						53,
						37,
						27,
						74,
						4,
						62,
						66,
						11,
						73,
						69,
						51,
						22,
						6,
						57,
						64,
						10,
						42,
						2,
						46,
						48,
						45,
						68,
						32,
						36,
						26,
						13,
						16,
						20,
						47,
						56,
						60,
						34,
						3,
						55,
						72,
						14,
						30,
						38,
						43,
						1,
						5,
						52,
						67,
						15,
						8,
						24,
						18};
				int[] balotas4 = {		63,
						35,
						28,
						71,
						7,
						39,
						49,
						50,
						40,
						21,
						58,
						33,
						61,
						75,
						59,
						70,
						54,
						53,
						37,
						74,
						27,
						4,
						11,
						62,
						66,
						73,
						69,
						51,
						6,
						22,
						64,
						57,
						10,
						2,
						42,
						46,
						45,
						68,
						32,
						36,
						26,
						13,
						16,
						20,
						56,
						60,
						47,
						34,
						55,
						3,
						72,
						14,
						38,
						30,
						43,
						1,
						67,
						5,
						52,
						15,
						8,
						24,
						18};
				
				int[] balotas13 = {
						40,
						29,
						51,
						17,
						35,
						73,
						28,
						14,
						69,
						54,
						37,
						30,
						38,
						20,
						63,
						65,
						58,
						31,
						9,
						46,
						53,
						1,
						43,
						72,
						11,
						66,
						62,
						6,
						22,
						36,
						68,
						71,
						50,
						75,
						57,
						64,
						74,
						27,
						33,
						41,
						39,
						49,
						21,
						23,
						44,
						18,
						24,
						2,
						42,
						10,
						61,
						19,
						15,
						5,
						52,
						67,
						4,
						26,
						7,
						34,
						56,
						47,
						60,
						3,
						55,
						59,
						70,
						16,
						13
				};
				
				int[] balotas5 = {68,
						31,
						57,
						23,
						27,
						74,
						40,
						7,
						63,
						33,
						8,
						43,
						1,
						58,
						13,
						16,
						25,
						53,
						35,
						29,
						41,
						28,
						70,
						59,
						73,
						56,
						60,
						34,
						61,
						19,
						3,
						55,
						75,
						15,
						67,
						52,
						5,
						12,
						50,
						54,
						65,
						30,
						38,
						22,
						6,
						69,
						51,
						20,
						26,
						24,
						18,
						44,
						39,
						49,
						21,
						45,
						32,
						36,
						17,
						62,
						66,
						11,
						2,
						10,
						48,
						46,
						9,
						72,
						14,
						4};
				
				int[] balotas = {
						69,
						32,
						8,
						10,
						26,
						59,
						61,
						22,
						7,
						28,
						4,
						74,
						53,
						19,
						2,
						23,
						75,
						65,
						35,
						9,
						57,
						68,
						38,
						25,
						50,
						33,
						6,
						56,
						31,
						47,
						13,
						20,
						63,
						73,
						62,
						72,
						67,
						15,
						39,
						12,
						24,
						64,
						55,
						49,
						11,
						14,
						45,
						66,
						16,
						42,
						52,
						51,
						18,
						70,
						21,
						3,
						48,
						17,
						40




				};
				
				
				for (int orden = 1; orden <= 75; ++orden) {
					System.out.print(orden+",");
					final int siguienteBalota = balotas[orden];
					//final int siguienteBalota = juego.getSiguienteBalota((long) intentos);
					final int continueSiguiente = nuevaBalotera(dbBingo, siguienteBalota, orden);
					//final int continueSiguiente = nuevaBalotera(dbBingo, orden, orden);
					if (continueSiguiente > 0) {
						System.out.println(", ganadores en "+orden + " balotas "+continueSiguiente);
						ganadores = ganadores + continueSiguiente;
						if (ganadores >= 14) {
							ganadoresXSorteo.add(ganadores);
							lorden = orden;
							break;
						}
					}
				}
				long finalc = Calendar.getInstance().getTimeInMillis();

				long tiempo = finalc - inicio;
				tiemposSorteo.add(tiempo);
				System.out.println("tiempo transcurrido=" + (tiempo / 1000));
				
				guardaEnArchivo(s,intentos,ganadores, lorden ,tiempo );
				
			} catch (BaloteraException e) {
				e.printStackTrace();
			}

		}
		System.out.println("ganadoresXSorteo=" + ganadoresXSorteo);
		System.out.println("tiemposSorteo=" + tiemposSorteo);
	}

	private static List<String> buscaGandores(DB dbBingo, int sorteo){
		final CommandResult buscaGanadoresResult = dbBingo.doEval("buscaGanadores("+sorteo+")");
		final boolean ok = buscaGanadoresResult.ok();
		if (!ok) {
			return new ArrayList<>();
		}
		
		BasicDBList dbObjList = (BasicDBList) buscaGanadoresResult.toMap().get("retval");
		
		if (!dbObjList.isEmpty()) {
			System.out.println("hay ganadores: " + dbObjList.size());
			List<String> ganadores = new ArrayList<>();
			
			for (Object o : dbObjList) {
				DBObject dbo0 = (BasicDBObject) o;
				 System.out.println(dbo0);
				 String tabla = dbo0.toMap().get("tabla").toString();
				 
				 ganadores.add(tabla);
				 
			}
			return ganadores;
		}
		
		
		return new ArrayList<>();
	}
	
	
	private static int nuevaBalotera(DB dbBingo, int balota, int orden) {

		// System.out.println("balota:"+balota+",orden:"+orden);
		creaTachadosXBalota(dbBingo, balota, orden);

		final CommandResult buscaGanadoresResult = dbBingo.doEval("buscaGanadores()");
		final boolean ok = buscaGanadoresResult.ok();
		if (!ok) {
			return 0;
		}
		final Object retval = buscaGanadoresResult.get("retval");
		BasicDBList dbObjList = (BasicDBList) buscaGanadoresResult.toMap().get("retval");

		//System.out.println("result:" + dbObjList);
		final CommandResult buscaPunterosResult = dbBingo.doEval("buscaPunteros("+orden+")");
		 System.out.println(buscaPunterosResult);
		if (!dbObjList.isEmpty()) {
			System.out.println("hay ganadores: " + dbObjList.size());
			for (Object o : dbObjList) {
				DBObject dbo0 = (BasicDBObject) o;
				 System.out.println(dbo0);
			}
			return dbObjList.size();
		}
		

		return 0;
	}

	private static void creaTachadosXBalota(DB dbBingo, int balota, int orden) {
		final CommandResult nuevaBalotaResult = dbBingo.doEval("creaTachadosXBalota(" + balota + "," + orden + ")");
		//System.out.println(nuevaBalotaResult);
	}
	
	private static void creaTachadosXBalota(DB dbBingo, int balota, int orden, int sorteo) {
		final CommandResult nuevaBalotaResult = dbBingo.doEval("creaTachadosXBalota(" + balota + "," + orden + ","+sorteo+")");
		//System.out.println(nuevaBalotaResult);
	}

	private static void limpiaJuego(DB dbBingo) {
		final CommandResult nuevaBalotaResult = dbBingo.doEval("limpiaJuego()");
		//System.out.println(nuevaBalotaResult);
	}

	public static String crearArchivo()  {
		// Let us create a sample file with some text 
        String fileName = NOMBRE_ARCHIVO+Calendar.getInstance().getTimeInMillis()+".csv";
		BufferedWriter out = null;
        try {
            out = new BufferedWriter(
                          new FileWriter(fileName)); 
            out.write("sorteo,ganadores,orden,tiempo\n"); 

        } 
        catch (IOException e) { 
            System.out.println("Exception Occurred" + e); 
        } finally {
        	if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileName;
	}
	
	public static void guardaEnArchivo(String fileName,long sorteo, long ganadores, long orden, long tiempo) {
		
		String texto = sorteo+","+ganadores+","+orden+","+tiempo+"\n";
		
				appendStrToFile(fileName, texto);
		
	}
	
	public static void appendStrToFile(String fileName, String str) {
        BufferedWriter out = null;
	    try {

			// Open given file in append mode.
			out = new BufferedWriter(new FileWriter(fileName, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("exception occoured" + e);
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	public static class Ganador {
		public Integer idPremio;
		public Integer idCarton;
		public Integer idFigura;

	}

}
