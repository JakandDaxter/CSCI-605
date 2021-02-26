package toy;

import java.util.Random;

/**
 * A Toy Factory!
 */
public abstract class ToyFactory {
    /**
     * Used to generate randomInt numbers. Seed is hard coded to 1 for
     * "predictable randomness".
     */
    private static final Random RNG = new Random(1);

    /**
     * Type code used to indicate that the toy factory should make a scooter.
     */
    private static final int SCOOTER = 1;

    /**
     * Type code used to indicate that the toy factory should make a doll.
     */
    private static final int DOLL = 2;

    /**
     * Type code used to indicate that the toy factory should make an action
     * figure.
     */
    private static final int ACTION_FIGURE = 3;

    /**
     * The type code used to indicate that the toy factory should make an RC
     * car.
     */
    private static final int RC_CAR = 4;

    /**
     * The type code used to indicate that the toy factory should make a
     * robot.
     */
    private static final int ROBOT = 5;

    /**
     * The potential names for scooters.
     */
    private static final String[] SCOOTER_NAMES = {
        "Razor A", "Razor A5", "Mongoose Expo", "ENKEEO Kick", "Micro Maxi",
        "Royal Guard II", "Fuzion X-3", "Fuzion Z250 Pro", "VOKUL S2",
        "Xiaomi Mi", "WonderView"
    };

    /**
     * The potential colors for scooters.
     */
    private static final String[] SCOOTER_COLORS = {
      "Black", "Pink", "Green", "Blue", "Cyan", "Purple", "Gold", "Silver",
      "Red"
    };

    /**
     * The potential names for dolls.
     */
    private static final String[] DOLL_NAMES = {
      "Sally", "Johnny", "Barbie", "Ken", "Julio", "Ralph", "Jane", "Sarah",
      "Susan", "Benedetta", "Edwina", "Gloria", "Henriette", "Laura",
      "Marilee", "Norma", "Barbara Ann", "Barbara Lou", "Dora Lee", "Flossie",
      "Ginger", "Hilda", "Lucia Mary Lee", "Babs", "Betty", "Roger", "George",
      "Robert", "Harry", "Bruce", "Willy", "Johnson", "Pete", "Woody", "Buzz",
      "Larry"

    };

    /**
     * The potential colors for hair.
     */
    private static final String[] HAIR_COLOR = {
      "Blond", "Brown", "Brunette", "Purple", "Pink", "Red", "Black",
      "Ginger", "Green", "Blue"
    };

    /**
     * The potential colors for eyes.
     */
    private static final String[] EYE_COLOR = {
      "Blue", "Green", "Black", "Brown", "Purple", "Hazel"
    };

    /**
     * The potential prefixes for action figures.
     * The name of an action figure is the concatenation of one of those prefixes +
     * a doll's name (e.g. Strong Laura)
     */
    private static final String[] ACTION_FIGURE_PREFIXES = {
        "Action", "Lightning", "Strong", "Fast",  "Sneaky", "Super", "Tough",
        "'Lasers'", "Stretch", "G.I.", "Quiet"
    };

    /**
     * The potential names for RC Cars.
     */
    private static final String[] RC_CAR_NAMES = {
        "Fistone Truck", "Gizmovine RC", "SPESXFUN", "Hapinic RC", "Amicool",
        "METAKOO RC", "Hosim RC", "KOOWHEEL Car", "Distianert Truck",
        "JEYPOD IMDEN Car"
    };


    /**
     * The potential names for robots.
     */
    private static final String[] ROBOT_NAMES = {
        "Iron Giant", "Mechagodzilla", "Optimus Prime", "Reginald", "Vector",
        "Robby", "R2-D2", "C3PO", "BB8", "Megatron", "Shockwave", "Soundwave",
        "Bumblebee", "iRobot", "Roomba", "Data", ""
    };

    /**
     * The potential sounds that a robot may make.
     */
    private static final String[] ROBOT_SOUNDS = {
        "Bleep Blorp", "Death to humans!", "One shall stand, one shall fall.",
        "Beepeedeepee", "Oh dear!", "Starscream, you fool!", "Eject!",
        "*radio playing*", "Bzzzzzt!", "I...am...Suuuuperman.",
        "I am not a gun!"
    };

    /**
     * Factory method that makes and returns a random toy.
     *
     * @return A new, randomly selected toy.
     */
    public static IToy makeToy(int type) {
        //TODO YOUR CODE HERE

        switch (type){
            case SCOOTER:
                return randomScooter();
            case DOLL:
                return randomDoll();
            case ACTION_FIGURE:
                return randomActionFigure();
            case RC_CAR:
                return randomRCCar();
            case ROBOT:
                return randomRobot();
        }

        return null;
    }

    /**
     * Makes and returns a scooter with a random name, MSRP, color, and
     * number of wheels (either 2 or 3).
     * The MSRP must be a value between 39.99 and 160.99
     *
     * @return The newly crafted scooter.
     */
    private static IToy randomScooter() {
        // TODO YOUR CODE HERE
        // make the scooter and assign it to toy
        Scooter scooter = new Scooter();
        scooter.setName(randomString(SCOOTER_NAMES));
        scooter.setMSRP(randomDouble(39.99,160.99));
        scooter.setColor(randomString(SCOOTER_COLORS));
        scooter.setWheels(randomInt(2,3));

        return scooter;
    }

