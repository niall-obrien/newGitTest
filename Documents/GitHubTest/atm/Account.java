package atm;


public class Account{
	private String account_Number;
	private char[] pinNo;
	private String firstName;
	private String lastName;
	private float balance;

	public Account(String account_Number, char[] pinNo, String firstName, String lastName, float balance){
		this.account_Number = account_Number;
		this.pinNo = pinNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public void setPin(char[] pinNo){
		this.pinNo = pinNo;
	}

	public char[] getPin(){
		return pinNo;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setBalance(float balance){
		this.balance = balance;
	}

	public float getBalance(){
		return balance;
	}
}