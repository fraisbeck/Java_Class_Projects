package java112.labs1;

/** Mystery Class Lab - our first TDD of the semester
 * @author fraisbeck
 */

public class MysteryClassOne {
    /** run our MysteryClassOne program - outputting the
     * result from mysteryMethodOne
     * @param args command line arguments
     */
    public static void main(String[] args) {
        MysteryClassOne demo = new MysteryClassOne();
        System.out.println("The value is " + demo.mysteryMethodOne());
    }
    /* adding method to pass the next test
    */
   public int mysteryMethodOne() {
       return 1;
   }
}
