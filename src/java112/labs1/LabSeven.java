package java112.labs1;
import java.io.*;
import java.util.*;

/** LabSeven demonstrate using lists
 * @author fraisbeck
 */

public class LabSeven {

    //Instance variables
    List<String> myList; //Defining an instance variable

    /** main method to run our program
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            LabSeven lab = new LabSeven();
            lab.run(args[0]);
        }
    }

    public void run(String outputFilePath) {
        myList = new ArrayList<String>();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        myList.add("five");
        myList.add("six");
        myList.add("seven");
        myList.add("eight");
        myList.add("nine");
        myList.add("ten");
        writeListToOutputFile(outputFilePath);
    }

    public void writeListToOutputFile(String outputFile) {
        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
            for (String element : myList) {
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
