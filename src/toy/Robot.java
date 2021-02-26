package toy;

public class Robot extends BatteryPoweredToy{


    private String sound;

    public Robot(){
        super(15,7);
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public void play() {
        this.degrade();
        this.printCondition(this.getConditionString(this.getSoundString()));
    }

    private String getSoundString(){
        return this.getName()+" goes "+this.getSound()+"!";
    }

    public String toString() {
        return super.toString()+", sound="+this.sound+"]";
    }
}
