package java112.analyzer;
import java.io.*;
import java.util.*;

/** tokenAnalyzer interface
 * @author fraisbeck
 */

public interface TokenAnalyzer {

    public void processToken(String token);
    
    public void generateOutputFile (String inputFilePath, String outputFilePath);
}
