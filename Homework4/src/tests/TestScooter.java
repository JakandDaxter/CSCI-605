package tests;

import org.junit.Before;
import org.junit.Test;
import toy.Condition;
import toy.Scooter;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertEquals;

public class TestScooter {

    Scooter scooter;

    @Before
    public void init() {
        scooter = new Scooter();
        scooter.setName("Mongoose Expo");
        scooter.setProductCode(9654949);
        scooter.setMSRP(160.99);
        scooter.setColor("Blue");
        scooter.setWheels(2);
    }

    /***Testing Condition***/

    @Test
    public void testCondition(){
        assertEquals(scooter.getCondition(), Condition.MINT);
        scooter.play();
        assertEquals(scooter.getCondition(),Condition.NEAR_MINT);
    }

    /***Testing Odometer***/

    @Test
    public void testOdometer(){
        assertEquals( 0,scooter.getOdometer());
        scooter.play();
        assertEquals(2,scooter.getOdometer());
        scooter.play();
        assertEquals(4,scooter.getOdometer());
        scooter.play();
        assertEquals(6,scooter.getOdometer());
        scooter.play();
        assertEquals(8,scooter.getOdometer());
        scooter.play();
        assertEquals(10,scooter.getOdometer());
    }

    /***Testing ToString***/

    @Test
    public void testToString(){
        assertEquals("Mongoose Expo [product code=9654949, MSRP=160.99, condition=MINT, resale value=160.99 color=Blue, wheels=TWO, odometer=0]",scooter.toString());
    }

    /***Testing Odometer***/

    @Test
    public void testResaleValue(){
        BigDecimal bop = BigDecimal.valueOf(Condition.NEAR_MINT.getMultiplier() * 160.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);

        assertEquals(160.99,scooter.getResaleValue());
        scooter.play();
        assertEquals(bop.doubleValue(),scooter.getResaleValue());
        scooter.play();
        scooter.play();
        scooter.play();
        bop = BigDecimal.valueOf(Condition.FAIR.getMultiplier() * 160.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);
        assertEquals(bop.doubleValue(),scooter.getResaleValue());
    }


}
