import java.util.Scanner;
import java.util.ArrayList;
public class ListMaker {
    //Use myArrList variable to store items inputted
        private static ArrayList<String> myArrList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            displayMenu();
            //Display the menu, and prompt user for input
            String choice = SafeInput.getRegExString(in,"Enter your choice (A/D/P/Q):", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                //Add an item
                case "A":
                    addItem(in);
                    break;
                    //Delete an item
                    case "D":
                        deleteItem(in);
                    //Display a list
                    case "P":
                        displayList();
                    //Get confirmation of quitting
                    case "Q":
                    if (confirmQuit(in)) {
                        System.out.println("Goodbye!");
                        in.close();
                        return;
                    }
                    break;
            }
        }
    }
    //Display Menu
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add Item to the list");
        System.out.println("D - Delete Item from the list");
        System.out.println("P - Display List");
        System.out.println("Q - Quit");
    }
    // Add an item
    private static void addItem(Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item: ");
        myArrList.add(item);
        System.out.println(item + "Item added to the list!");
    }
    //Delete an item
    private static void deleteItem(Scanner in) {
        if (myArrList.isEmpty()) {
            System.out.println("You don't have any items to delete");
            return;
        }
        displayList();
        int itemIndex = SafeInput.getRangedInt(in, "Enter item to delete:", 1, myArrList.size());
        String deletedItem = myArrList.remove(itemIndex - 1);
        System.out.println("Item " + deletedItem + " was deleted from the list");
    }
    //Display the list
    private static void displayList() {
        if (myArrList.isEmpty()) {
            System.out.println("You don't have any items to display");
        }
        else {
            System.out.println("\nCurrent list:");
            for (int  i = 0; i < myArrList.size(); i++) {
                System.out.println((i + 1) + ". " + myArrList.get(i));
            }
        }
    }
    //Ask user if they would like to continue or quit
    private static boolean confirmQuit(Scanner in) {
        char response = SafeInput.getYNConfirm(in, "Are you sure you want to quit? (yes/no)");
        return response == 'y';
    }
}
