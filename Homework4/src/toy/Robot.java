package toy;

/**
 * The Robot class extends the BatteryPoweredToy abstract class
 * Constructor inherits from superclass to create Robot objects
 * It generates unique product codes and returns a String representation of
 * each created Robot
 */

public class Robot extends BatteryPoweredToy{


    private String sound;

    public Robot(){
        super(15,7);
    }

    /**
     * Get and set the Robot sound, and get the sound string
     * @return speed
     * @return getSpeedString
     */

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    private String getSoundString(){
        return this.getName()+" goes "+this.getSound()+"!";
    }

    /**
     * Implement play method as defined by the IToy interface
     * Degrade Robot after play, and print new condition
     */

    @Override
    public void play() {
        this.degrade();
        this.printCondition(this.getConditionString(this.getSoundString()));
    }

    /**
     * Method to obtain string representation of Robot, including its sound
     * @return string representation of Robot
     */

    public String toString() {
        return super.toString()+", sound="+this.sound+"]";
    }
}
