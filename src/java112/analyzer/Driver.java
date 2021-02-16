package java112.analyzer;
import java.io.*;
import java.util.*;

/** Driver
 * @author fraisbeck
 */

public class Driver {

    /** main method to run our program
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        /**  Instantiated instance of main processing class
         */
        FileAnalysis file = new FileAnalysis();

        /**
         * Calls the main processing method of the main class
         * and passes the command line arguments array to the method
         */
        file.analyze(args);
    }

}
