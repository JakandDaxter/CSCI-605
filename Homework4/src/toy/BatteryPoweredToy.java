package toy;

public abstract class BatteryPoweredToy extends Toy {

    private final int batteryLevelDeplete;
    private BatteryType batteryType;
    private int numberOfBattery;
    private int batteryLevel;

    protected BatteryPoweredToy(int batteryLevelDeplete,int productUniqueCode){
        super(productUniqueCode);
        this.batteryLevelDeplete = batteryLevelDeplete;
        this.batteryLevel = 100;
    }

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

    protected void degrade(){
        super.degrade();
        this.batteryLevel -= batteryLevelDeplete;
    }

    protected String getConditionString(String moreConditionString){
        return moreConditionString+"\n"+this.getConditionString();
    }

    public String toString(){
        return super.toString()
            +", battery type="+this.batteryType.name()
            +", number of batteries="+this.numberOfBattery
            +", battery level="+this.batteryLevel;
    }
}
