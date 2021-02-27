package toy;

/**
 * The Scooter class extends the Toy abstract class
 * Constructor inherits from superclass to create Scooter objects
 * It generates unique product codes and returns a String representation of
 * each created Scooter
 */

public class Scooter extends Toy{

    private String color;
    private int wheels;
    private int odometer;

    public Scooter() {
        super(9);
    }

    /**
     * Get and set the odometer, color, and wheels values
     * @return odometer, color, wheels
     * @return getWheelString
     */

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    private String getWheelString(){
        return (this.wheels==2)?"TWO":"THREE";
    }

    /**
     * Implement play method as defined by the IToy interface
     * Add two miles when Scooter is played with, degrade the condition
     * of the Scooter, and print new condition
     */

    @Override
    public void play() {

        this.odometer+=2;
        this.degrade();
        this.printCondition(this.getConditionString());

    }

    /**
     * Method to obtain string representation of Scooter, including its color, wheels, and odometer
     * @return string representation of Scooter
     */

    public String toString() {
        return super.toString()
                +" color="+this.color
                +", wheels="+this.getWheelString()
                +", odometer="+this.odometer
                +"]";
    }
}
