package terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Exercici3 {

	public static void main(String[] args) {
		System.setProperty("user.dir", "/home/ruben.arroyo/workspace/JavaTerminal/files");
		System.out.println(System.getProperty("user.dir"));

		File f = new File(System.getProperty("user.dir") + "/" + "a/b/c/d/f/ejemplo.txt");
		// Create all the directories till the parent directory
		f.getParentFile().mkdirs();
		try {
			// Create the file
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(find("ejemplo.txt", System.getProperty("user.dir")));
		
	}

	public static String find(String fileName, String path) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				// If the name is equal to the searched element return the
				// absolute path
				if (listOfFiles[i].getName().equals(fileName))
					return listOfFiles[i].getAbsolutePath();
				// System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				return find(fileName, listOfFiles[i].getAbsolutePath());
				// System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		return "NOT FOUND!";

	}
}
