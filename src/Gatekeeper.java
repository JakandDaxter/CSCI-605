import java.util.InputMismatchException;
import java.util.Scanner;

public class Gatekeeper {

    HeapQueue<Patron> heap = new HeapQueue<Patron>();

    public static void main(String[] args) {
        Gatekeeper g = new Gatekeeper();
        boolean valid = true;
        Scanner scan = new Scanner(System.in);

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

            switch (choice) {
                case 1 -> {
                    g.addPatron();
                    valid = false;
                }
                case 2 -> {
                    if(g.heap.isEmpty()){
                        System.out.println("Queue is empty.");
                        valid = false;
                    }else{
                        g.removePatron();
                    valid = false;
                    }
                }
                case 3 -> valid = true;
                default -> {
                    System.out.println("Invalid Input");
                    valid = false;
                }
            }
        }catch (NumberFormatException e){System.out.println("Invalid Input"); valid = false;}

        }while(!valid);

    }

    public void addPatron(){
        boolean regx = false;
        Scanner scan = new Scanner(System.in);

        System.out.print("Patron name: ");
        String name =  scan.nextLine();
        scan.reset();

        System.out.print("Coolness (1-10): ");
        int coolness =  scan.nextInt();
        scan.reset();

        regx = checkRegular();

        heap.enqueue(new Patron(coolness,regx,name));

    }

    public boolean checkRegular(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Regular (y/n): ");
        String reg = scan.nextLine();
        return reg.equals("y");
    }

    public void removePatron(){
        Patron p = heap.dequeue();
        if(p.isRegular()){
            System.out.print("Regular " +p.getName() + " with coolness factor " + p.getCoolness() +" gets in!!!\n");
        }else{
            System.out.println(p.getName() + " with coolness factor " + p.getCoolness() +" gets in!!!\n");
        }
    }

}
