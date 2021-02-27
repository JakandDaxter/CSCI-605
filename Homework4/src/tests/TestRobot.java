package tests;

import org.junit.Before;
import org.junit.Test;
import toy.BatteryType;
import toy.Condition;
import toy.Robot;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertEquals;

public class TestRobot {

    Robot robot;

    @Before
    public void init() {
        robot = new Robot();
        robot.setName("Mechagodzilla");
        robot.setProductCode(7119915);
        robot.setMSRP(699.99);
        robot.setBatteryType(BatteryType.AAA);
        robot.setNumberOfBattery(10);
        robot.setSound("Bzzzzzt!");

    }


    //****Testing Condition***\\
    @Test
    public void testCondition(){
        assertEquals(robot.getCondition(), Condition.MINT);
        robot.play();
        assertEquals(robot.getCondition(),Condition.NEAR_MINT);
    }

    //****Testing ToString***\\
    @Test
    public void testToString(){
        assertEquals("Mechagodzilla [product code=7119915, MSRP=699.99, condition=MINT, resale value=699.99, battery type=AAA, number of batteries=10, battery level=100, sound=Bzzzzzt!]",robot.toString());
    }

    //****Testing Odometer***\\
    @Test
    public void testResaleValue(){
        BigDecimal bop = BigDecimal.valueOf(Condition.NEAR_MINT.getMultiplier() * 699.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);

        assertEquals(699.99,robot.getResaleValue());
        robot.play();
        assertEquals(bop.doubleValue(),robot.getResaleValue());
        robot.play();
        robot.play();
        robot.play();
        bop = BigDecimal.valueOf(Condition.FAIR.getMultiplier() * 699.99);
        bop = bop.setScale(2, RoundingMode.HALF_UP);
        assertEquals(bop.doubleValue(),robot.getResaleValue());
    }
}
