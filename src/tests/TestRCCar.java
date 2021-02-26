package tests;


import org.junit.Before;
import org.junit.Test;
import toy.BatteryType;
import toy.RCCar;
import toy.Condition;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertEquals;

public class TestRCCar {

    RCCar car;


    @Before
    public void init() {
        car = new RCCar();
        car.setName("Gizmovine RC");
        car.setProductCode(6129624);
        car.setMSRP(159.99);
        car.setBatteryType(BatteryType.D);
        car.setNumberOfBattery(10);
        car.setSpeed(300);
    }

    //****Testing Condition***\\
    @Test
    public void testCondition(){
        assertEquals(car.getCondition(), Condition.MINT);
        car.play();
        assertEquals(car.getCondition(),Condition.NEAR_MINT);
    }

    //****Testing ToString***\\
    @Test
    public void testToString(){
        assertEquals("Gizmovine RC [product code=6129624, MSRP=159.99, condition=MINT, resale value=159.99, battery type=D, number of batteries=10, battery level=100, speed=300]",car.toString());
    }

    //****Testing Odometer***\\
    @Test
    public void testResaleValue(){
        BigDecimal bop = BigDecimal.valueOf(Condition.NEAR_MINT.getMultiplier() * 159.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);

        assertEquals(159.99,car.getResaleValue());
        car.play();
        assertEquals(bop.doubleValue(),car.getResaleValue());
        car.play();
        car.play();
        car.play();
        bop = BigDecimal.valueOf(Condition.FAIR.getMultiplier() * 159.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);
        assertEquals(bop.doubleValue(),car.getResaleValue());
    }
}
