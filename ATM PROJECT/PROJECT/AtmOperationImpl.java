
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf{
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("\n~!!@@##  Available Balance is : "+atm.getBalance());

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%500==0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, "@@## Amount Withdrawn");
                System.out.println("@@##!!  Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("!!@@##  Insufficient Balance Sorry!!");
            }
        }
        else {
            System.out.println("## Sorry! Please enter the amount in multipal of 500");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount," \nAmount Deposited");
        System.out.println(depositAmount+" \n\nDeposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }

    }
}
