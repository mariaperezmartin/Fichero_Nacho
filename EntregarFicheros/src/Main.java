import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static File fileIncidencias = new File("C:/ventas/incidencias.log");
	
	public static void main(String[] args) {
		//EJERCICIO 1.
		File dirVentas = new File("C:/ventas");
		if(!dirVentas.exists()) {
			dirVentas.mkdir();
		}
		
		if(!fileIncidencias.exists()) {
			try {
				fileIncidencias.createNewFile();
			} catch (IOException e) {
				System.err.println("ERROR: no se ha podido crear el fichero Incidencias.log");
				System.err.println(e.getMessage());
				System.exit(-1);
			}
		}
		
		File fileConfig = new File("C:/ventas/config.txt");
		if(!fileConfig.exists()) {
			try {
				fileConfig.createNewFile();
			} catch (IOException e) {
				System.err.println("ERROR: no se ha podido crear el fichero config.txt");
				System.err.println(e.getMessage());
				System.exit(-2);
			}
		}
		//escribirFicheroCaracteres(fileConfig);
		//leerFicheroCaracteres(fileConfig);
		
		
		
		//EJERCICIO 2.
		File fileConfigDat = new File("C:/ventas/config.dat");
		if(!fileConfig.exists()) {
			try {
				fileConfig.createNewFile();
			} catch (IOException e) {
				System.err.println("ERROR: no se ha podido crear el fichero config.dat");
				System.err.println(e.getMessage());
				System.exit(-3);
			}
		}
		
		//escribirFicheroBinario(fileConfigDat);
		//leerFicheroBinario(fileConfigDat);
		
		
		
		
		//EJERCICIO 3.
		File fileCoches = new File("C:/ventas/coches.dat");
		if(!fileCoches.exists()) {
			try {
				fileCoches.createNewFile();
			} catch (IOException e) {
				System.err.println("ERROR: no se ha podido crear el fichero coches.dat");
				System.err.println(e.getMessage());
				System.exit(-4);
			}
		}
		//escribirCochesBinario(fileCoches);
		//leerFicheroBinario(fileCoches);
	}

	private static void escribirCochesBinario(File fileCoches) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(fileCoches);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se ha encontrado el fichero "+fileCoches);
			System.err.println(e.getMessage());
			System.exit(-20);
		}
		try {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido hacer el flujo ObjectOutputStream a "+fileCoches);
			System.err.println(e.getMessage());
			System.exit(-21);
		}
		List<Coche> coches = new ArrayList();
		Coche coche1 = new Coche("Mercedes",2020);
		coches.add(coche1);
		Coche coche2 = new Coche("Audi",2016);
		coches.add(coche2);
		Coche coche3 = new Coche("Citroen",2015);
		coches.add(coche3);
		
		try {
			objectOutputStream.writeObject(coches);
			
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido escribir en "+fileCoches);
			System.err.println(e.getMessage());
			System.exit(-22);
		}
		try {
			objectOutputStream.close();
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido cerrar "+fileCoches);
			System.err.println(e.getMessage());
			System.exit(-23);
		}
		
	}

	private static void leerFicheroBinario(File fileConfigDat) {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(fileConfigDat);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se ha encontrado el fichero "+fileConfigDat);
			escribirFicheroIncidencias(fileIncidencias , e.getMessage());
			System.err.println(e.getMessage());
			System.exit(-16);
		}
		try {
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido hacer el flujo ObjectInputStream a "+fileConfigDat);
			escribirFicheroIncidencias(fileIncidencias , e.getMessage());
			System.err.println(e.getMessage());
			System.exit(-17);
		}
		try {
			System.out.println(objectInputStream.readObject());
			System.out.println("Se ha leido "+fileConfigDat);
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("ERROR: no se ha podido leer "+fileConfigDat);
			escribirFicheroIncidencias(fileIncidencias , e.getMessage());
			System.err.println(e.getMessage());
			System.exit(-18);
		}
		try {
			objectInputStream.close();
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido cerrar "+fileConfigDat);
			escribirFicheroIncidencias(fileIncidencias , e.getMessage());
			System.err.println(e.getMessage());
			System.exit(-19);
		}
	}

	private static void escribirFicheroBinario(File fileConfigDat) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		String texto = "puerto:8081 \n"
				+ "nnomapp:ventas \n"
				+ "fichlog:\\c:ventas\\ventas.log \n"
				+ "nnumses:200";
		
		try {
			fileOutputStream = new FileOutputStream(fileConfigDat);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se ha encontrado el fichero "+fileConfigDat);
			System.err.println(e.getMessage());
			System.exit(-12);
		}
		try {
			objectOutputStream=	new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido hacer el flujo ObjectOutputStream a "+fileConfigDat);
			System.err.println(e.getMessage());
			System.exit(-13);
		}
		try {
			objectOutputStream.writeObject(texto);
			System.out.println("Se ha escrito en el fichero "+fileConfigDat);
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido escribir "+fileConfigDat);
			System.err.println(e.getMessage());
			System.exit(-14);
		}
		try {
			objectOutputStream.close();
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido cerrar "+fileConfigDat);
			System.err.println(e.getMessage());
			System.exit(-15);
		}
	}
	

	private static void escribirFicheroCaracteres(File file) {
		FileWriter fw = null;
		
		try {
			fw=new FileWriter(file);
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido crear el FileWriter");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		
		try {
			fw.write("puerto:8081 \nnomapp:ventas \nfichlog:\\c:ventas\\ventas.log \nnumses:200");

			System.out.println("Se ha escrito en el fichero "+file);
		} catch (IOException e) {
			System.out.println("No se ha escrito en el fichero "+file);
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		try {
			fw.close();
		} catch (IOException e) {
			System.out.println("No se ha guardado los cambios en el fichero "+file);
			System.err.println(e.getMessage());
			System.exit(-5);
		}
	}

	private static void leerFicheroCaracteres(File file) {
		FileReader fr = null;
		
		try {
			fr=new FileReader(file);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se ha podido crear el FileReader");
			escribirFicheroIncidencias(fileIncidencias , e.getMessage());
			System.err.println(e.getMessage());
			System.exit(-6);
		}
		
		int letra;
		
		try {
			while((letra=fr.read()) != -1) {
				System.out.print((char)letra);
			}
			System.out.println("");
			System.out.println("");
			System.out.println("Se ha leido "+file);
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido leer el fichero "+file);
			escribirFicheroIncidencias(fileIncidencias , e.getMessage());
			System.err.println(e.getMessage());
			System.exit(-7);
		}
		try {
			fr.close();
		} catch (IOException e) {
			System.err.println("ERROR: no se ha cerrar el fichero"+file);
			escribirFicheroIncidencias(fileIncidencias , e.getMessage());
			System.err.println(e.getMessage());
			System.exit(-8);
		}
	}
	
	private static void escribirFicheroIncidencias(File file, String error) {
		FileWriter fw = null;
		
		try {
			fw=new FileWriter(file, true);
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido crear el FileWriter");
			System.err.println(e.getMessage());
			System.exit(-9);
		}
		
		try {
			fw.write(error +"\n");

			System.out.println("Se ha escrito en el fichero "+file);
		} catch (IOException e) {
			System.out.println("No se ha escrito en el fichero "+file);
			System.err.println(e.getMessage());
			System.exit(-10);
		}
		try {
			fw.close();
		} catch (IOException e) {
			System.out.println("No se ha guardado los cambios en el fichero "+file);
			System.err.println(e.getMessage());
			System.exit(-11);
		}
	}

}
