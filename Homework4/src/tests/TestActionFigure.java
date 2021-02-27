package tests;

import org.junit.Before;
import org.junit.Test;
import toy.Condition;
import toy.ActionFigure;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertEquals;

public class TestActionFigure {

    ActionFigure figure;


    @Before
    public void init() {
        figure = new ActionFigure();
        figure.setName("Bruce");
        figure.setProductCode(5654949);
        figure.setMSRP(24.99);
        figure.setHairColor("Blond");
        figure.setEyeColor("Green");
        figure.setKungFuGrip(true);
    }

    //****Testing Condition***\\
    @Test
    public void testCondition(){
        assertEquals(figure.getCondition(), Condition.MINT);
        figure.play();
        assertEquals(figure.getCondition(),Condition.NEAR_MINT);
    }

    //****Testing ToString***\\
    @Test
    public void testToString(){
        assertEquals("Bruce [product code=5654949, MSRP=24.99, condition=MINT, resale value=24.99 hair color=Blond, eye=Green, kung-fu grip=true]",figure.toString());
    }

    //****Testing Odometer***\\
    @Test
    public void testResaleValue(){
        BigDecimal bop = BigDecimal.valueOf(Condition.NEAR_MINT.getMultiplier() * 24.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);

        assertEquals(24.99,figure.getResaleValue());
        figure.play();
        assertEquals(bop.doubleValue(),figure.getResaleValue());
        figure.play();
        figure.play();
        figure.play();
        bop = BigDecimal.valueOf(Condition.FAIR.getMultiplier() * 24.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);
        assertEquals(bop.doubleValue(),figure.getResaleValue());
    }
}
