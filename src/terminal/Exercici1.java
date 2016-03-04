package terminal;

import java.io.File;

public class Exercici1 {

	public static void main(String[] args) {

		System.setProperty("user.dir", "/home/ruben.arroyo/workspace/JavaTerminal/files");
		System.out.println(System.getProperty("user.dir"));

		File f = new File(System.getProperty("user.dir") + "/" + "tmp");

		if (f.exists()) {
			if (f.isDirectory()) { 
				if (f.delete()) System.out.println("S'ha esborrat la carpeta " + f.getAbsolutePath());
				else System.out.println("Se ha producido un error");
			}
		} else {
			if (f.mkdirs()) System.out.println("S'ha creat la carpeta " + f.getAbsolutePath());
			else System.out.println("Se ha producido un error");
		}
	}
}
