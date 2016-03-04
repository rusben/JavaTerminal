package terminal;

import java.io.File;
import java.io.IOException;

public class Exercici2 {

	public static void main(String[] args) {

		System.setProperty("user.dir", "/home/ruben.arroyo/workspace/JavaTerminal/files");
		System.out.println(System.getProperty("user.dir"));

		File f = new File(System.getProperty("user.dir") + "/" + "a.jpg");

		try {
			f.createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}

		changeFileExtension(f, "txt");
	}

	private static File changeFileExtension(File f, String newExtension) {

		String parent = "";
		String name = "";
		String newName = "";
		File newFile;
		int dot = -1;

		if (f.isFile()) {
			parent = f.getParent();
			name = f.getName();

			// Find last dot
			dot = name.lastIndexOf(".");

			if (dot >= 0) {
				// Remove the extension from the name
				newName = name.substring(0, dot);
				// Return a new file 
				newFile = new File(parent + "/" + newName + "." + newExtension);
				f.renameTo(newFile);
			} else {
				f.renameTo(new File(parent + "/" + name + "." + newExtension));
			}
		}
		
		return f;

	}
}
