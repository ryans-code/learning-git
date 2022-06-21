import java.util.Scanner;
import java.lang.Math;

public class Budget {

    /*
     * Method: displayBudget
     * The method, displayBudget, prints a table of categories to the screen.
     * Takes an array of Category Class as an argument.
     * Returns nothing.
     */
    public static void displayBudget(Category budgetArray[]) {
        System.out.println("     Category             Allocated     Spent   Amt over");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < budgetArray.length; i++) {
            System.out.println("  " + (i + 1) + ". "
                    + String.format("%-22s %7s %9s %9s", budgetArray[i].getName(),
                            String.format("%.2f", budgetArray[i].getAlloc()),
                            String.format("%.2f", budgetArray[i].getSpent()),
                            String.format("%.2f", (budgetArray[i].getSpent() - budgetArray[i].getAlloc()))));
        }
    }

    /*
     * Method: userNumPrompt
     * The method, userNumPrompt, displays a prompt to the screen for the user to
     * input an integer.
     * A scanner is used to read the user's input. The user's input is assigned as a
     * variable and returned.
     * Takes an object of Scanner Class as an argument to read user input.
     * Returns an integer.
     */
    public static int userNumPrompt(Scanner scanner) {
        System.out.println(
                "Enter the number of a category to record money spent or 7 to display the table or 8 to quit.");
        int userNum = scanner.nextInt();

        while (userNum < 1 || userNum > 8) {
            System.out.println("Enter a valid number: ");
            userNum = scanner.nextInt();
        }
        return userNum;
    }

    /*
     * Method: process
     * The method, process, displays a prompt to the screen for the user to input an
     * amount.
     * A scanner is used to read the user's input. The user's input is then added to
     * the 'spent' property of the category.
     * Takes an integer, num, as an argument, to specify which category to access.
     * Take an object of Scanner Class as an argument to read user input.
     * Takes an array of Category Class as an argument.
     * Returns nothing.
     */
    public static void process(int num, Scanner scanner, Category budgetArray[]) {
        System.out.print("Please enter the amount to add to that category: ");
        double value = scanner.nextDouble();

        budgetArray[num - 1].setSpent(budgetArray[num - 1].getSpent() + value);
    }

    /*
     * Method: calcBudget
     * The method, calcBudget, calculates the difference between the 'spent'
     * property and 'allocated' property.
     * Takes an array of Category Class as an argument.
     * Returns a double.
     */
    public static double calcBudget(Category budgetArray[]) {
        double endAmt = 0.0;
        for (int i = 0; i < budgetArray.length; i++)
            endAmt = endAmt + (budgetArray[i].getSpent() - budgetArray[i].getAlloc());

        return endAmt;
    }

    public static void main(String[] args) {

        // initialize array of Category Class objects
        Category[] budgetArray = {
                new Category("Housing", 500.00, 0.00),
                new Category("Utilities", 150.00, 0.00),
                new Category("Transportation", 50.00, 0.00),
                new Category("Food", 250.00, 0.00),
                new Category("Entertainment", 150.00, 0.00),
                new Category("Miscellaneous", 50.00, 0.00)
        };

        Scanner scanner = new Scanner(System.in);
        int num = userNumPrompt(scanner); // read in user's input

        while (num != 8) { // '8' is used to quit
            if (num == 7) // if user's input is '7', display table
                displayBudget(budgetArray);
            else // if user's input is '1-6', process user's request
                process(num, scanner, budgetArray);

            num = userNumPrompt(scanner); // prompt user to continue
        }
        if (num == 8) { // user has opted to quit
            if (calcBudget(budgetArray) > 0)
                System.out.println(
                        "For the month, you are over budget by $" + String.format("%.2f", calcBudget(budgetArray)));
            else
                System.out.println("For the month, you are under budget by $"
                        + String.format("%.2f", Math.abs(calcBudget(budgetArray))));
        }

        scanner.close();
    }
}