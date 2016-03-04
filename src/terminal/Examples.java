package terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Examples {

	// Escriu el teu nom d'usuari Linux
	private static final String user = "";

	public static void main(String[] args) {

		// Directori de treball
		// Si necessitem conèixer l’espai de treball actual:
		String dirTreball = System.getProperty("user.dir");
		// Si volem canviar aquest directori de treball actual:
		String nouDirTreball = "/home/usuari";
		System.setProperty("user.dir", nouDirTreball);

		// Carrega un fitxer a partir d'una ruta
		File f = new File("fitxer.txt");

		// Ruta absoluta
		File foto = new File("/home/usuari/Foto.png");
		// Ruta relativa (des del directori on estem)
		File altraFoto = new File("Foto.jpg");
		File rutaRelativaFoto = new File("LesMevesFotos/Foto.jpg");
		
		System.out.println("getParent()");
		f.getParent();
		System.out.println("getName()");
		f.getName();
		System.out.println("getAbsolutePath()");
		f.getAbsolutePath();

		// • String getParent(): La cadena resultant és idèntica a la ruta
		// original, menys
		// l’últim element. Si la ruta tractada és l’arrel, el resultat és un
		// NULL.
		// • String getName(): Avalua el nom de l’element que representa aquesta
		// ruta
		// (seria l’invertit a getParent() ).
		// • String getAbsolutePath(): Si en el fitxer al definir-lo varem
		// emprar una ruta
		// relativa, en aquest mètode podem obtindre la seva ruta absoluta.

		// Utilitceu File.separator per a que les vostres aplicacions siguin
		// independents del Sistema Operatiu on s'executin
		
		// File.separator
		// Create a File
		String path = "C:" + File.separator + "hello" + File.separator + "hi.txt";
		// Use relative path for Unix systems
		File file = new File(path);

		// Crea els directoris necessaris en cas que no existeixin
		file.getParentFile().mkdirs();
		// Crea el fitxer
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// With Java 7, you can use Path, Paths, and Files:
		Path path7 = Paths.get("/tmp/foo/bar.txt");

		try {
			Files.createDirectories(path7.getParent());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Files.createFile(path7);
		} catch (IOException e) {
			System.err.println("already exists: " + e.getMessage());
		}

		// Comprovacions d’estat
		// • La classe File ofereix un conjunt de mètodes per fer comprovacions
		// sobre l’estat del fitxer:
		// avalua com a true or false si la ruta existeix.
		file.exists();
		// comprova si la ruta es refereix a un fitxer o no.
		file.isFile();
		file.isDirectory();

		mostrarEstat(file);

		System.out.println("La ruta és " + file.getAbsolutePath());
		System.out.println("El seu pare és " + file.getParent());
		System.out.println("El seu nom és " + file.getName());

		// Lectura i modificació de propietats
		// Retorna la mida d’un fitxer en bytes.
		file.length();
		// Retorna la darrera data d’edició de l’element a la
		// ruta. El resultat és el temps que ha passat en milisegons.
		file.lastModified();
		
		System.out.println(file.getAbsoluteFile());
		//S'usa el tipus composta Date per transformar mil·lisegons a data real
		Date data = new Date(file.lastModified());
		System.out.println("Darrera modificació: " + data);
		System.out.println("Mida: " + file.length());
		

//		Gestió de Fitxers
//		• boolean mkdir(): permet crear una carpeta d’acord a la ubicació
//		indicada en la ruta.
//		• boolean delete(): esborra el fitxer o carpeta indicada
		
	}

	public static void mostrarEstat(File f) {
		System.out.println(f.getAbsolutePath() + " és un fitxer? " + f.isFile());
		System.out.println(f.getAbsolutePath() + " és una carpeta? " + f.isDirectory());
	}

	public void llistar() {
		File carpeta = new File("C:/Temp");
		File[] arrayElements = carpeta.listFiles();
		System.out.println("El contingut de " + carpeta.getAbsolutePath() + " és:");
		// Per recórrer un array, s'usa un bucle
		for (int i = 0; i < arrayElements.length; i++) {
			File f = arrayElements[i];
			if (f.isDirectory()) {
				System.out.print("[DIR] ");
			} else {
				System.out.print("[FIT] ");
			}
			System.out.println(f.getName());
		}
	}
	
	public void moure() {
		File origenCarpeta = new File("C:/Temp/Fotos");
		File destiCarpeta = new File("C:/Temp/Media/Fotografies");
		File origenDocument = new File("C:/Temp/Media/Fotografies/Document.txt");
		File destiDocument = new File("C:/Temp/Document.txt");
		boolean resultat = origenCarpeta.renameTo(destiCarpeta);
		System.out.println("S'ha mogut i reanomenat la carpeta? " + resultat);
		resultat = origenDocument.renameTo(destiDocument);
		System.out.println("S'ha mogut el document? " + resultat);
		}

}
