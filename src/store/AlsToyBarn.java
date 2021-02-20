package store;

import toy.Condition;
import toy.IToy;
import toy.ToyFactory;

import java.util.LinkedList;
import java.util.Random;

/**
 * The Toy Store! It starts empty, but when stocked with toys, customers may
 * buy, play with, and sell the used toys back to the store.
 */
public class AlsToyBarn {
    /**
     * Used to generate randomInt numbers. Seed is hard coded to 1 for
     * "predictable randomness".
     */
    private static final Random RNG = new Random(1);

    /**
     * Using a linked list for more efficient remove from index 0.
     */
    private final LinkedList<IToy> stock;

    /**
     * Creates a new, empty toy store.
     */
    public AlsToyBarn() {
        stock = new LinkedList<>();
    }

    /**
     * Stocks the store with the specified number of toys produces by the
     * toy factory.
     *
     * @param numberOfToys The number of toys to make.
     */
    public void stockStore(int numberOfToys) {
        for (int i = 0; i < numberOfToys; i++) {
            int type = 1 + RNG.nextInt(5 - 1 + 1);
            addToy(ToyFactory.makeToy(type));
        }
    }

    /**
     * Adds the specified toy to the store's stock. If the toy is
     * {@link Condition#BROKEN broken}, it is discarded.
     *
     * @param toy The toy to add to the store's stock.
     * @return The resale value of the toy.
     */
    public double addToy(IToy toy) {
        if (toy.getCondition() == Condition.BROKEN) {
            System.out.println(toy + " is broken and discarded.");
        } else {
            System.out.println(toy + " is added to the stock.");
            stock.add(toy);
        }
        return toy.getResaleValue();
    }

    /**
     * A customer impulsively buys the first toy that they see; this method
     * removes and returns the first toy in the available stock.
     *
     * @return The first toy in the available stock.
     */
    public IToy purchaseToy() {
        return stock.remove(0);
    }

    /**
     * Returns a count of the toys available in the store's stock.
     *
     * @return The number of toys available in the store's stock.
     */
    public int availableStock() {
        return stock.size();
    }
}
