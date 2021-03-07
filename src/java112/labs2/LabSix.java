package java112.labs2;

import java.util.*;
import java.io.*;
import java112.utilities.*;

/**
 *  This is Lab 3 of Unit 2 involving properties
 *
 *@author    fRaisbeck
 */

public class LabSix implements PropertiesLoader {

    /**
     * Instance variable of a property
     */
    private Properties properties;

    /**
     * run our LabThree
     * @param args command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            LabSix lab = new LabSix();
            lab.run(args[0]);
        }
    }

    /**
     * Create a properties object, load properties, and display the properties to the console
     */
    public void run(String argument) {
        properties = loadProperties(argument);
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String key : propertyNames) {
            System.out.println("They key is: " + key + ".  The value is " +
                    properties.getProperty(key));
        }
    }
}
