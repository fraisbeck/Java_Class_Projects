package java112.labs1;

/** LabThree class continues practice with TDD
 * @author fraisbeck
 */

public class LabThree {
    /** main method to run our program
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            LabThree lab = new LabThree();
            lab.run(args[0]);
        }
    }
    /** run
     */
    public void run (String myString) {
        System.out.println("input: " + myString);
    }
}
