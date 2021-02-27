package toy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * The Toy abstract class is a super class that implements the IToy interface
 * Class methods are directly implemented by the BatteryPoweredToy, FigureTypeToy, and Scooter subclasses
 * Access modifiers are set at protected levels to ensure integrity
 */

public abstract class Toy implements IToy{

    private final int SEVEN_DIGIT = 1000000;
    private int productCode;
    private String name;
    private double MSRP;
    private Condition condition;

    /**
     * Constructor for Toy abstract class
     * Sets initial condition of toys, generates unique product codes
     * @param productUniqueCode
     */

    protected Toy(int productUniqueCode){
        this.condition = Condition.MINT;
        this.productCode = productUniqueCode*SEVEN_DIGIT+new Random().nextInt(999999);
    }

    /**
     * Get and set the toy name, MSRP, product code
     * @return product code
     * @return MSRP
     * @return name
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setMSRP(double MSRP) {
        this.MSRP = MSRP;
    }

    @Override
    public int getProductCode() {
        return this.productCode;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getMSRP() {
        return this.MSRP;
    }

    /**
     * Method to get resale value
     * @return bop value
     */

    @Override
    public double getResaleValue() {
        BigDecimal bop = new BigDecimal(this.MSRP*this.condition.getMultiplier());
        bop = bop.setScale(2, RoundingMode.HALF_UP);
        return bop.doubleValue();
    }

    /**
     * Get toy condition
     * @return condition
     */

    @Override
    public Condition getCondition() {
        return this.condition;
    }

    /**
     * Implement play method as defined by the IToy interface
     */

    @Override
    public abstract void play();

    /**
     * Degrade condition of toy after play
     */

    protected void degrade(){
        this.condition = this.condition.degrade();
    }

    /**
     * Get string representation of toy condition
     * @return string representation of toy condition
     */

    protected String getConditionString(){
        return "After plays "+this.name+" condition is "+this.condition.name();
    }

    /**
     * Print toy condition string
     */

    protected void printCondition(String conditionString){
        System.out.println(conditionString);
    }

    /**
     * Get string representation of toy
     * @return name, product code, MSRP, condition and resale value
     */

    public String toString(){
        return this.name
             +" [product code="+this.productCode
             +", MSRP="+this.MSRP
             +", condition="+this.condition
             +", resale value="+String.format("%.2f",this.getResaleValue());
    }

    /**
     * Set toy's product code
     */

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
}
