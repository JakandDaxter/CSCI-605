package toy;

public abstract class FigureTypeToy extends Toy{

    private String hairColor;
    private String eyeColor;

    protected FigureTypeToy(int productUniqueCode) {
        super(productUniqueCode);
    }

    protected String getHairColor() {
        return hairColor;
    }

    protected void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    protected String getEyeColor() {
        return eyeColor;
    }

    protected void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Override
    public void play() {
        this.degrade();
        this.printCondition(this.getConditionString());
    }

    public String toString() {
        return super.toString()
                +" hair color="+this.getHairColor()
                +", eye="+this.getEyeColor();
    }
}
