package toy;

public class Scooter extends Toy{

    private String color;

    private int wheels;

    private int odometer;

    public Scooter() {
        super(9);
    }

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

    @Override
    public void play() {
        //add two miles when scooter is played
        this.odometer+=2;

        //degrades the condition of the scooter
        this.degrade();

        //print the new condition
        this.printCondition(this.getConditionString());
    }

    private String getWheelString(){
        return (this.wheels==2)?"TWO":"THREE";
    }

    public String toString() {
        return super.toString()
                +" color="+this.color
                +", wheels="+this.getWheelString()
                +", odometer="+this.odometer
                +"]";
    }
}
