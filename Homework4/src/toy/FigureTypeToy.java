package toy;

/**
 * The FigureTypeToy abstract class is the super class for all toys that are figure-typed
 * It is a subclass of the Toy superclass
 * Class methods are implemented by the Doll and ActionFigure subclasses
 * Access modifiers are set at protected levels to ensure integrity
 */

public abstract class FigureTypeToy extends Toy{

    private String hairColor;
    private String eyeColor;

    /**
     * Constructor for FigureTypeToy abstract class
     * @param productUniqueCode
     */

    protected FigureTypeToy(int productUniqueCode) {
        super(productUniqueCode);
    }

    /**
     * Get and set the hair color and eye color
     * @return batteryLevel
     * @return batteryType
     * @return numberOfBattery
     */

    protected String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    protected String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Implement play method as defined by the IToy interface
     * Degrade FigureTypeToys and get their current condition
     */

    @Override
    public void play() {
        this.degrade();
        this.printCondition(this.getConditionString());
    }

    /**
     * Method to obtain string representation of FigureTypeToys including
     * hair color and eye color
     * @return string representation
     */

    public String toString() {
        return super.toString()
                +" hair color="+this.getHairColor()
                +", eye="+this.getEyeColor();
    }
}
