import java.util.Scanner;

/*Initially, we will add some (N) customers to the bank and then we can display all account details using menu 
1), menu
2) is used to search the bank account, menu 
3) is used to deposit money in particular account, menu 
4) is used to manager withdrawal and menu 5) is used to exit from the program.*/


class Bank {
    private String accno;
    private String name;
    private long balance;

    Scanner KB = new Scanner(System.in);
  //This is a method to open an account
    void openAccount() {
        System.out.print("Enter Account No: ");
        accno = KB.next();
        System.out.print("Enter Name: ");
        name = KB.next();
        System.out.print("Enter Balance: ");
        balance = KB.nextLong();
    }

    //This is a method to display account details
    void showAccount() {
        System.out.println(accno + "," + name + "," + balance);
    }
    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
    }
    //This is a method to withdraw money
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }
  //This is a method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
public class ExBank {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);

        //To create initial accounts
        System.out.print("How Many Customer U Want to Input : ");
        int n = KB.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }
      //By using switch we can perform actions like main menu , display all, deposit ,withdrawal and finally exit
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
                System.out.println("Ur Choice :"); ch = KB.nextInt();
                switch (ch) {
                   case 1:  /*This case is used to perform display all function*/
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;
                   case 2: //This case is used to search account exist or not
                	   System.out.print("Enter Account No U Want to Search...: ");
                	                          String acn = KB.next();
                	                          boolean found = false;
                	                          for (int i = 0; i < C.length; i++) {
                	                              found = C[i].search(acn);
                	                              if (found) {
                	                                  break;
                	                              }
                	                          }
                	                          if (!found) {
                	                              System.out.println("Search Failed..Account Not Exist..");
                	                          }
                	                          break;
                   case 3: //This case is used to perform deposit operation
                       System.out.print("Enter Account No : ");
                       acn = KB.next();
                       found = false;
                       for (int i = 0; i < C.length; i++) {
                           found = C[i].search(acn);
                           if (found) {
                               C[i].deposit();
                               break;
                           }
                       }
                       if (!found) {
                           System.out.println("Search Failed..Account Not Exist..");
                       }
                       break;
                   case 4: //This case is used to perform withdrawal operation
                       System.out.print("Enter Account No : ");
                       acn = KB.next();
                       found = false;
                       for (int i = 0; i < C.length; i++) {
                           found = C[i].search(acn);
                           if (found) {
                               C[i].withdrawal();
                               break;
                           }
                       }
                       if (!found) {
                           System.out.println("Search Failed..Account Not Exist..");
                       }
                       break;
                   case 5:
                       System.out.println("Good Bye..");
                       break;
               }
           }
           while (ch != 5);
       }
   }

