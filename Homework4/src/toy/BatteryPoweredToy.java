package toy;

/**
 * The BatteryPoweredToy abstract class is the super class for all toys that a battery-powered
 * It is a subclass of the Toy superclass
 * Class methods are implemented by the RCCar and Robot subclasses
 * Access modifiers are set at protected levels to ensure integrity
 */

public abstract class BatteryPoweredToy extends Toy {

    private final int batteryLevelDeplete;
    private BatteryType batteryType;
    private int numberOfBattery;
    private int batteryLevel;

    /**
     * Constructor for BatteryPoweredToy abstract class
     * @param batteryLevelDeplete
     * @param productUniqueCode
     */

    protected BatteryPoweredToy(int batteryLevelDeplete,int productUniqueCode){
        super(productUniqueCode);
        this.batteryLevelDeplete = batteryLevelDeplete;
        this.batteryLevel = 100;
    }

    /**
     * Get and set the battery level, battery type, number of batteries
     * @return batteryLevel
     * @return batteryType
     * @return numberOfBattery
     */

    protected int getBatteryLevel() {
        return batteryLevel;
    }

    protected BatteryType getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(BatteryType batteryType) {
        this.batteryType = batteryType;
    }

    protected int getNumberOfBattery() {
        return numberOfBattery;
    }

    public void setNumberOfBattery(int numberOfBattery) {
        this.numberOfBattery = numberOfBattery;
    }

    /**
     * Method to degrade battery level
     */

    protected void degrade(){
        super.degrade();
        this.batteryLevel -= batteryLevelDeplete;
    }

    protected String getConditionString(String moreConditionString){
        return moreConditionString+"\n"+this.getConditionString();
    }

    /**
     * Method to obtain string representation of battery-powered toys including
     * battery type, number of batteries, and battery level
     * @return string representation
     */

    public String toString(){
        return super.toString()
                +", battery type="+this.batteryType.name()
                +", number of batteries="+this.numberOfBattery
                +", battery level="+this.batteryLevel;
    }
}
