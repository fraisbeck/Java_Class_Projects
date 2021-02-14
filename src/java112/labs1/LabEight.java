package java112.labs1;
import java.io.*;
import java.util.*;

/** LabEight demonstrate using Sets
 * @author fraisbeck
 */

public class LabEight {

    //Instance variables
    Set<String> mySet; //Defining an instance variable

    /** main method to run our program
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            LabEight lab = new LabEight();
            lab.run(args[0]);
        }
    }

    public void run(String outputFilePath) {
            mySet = new TreeSet<String>();
            mySet.add("one");
            mySet.add("one");
            mySet.add("five");
            mySet.add("two");
            mySet.add("four");
            mySet.add("two");
            mySet.add("three");
            mySet.add("three");
            mySet.add("four");
            mySet.add("three");
            writeSetToOutputFile(outputFilePath);
    }

    public void writeSetToOutputFile(String outputFile) {
        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
            for (String element : mySet) {
                outputWriter.println(element);
            }
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
