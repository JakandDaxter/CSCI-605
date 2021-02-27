package toy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public abstract class Toy implements IToy{

    private final int SEVEN_DIGIT = 1000000;

    private int productCode;

    private String name;

    private double MSRP;

    private Condition condition;

    protected Toy(int productUniqueCode){
        this.condition = Condition.MINT;
        this.productCode = productUniqueCode*SEVEN_DIGIT+new Random().nextInt(999999);
    }

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

    @Override
    public double getResaleValue() {
        BigDecimal bop = new BigDecimal(this.MSRP*this.condition.getMultiplier());
        bop = bop.setScale(2, RoundingMode.HALF_UP);
        return bop.doubleValue();
    }

    @Override
    public Condition getCondition() {
        return this.condition;
    }

    @Override
    public abstract void play();

    protected void degrade(){
        this.condition = this.condition.degrade();
    }

    protected String getConditionString(){
        return "After plays "+this.name+" condition is "+this.condition.name();
    }

    protected void printCondition(String conditionString){
        System.out.println(conditionString);
    }

    public String toString(){
        return this.name
             +" [product code="+this.productCode
             +", MSRP="+this.MSRP
             +", condition="+this.condition
             +", resale value="+String.format("%.2f",this.getResaleValue());
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
}
