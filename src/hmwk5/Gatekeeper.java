package hmwk5;

import java.util.Scanner;


/**
 * The hmwk5.Gatekeeper class is the program's main entry point and prompts users for input
 * Users would be required to select from a list of options to (1) add a patron to the club queue
 * (2) admit a patron based on certain variables (3) close the club
 */

public class Gatekeeper {

    /**
     * Create priority heap queue
     */

    //hmwk5.HeapQueue<hmwk5.Patron> heap = new hmwk5.HeapQueue<hmwk5.Patron>();
    LinkedQueue<Patron> heap = new LinkedQueue<Patron>();

    /**
     * The main class prompts users to select one of three options:
     * ( 1 - Add a patron, 2 - Admit the highest priority patron, 3 - Close for the night)
     * after which it proceeds to validate every input to ensure data integrity
     */

    public static void main(String[] args) {
        Gatekeeper g = new Gatekeeper();
        boolean valid = true;
        Scanner scan = new Scanner(System.in);

        /**
         * Loop to receive and validate user input
         */

        do{
        scan.reset();
        valid = true;
        System.out.println("Enter an option");
        System.out.println(
                """
                        1 : Add a patron to the queue
                        2 : Admit the highest priority patron
                        3 : Close for the night (Quit)
                """
        );
        System.out.print("Your choice: ");
        String input = scan.nextLine();
        try{

            scan.reset();
            int choice = Integer.parseInt(input);

            /**
             * If user selects Option 1, call the addPatron() method
             */

            switch (choice) {
                case 1 -> {
                    g.addPatron();
                    valid = false;
                }

                /**
                 * If user selects Option 2, check first to see if queue is empty
                 * If not, call the removePatron() method
                 */

                case 2 -> {
                    if(g.heap.isEmpty()){
                        System.out.println("Queue is empty.");
                        valid = false;
                    }else{
                        g.removePatron();
                    valid = false;
                    }
                }

                /**
                 * If user selects Option 3, validate input
                 * Quit the program
                 */

                case 3 -> valid = true;
                default -> {
                    System.out.println("Invalid Input");
                    valid = false;
                }
            }

            /**
             * Return "Invalid Input" message if user enters incorrect input format
             */

        }catch (NumberFormatException e){System.out.println("Invalid Input"); valid = false;}

        }while(!valid);

    }

    /**
     * The addPatron() method requests and receives the patron name and coolness factor
     * After receiving all input the new patron is added to the queue
     */

    public void addPatron(){
        boolean regx = false;
        Scanner scan = new Scanner(System.in);

        System.out.print("hmwk5.Patron name: ");
        String name =  scan.nextLine();
        scan.reset();

        System.out.print("Coolness (1-10): ");
        int coolness =  scan.nextInt();
        scan.reset();

        regx = checkRegular();

        heap.enqueue(new Patron(coolness,regx,name));

    }

    /**
     * The checkRegular() method requests input regarding the patrons frequency at the club
     * User inputs "y" if patron is regular, "n" otherwise
     */

    public boolean checkRegular(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Regular (y/n): ");
        String reg = scan.nextLine();
        return reg.equals("y");
    }

    /**
     * The removePatron() method removes the highest priority patron from the queue and returns
     * their details. Also returns their regularity if patron is regular
     */

    public void removePatron(){
        Patron p = heap.dequeue();
        if(p.isRegular()){
            System.out.print("Regular " +p.getName() + " with coolness factor " + p.getCoolness() +" gets in!!!\n");
        }else{
            System.out.println(p.getName() + " with coolness factor " + p.getCoolness() +" gets in!!!\n");
        }

    }

}
