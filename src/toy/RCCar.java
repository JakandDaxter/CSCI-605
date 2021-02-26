package toy;

public class RCCar extends BatteryPoweredToy{

    private int speed;

    public RCCar(){
        super(25,6);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void play() {
        this.degrade();
        this.printCondition(this.getConditionString(this.getSpeedString()));
    }

    private String getSpeedString(){
        return this.getName()+" races in circles at "+getSpeed()+" mph!";
    }

    public String toString() {
        return super.toString()+", speed="+this.speed+"]";
    }
}
