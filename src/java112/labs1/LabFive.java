package java112.labs1;
import java.io.*;

/** LabFive demonstrate writing file
 * @author fraisbeck
 */

public class LabFive{
    /** main method to run our program
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
        } else {
            LabFive lab = new LabFive();
            lab.run(args[0], args[1]);
        }
    }

    /** run
     */
    public void run (String fileName, String message) {
        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            outputWriter.println(message);
        } catch (IOException inputOutputException) {
            System.out.println("There was a problem writing the file.");
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem...");
            exception.printStackTrace();
        } finally {
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }
}
