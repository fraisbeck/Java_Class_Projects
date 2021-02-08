package java112.labs1;
import java.io.*;

/** LabSix demonstrate reading and writing files
 * @author fraisbeck
 */

public class LabSix{
    /** main method to run our program
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
        } else {
            LabSix lab = new LabSix();
            lab.run(args[0], args[1]);
        }
    }

    /** run
     */
    public void run (String inputFile, String outputFile) {

        try (BufferedReader input = new BufferedReader(new FileReader(inputFile));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {

            while (input.ready()) {
                // read each line in here
                output.println(input.readLine());

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
        }
    }
}
