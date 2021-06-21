/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.Console;


/**
 *
 * @author niallobrien
 */
public class ATM {
    
    Scanner scanner = new Scanner(System.in);
		Account[] accounts = new Account[3];
		char[] pinNoEntered;
		float amountToWithdraw;
    
    public static void main(String[] args) {
        ATM obj = new ATM();
            obj.createAccounts();

            do{
                System.out.println("\n**************************************************");
                System.out.println("**********Welcome to the Bank of Duke*************");
                obj.validatePINNo();
            }while(true);

    }

    public void createAccounts(){
    	accounts[0] = new Account("45646432", new char[]{'3', '4', '3', '5'}, "Julian", "King", 100);
    	accounts[1] = new Account("48593741", new char[]{'8', '2', '4', '6'}, "Anne", "Williams", 200);
    	accounts[2] = new Account("15432432", new char[]{'6', '1', '5', '7'}, "Derek", "James", 300);
    }

    public void validatePINNo(){
        Console console = System.console();
        boolean pinFound = false;

        do{
            System.out.print("\nEnter your PIN no.: ");
            pinNoEntered = console.readPassword();

            for(Account account:accounts){
                if((Arrays.toString(pinNoEntered).equals(Arrays.toString(account.getPin())))){
                    pinFound = true;
                    break;
                }
            }
            if (!pinFound){
                System.out.println("Invlaid PIN no. entered.");
            }else{
                System.out.println("PIN validated.");
                requestWithdrawal();
            }
        }while(pinFound != true);
    }

    public void requestWithdrawal(){
        boolean validWithdrawal = false;
        int withdrawalAmounts[] = {20, 40, 60, 80, 100, 200};

        System.out.println("The maximum withdrawal amount is €200.");
        System.out.println("Enter an amount: 20 | 40 | 60 | 80 | 100 | 200");

        do{
            System.out.println("\nEnter amount to withdraw: ");
            try{
                amountToWithdraw = scanner.nextInt();

                for(int valid_amount:withdrawalAmounts){
                    if(valid_amount == amountToWithdraw){
                        validWithdrawal = true;
                        break;
                    }
                }

                    if(!validWithdrawal){
                        System.out.println("Invlaid data entered.");
                    }

            }catch(InputMismatchException e){
                System.out.println("Data entry must be numeric and must contain a decimal point.");
                scanner.nextLine();
            }
        }while(validWithdrawal != true);
            makeWithdrawal();
            scanner.nextLine();
		
	}

    public void makeWithdrawal(){
        for(Account account:accounts){
    		if((Arrays.toString(pinNoEntered). equals(Arrays.toString(account.getPin())))){
                if(account.getBalance() >= amountToWithdraw){
                    System.out.println("Cash dispensed: " + amountToWithdraw);
                            
                    account.setBalance((account.getBalance() - amountToWithdraw));
                            
                    System.out.println("Your new balance is: " + account.getBalance());
                    System.out.println("Have a nice day.");
                }else{
                    System.out.println("Insufficient funds.");
                    System.out.println("Existing Balance: " + account.getBalance());
                    System.out.println("Have a nice day.");
                }         
            }
        }
    }   
}
