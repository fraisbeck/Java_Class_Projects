package java112.analyzer;
import java.io.*;
import java.util.*;
import java112.utilities.*;

/**
 *  Runs the main method of the Analyzer project
 *  @author fraisbeck
 */

public class Driver {

    /**
     *  Takes a file name given by the user to run through our Analyzer project 1
     *  @param args Command Line Arguments
     */
    public static void main(String[] args) {

        /* Instantiated instance of main processing class */
        FileAnalysis file = new FileAnalysis();

        /* Calls the main processing method of the main class
           and passes the command line arguments array to the method */
        file.analyze(args);
    }

}
