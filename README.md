# ATM
A simple Java program that simulates ATM machine.
![photo of a console running the programm](https://github.com/Anna-Little-Bird/ATM/blob/main/picture/ATM.jpg)

## Task
Create 10 accounts (ID 0, 1, …, 9) with initial balance $100. The program then prompts to enter an ID. If the ID is entered incorrectly a user is asked to enter the correct ID. Once the ID is accepted, the main menu is displayed. User can enter choices:
-	1 for viewing current balance
-	2 for withdrawing money
-	3 for depositing money
-	4 for exiting main menu.
After exiting, the system will prompt for entering the ID again, i.e. the program never stops.

## Program
The program consists of 3 classes:
•	ATM – the main program
•	ID – to store users’ IDs and perform a search
•	MainMenu – to show user interface

List of variables:
- input – instance of a Scanner object for showing data in the console
- menu – instance of MainMenu object for displaying the main menu
- id – instance of ID object for storing all IDs and performing a search
- choice – contains the current number of a state
- balance – stores current balance
- account – stores current ID number
- ID [] – array that contains all IDs
- searchResult – equals “1” if entered ID is in ID [] array, if not equals “0”

The main program was implemented through a state diagram shown below.

<state diagram to come>

The program starts at state 0, where the user is asked to type in an ID. The entered ID is then searched through the array ID []. In order to optimise the searching time the binary search is performed (in case if number of accounts is big). If the entered ID isn’t found, a message "Enter a correct ID: " is shown. This process will repeat until the correct ID is entered. Once it’s done, the main menu is shown and the user is asked to enter the desired choice. The program then moves to a state accordingly to the choice entered by the user. Each state ends up in showing the main menu with the prompt to enter a choice.

At state 1 the account balance is shown.
At state 2 the user is asked to enter the amount to withdraw from the account.
At state 3 the user is asked to enter the amount to deposit to the account.
At state 4 a goodbye message is shown and then the program goes back to state 0 where user is asked to enter the ID.

