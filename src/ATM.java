import java.util.Scanner;

public class ATM
{
	public static void main(String[] args)
	{
		int choice,balance=100,account,searchResult;
		
		Scanner input=new Scanner(System.in);
		MainMenu menu=new MainMenu();
		ID id=new ID();
		

		
//		if (searchResult==0)
//		{
//			System.out.println("Enter a correct ID:");
//		}
//		else
//		{
//			System.out.println("The ID you entered is: "+searchResult);
//		}
		choice=0;
		
		while (true)
		{
			switch (choice)
			{
			case 0:
				System.out.print("Enter an ID: ");
				account=input.nextInt();
				searchResult=id.search(account);
				
				while (searchResult==0)
				{
					System.out.print("Enter a correct ID: ");
					account=input.nextInt();
					searchResult=id.search(account);
				}
				
				menu.showMenu();
				choice=input.nextInt();
				break;
			case 1:
				menu.check(balance);
				menu.showMenu();
				choice=input.nextInt();
				break;
			case 2:
				balance=menu.withdraw(balance, input);
				menu.showMenu();
				choice=input.nextInt();
				break;
			case 3:
				balance=menu.deposit(balance,input);
				menu.showMenu();
				choice=input.nextInt();
				break;
			case 4:
				menu.exit();
				choice=0;
				break;
			}
		}
	}
}

class ID
{
	int length;
	int [] ID;
	
	ID()
	{
		length=10;
		int [] ID=new int[length];
		for (int i=0;i<length;i++)
		{ID[i]=i;}
	}

	ID(int arrayLength)
	{
		length=arrayLength;
		int [] ID=new int [length];
		for (int i=0;i<length;i++)
		{ID[i]=i;}
	}
	
	public int search(int account)
	{
		//perform binary search
		int low, high, mid;
		
		low=0; high=length-1;
		
		while (high>=low)
		{
			mid=(high+low)/2;
			if (account<mid)
				high=mid-1;
			else if (account==mid)
			{
				return mid;
			}
			else
				low=mid+1;
		}
		return 0;
	}
}

class MainMenu
{
	//int menuBalance=balance;
	//int menuChoice=choice;
	
	public void showMenu()
	{
		System.out.println();
		System.out.println("Main menu");
		System.out.println("1: check balance");
		System.out.println("2: withdraw");
		System.out.println("3: deposit");
		System.out.println("4: exit");
		System.out.print("Enter a choice: ");
	}
	
	void check(int balance)
	{
		System.out.println("The balance is " + balance);
	}
	
	int withdraw(int balance, Scanner input)
	{
		System.out.println("Enter an amount to withdraw: ");
		return balance-input.nextInt();
	}

	int deposit(int balance, Scanner input)
	{
		System.out.println("Enter an amount to deposit: ");
		return balance+input.nextInt();
	}
	void exit()
	{
		System.out.println("Have a good day!");
		System.out.println();
	}
}