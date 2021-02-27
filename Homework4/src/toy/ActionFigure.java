package toy;

/**
 * The ActionFigure class extends the FigureTypeToy abstract class
 * Constructor inherits from superclass to create ActionFigure objects
 * It generates unique product codes and returns a string representation for
 * each created ActionFigure
 */

public class ActionFigure extends FigureTypeToy{

    private boolean kungFuGrip;

    public ActionFigure(){
        super(5);
    }

    /**
     * Check and set the ActionFigure's KungFu grip
     * @return kungFuGrip
     * @return getSpeedString
     */

    public boolean isKungFuGrip() {
        return kungFuGrip;
    }

    public void setKungFuGrip(boolean kungFuGrip) {
        this.kungFuGrip = kungFuGrip;
    }

    /**
     * Method to obtain string representation of ActionFigure, including kungFuGrip status
     * @return string representation of ActionFigure
     */

    public String toString() {
        return super.toString()
                +", kung-fu grip="+this.isKungFuGrip()
                +"]";
    }
}
