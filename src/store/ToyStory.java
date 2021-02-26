package store;

import toy.IToy;

/**
 * Runs a simulation during which a toy store is stocked with toys and each
 * customer 1.) purchases a toy, 2.) plays with it (degrading its condition),
 * and 3.) sells it back to the store whereupon it is discarded if broken. The
 * simulation runs until the store is out of stock.
 */
public class ToyStory {

    /**
     * Run the simulation for the given amount of toys
     *
     * @param numberOfToys The number of toys in the toy store
     */
    private static void simulate(int numberOfToys) {
        // create the toy store and stock it
        AlsToyBarn store = new AlsToyBarn();
        store.stockStore(numberOfToys);

        // run the simulation
        while (store.availableStock() > 0) {
            IToy toy = store.purchaseToy();
            System.out.println("The next customer purchases " + toy +
                    " and begins to play with it...");
            toy.play();
            double resaleValue = store.addToy(toy);
            System.out.println(String.format("The customer grows bored with " +
                    "the toy and trades it in for $%.2f", resaleValue));
        }
        System.out.println("The toy store is out of stock! Time to close!");
    }

    /**
     * Runs the simulation.
     *
     * @param args Specifies a number of toys (integer).
     */
    public static void main(String[] args) {
        /*if (args.length != 1) {
            System.err.println("usage: java store.ToyStory <number of toys>");
            System.exit(1);
        }*/

        // use the command line argument to determine the number of toys
        int numberOfToys = 10;
                //Integer.parseInt(args[0]);

        // run the simulation
        simulate(numberOfToys);
    }
}