    /**
     * Makes and returns a doll with a random name, MSRP, hair color, and eye
     * color.
     * The MSRP must be a value between 12.99 and 60.00
     *
     * @return The newly crafted doll.
     */
    private static IToy randomDoll() {
        // TODO YOUR CODE HERE
        // make the doll and return it
        Doll doll = new Doll();
        doll.setName(randomString(DOLL_NAMES));
        doll.setMSRP(randomDouble(12.99,60.99));
        doll.setHairColor(randomString(HAIR_COLOR));
        doll.setEyeColor(randomString(EYE_COLOR));

        return doll;
    }

    /**
     * Makes and returns an action figure with a random name, MSRP, hair
     * color, eye color, and Kung-Fu Grip (tm) configuration.
     * The MSRP must be a value between 9.99 and 24.99
     *
      * @return The newly crafted action figure.
     */
    private static IToy randomActionFigure() {
        // TODO YOUR CODE HERE
        // make the action figure and return it
        ActionFigure actionFigure = new ActionFigure();
        actionFigure.setName(randomString(ACTION_FIGURE_PREFIXES)+" "+randomString(DOLL_NAMES));
        actionFigure.setMSRP(randomDouble(9.99,24.99));
        actionFigure.setHairColor(randomString(HAIR_COLOR));
        actionFigure.setEyeColor(randomString(EYE_COLOR));
        actionFigure.setKungFuGrip(randomBoolean());

        return actionFigure;
    }

    /**
     * Makes and returns an RC Car with a random name, MSRP, battery type,
     * number of batteries, and scale speed.
     * The MSRP must be a random value between 19.99 and 159.99.
     * The scale speed must be a random value between 100 and 300.
     *
     * @return The newly crafted RC Car.
     */
    private static IToy randomRCCar() {
        // TODO YOUR CODE HERE
        // make the RC car and return it
        RCCar rcCar = new RCCar();
        rcCar.setName(randomString(RC_CAR_NAMES));
        rcCar.setMSRP(randomDouble(19.99,159.99));
        rcCar.setBatteryType(randomBatteryType());
        rcCar.setNumberOfBattery(randomInt(1,10));
        rcCar.setSpeed(randomInt(100,300));

        return rcCar;
    }

    /**
     * Makes and returns a Robot with a random name, MSRP, battery type,
     * number of batteries, and sound.
     * The MSRP must be a value between 25.99 and 699.99.
     *
     * @return The newly crafted robot.
     */
    private static IToy randomRobot() {
        // TODO YOUR CODE HERE
        // make the robot and return it
        Robot robot = new Robot();
        robot.setName(randomString(ROBOT_NAMES));
        robot.setMSRP(randomDouble(25.99,699.99));
        robot.setBatteryType(randomBatteryType());
        robot.setNumberOfBattery(randomInt(1,10));
        robot.setSound(randomString(ROBOT_SOUNDS));

        return robot;
    }

    //////////////////////////////////////////////////
    //              UTILITY METHODS                 //
    /////////////////////////////////////////////////

    /**
     * Returns a random integer in the range [min, max]
     *
     * @param min The minimum value.
     * @param max The maximum value.
     *
     * @return A random integer in the range [min, max].
     */
    private static int randomInt(int min, int max) {
        int bound = max - min + 1;
        return RNG.nextInt(bound) + min;
    }

    /**
     * Returns a random boolean (true or false).
     *
     * @return A random boolean.
     */
    private static boolean randomBoolean() {
        return RNG.nextBoolean();
    }

    /**
     * Returns a random double in the range [min, max].
     *
     * @param min The minimum value.
     * @param max The maximum value.
     *
     * @return A random double in the range [min, max].
     */
    private static double randomDouble(double min, double max) {
        double bound = max - min;
        double temp = RNG.nextDouble() * bound + min;
        temp = temp * 100;
        int rounded = (int)temp;
        return rounded / 100.0;
    }

    /**
     * Selects a random value from the specified string array.
     *
     * @param values The array of strings from which to choose a random value.
     *
     * @return The value that has been randomly selected from the array of
     * strings.
     */
    private static String randomString(String[] values) {
        int index = randomInt(0, values.length-1);
        return values[index];
    }

    /**
     * Returns a randomly selected battery type.
     *
     * @return A battery type.
     */
    private static BatteryType randomBatteryType() {
        int batteries = randomInt(1, 6);
        BatteryType batteryType;
        switch(batteries) {
            case 1:
                batteryType = BatteryType.AA;
                break;
            case 2:
                batteryType = BatteryType.AAA;
                break;
            case 3:
                batteryType = BatteryType.AAAA;
                break;
            case 4:
                batteryType = BatteryType.C;
                break;
            case 5:
                batteryType = BatteryType.D;
                break;
            case 6:
                batteryType = BatteryType.NINE_VOLT;
                break;
            default:
                batteryType = null;
                System.err.println("Unknown battery type: " + batteries);
                System.exit(1);
        }
        return batteryType;
    }
}
