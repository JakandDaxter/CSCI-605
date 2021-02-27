package toy;

/**
 * The RCCar class extends the BatteryPoweredToy abstract class
 * Constructor inherits from superclass to create RCCar objects
 * It generates unique product codes and returns a String representation of
 * each created RCCar
 */

public class RCCar extends BatteryPoweredToy{

    private int speed;

    public RCCar(){
        super(25,6);
    }

    /**
     * Get and set the RCCar speed, and get the speed string
     * @return speed
     * @return getSpeedString
     */

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private String getSpeedString(){
        return this.getName()+" races in circles at "+getSpeed()+" mph!";
    }

    /**
     * Implement play method as defined by the IToy interface
     * Degrade RCCar after play, and print new condition
     */

    @Override
    public void play() {
        this.degrade();
        this.printCondition(this.getConditionString(this.getSpeedString()));
    }

    /**
     * Method to obtain string representation of RCCar, including its speed
     * @return string representation of RCCar
     */

    public String toString() {
        return super.toString()+", speed="+this.speed+"]";
    }
}
