import java.util.LinkedList;
import java.util.List;

public class app {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();
        String file = "NewBankAccounts.csv";

        // Read a CSV
        List<String[]> newAccountHolder = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolder) {
            System.out.println("NEW ACCOUNT");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc: accounts) {
            System.out.println("\n****************");
            acc.showInfo();
        }
    }
}
