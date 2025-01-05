
/**
 *
 * @author Peter
 */
public class NextAIInc {

    
    public static void calculateWeeklyPay(int basePay, int hoursWorked) {
        
      
        if (basePay < 30000) {
            System.out.println("Error: Base pay is below the minimum required rate.");
            return;
        }
        
       
        if (hoursWorked > 72) {
            System.out.println("Error: Hours worked exceed the maximum limit of 72 hours.");
            return;
        }
        
        
        int regularHours = Math.min(hoursWorked, 48); 
        int overtimeHours = Math.max(0, hoursWorked - 48); 
        
        
        int regularPay = regularHours * basePay;
        int overtimePay = overtimeHours * 2 * basePay; 
        int totalPay = regularPay + overtimePay;
        
       
        System.out.println("Total weekly pay: UGX " + totalPay);
    }

    public static void main(String[] args) {
       
        System.out.println("Contractor A:");
        calculateWeeklyPay(30000, 51); 

        System.out.println("\nContractor B:");
        calculateWeeklyPay(20000, 40); 

        System.out.println("\nContractor C:");
        calculateWeeklyPay(35000, 96); 
    }
}