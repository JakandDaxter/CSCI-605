package tests;

import org.junit.Before;
import org.junit.Test;
import toy.Condition;
import toy.Doll;
import toy.ToyFactory;
import toy.FigureTypeToy;
import toy.Toy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class TestDoll {

    Toy toy;
    Doll doll;
    FigureTypeToy figuretoy;

    @Before
    public void init() {
        doll = new Doll();
        doll.setName("Julio");
        doll.setProductCode(3654949);
        doll.setMSRP(60.99);
        doll.setHairColor("Purple");
        doll.setEyeColor("Black");
    }

    /***Testing Condition***/

    @Test
    public void testCondition(){
        assertEquals(doll.getCondition(), Condition.MINT);
        doll.play();
        assertEquals(doll.getCondition(),Condition.NEAR_MINT);
    }

    /***Testing ToString***/

    @Test
    public void testToString(){
        assertEquals("Julio [product code=3654949, MSRP=60.99, condition=MINT, resale value=60.99 hair color=Purple, eye=Black]",doll.toString());
    }

    /****Testing Odometer***/

    @Test
    public void testResaleValue(){
        BigDecimal bop = BigDecimal.valueOf(Condition.NEAR_MINT.getMultiplier() * 60.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);

        assertEquals(60.99,doll.getResaleValue());
        doll.play();
        assertEquals(bop.doubleValue(),doll.getResaleValue());
        doll.play();
        doll.play();
        doll.play();
        bop = BigDecimal.valueOf(Condition.FAIR.getMultiplier() * 60.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);
        assertEquals(bop.doubleValue(),doll.getResaleValue());
    }


}
