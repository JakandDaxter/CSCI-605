package toy;

public class ActionFigure extends FigureTypeToy{

    private boolean kungFuGrip;

    public ActionFigure(){
        super(5);
    }

    public boolean isKungFuGrip() {
        return kungFuGrip;
    }

    public void setKungFuGrip(boolean kungFuGrip) {
        this.kungFuGrip = kungFuGrip;
    }

    public String toString() {
        return super.toString()
                +", kung-fu grip="+this.isKungFuGrip()
                +"]";
    }
}
