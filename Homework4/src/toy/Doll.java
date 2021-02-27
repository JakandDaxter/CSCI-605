package toy;

/**
 * The Doll class extends the FigureTypeToy abstract class
 * Constructor inherits from superclass to create Doll objects
 * It generates unique product codes and returns a String representation for
 * each created Doll
 */

public class Doll extends FigureTypeToy{

    public Doll() {
        super(3);
    }

    /**
     * Method to obtain string representation of Doll
     * @return string representation of Doll
     */

    public String toString() {
        return super.toString()
                +"]";
    }
}
