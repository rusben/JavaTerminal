
package terminal;

public class Console {

    // This is the root directory for the console
    private static final String root = "";
    // The current working directory
    private static final String workingDirectory = "";
    
    public static void main (String[] args) {
        run();    
    }

    // Initialize the console    
    public static void run() {
        
    }
    
    // List the files and directories in pathToFileOrDirectory
    // Returns true if pathToFileOrDirectoryExists false otherwise
    public static boolean ls (String pathToFileOrDirectory) {
        return true;    
    }
    
    // Change the workingDirectory to pathDirectory
    // Returns true if the path exists false otherwise
    public static boolean cd (String pathToDirectory) {
        return true;
    }
    
    // Create a directory
    // Returns true if the directory was created successfully false otherwise
    public static boolean mkdir(String pathToDirectory) {
        return true;
    }
    
    // Remove a directory
    // Returns true if the directory was removed successfully
    public static boolean rmdir(String pathToDirectory) {
        return true;
    }
    
    // Copy a File or directory into another
    // Returns true if the copy is completed false otherwise
    public static boolean cp(String pathToSource, String pathToDestination) {
        return true;
    }
    
    // Renove a file
    // Returns true if the file identified by pathToFile was deleted successfully false otherwise
    public static boolean rm (String pathToFile) {
        return true;
    }

    // Prints the working directory
    public static String pwd() {
        return workingDirectory;
    }

    // Find a file into the path
    // Returns the absolute path to a file identified by fileName into the path "" otherwise
    public static String find(String fileOrDirectoryName, String path) {
        return "";
    }
}