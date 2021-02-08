package java112.labs1;
import java.io.*;

/** LabFour demonstrate reading files
 * @author fraisbeck
 */

public class LabFour {
    /** main method to run our program
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            LabFour lab = new LabFour();
            lab.run(args[0]);
        }
    }

    /** run
     */
    public void run (String myString) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(myString));

            // code to proccess the input file

            // Declare a String variable to hold the current line
            String line = null;

            while (reader.ready()) {
                // read each line in here
                System.out.println(reader.readLine());

                // now process the line in some way
                // this will usually be in another method that
                // we pass the line to
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("File could not be read");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception exception) {
                System.out.println("There was another problem");
                exception.printStackTrace();
            }
        }
    }
}
