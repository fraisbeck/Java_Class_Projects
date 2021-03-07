package java112.labs2;

import java.util.*;
import java.io.*;

/**
 *  This is Lab 4 of Unit 2 involving Maps
 *
 *@author    fRaisbeck
 */

public class LabTwoFour {

    /**
     * Instance variable of a Hashmap
     */
    private Map<String, Integer> myHashMap;
    /**
     * Instance variable of a TreeMap
     */
    private Map<String, Integer> myTreeMap;

    /**
     * runs our LabTwoFour
     * @param args command line arguments
     */
    public static void main(String[] args) {
            LabTwoFour lab = new LabTwoFour();
            lab.run();
    }

    /**
     * [run description]
     */
    public void run() {
        // Create a new hashmap
        myHashMap = new HashMap<String, Integer>();
        build();
        // entrySet returns a Set of Map.Entry (which is a key:value pair)
        for (Map.Entry<String, Integer> entry : myHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        if (myHashMap.containsKey("Three")) {
            System.out.println("The Values for \"Three\" are/is: " + myHashMap.get("Three"));
        } else {
            System.out.println("There is no Key value of \"Three\"");
        }
        System.out.println();
        System.out.println(myHashMap);
        myTreeMap = new TreeMap<String, Integer>(myHashMap);
        System.out.println(myTreeMap);
    }

    public void build() {
        myHashMap.put("One", 1);
        myHashMap.put("Two", 2);
        myHashMap.put("Three", 3);
        myHashMap.put("Four", 4);
    }
}
