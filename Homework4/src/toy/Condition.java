package toy;

/**
 * Used to represent the possible condition of a toy.
 */
public enum Condition {
    MINT(1.0),
    NEAR_MINT(0.9),
    VERY_GOOD(0.75),
    GOOD(0.7),
    FAIR(0.25),
    POOR(0.1),
    BROKEN(0.0);

    /**
     * Used to determine the real value of a toy; its base price multiplied by
     * its condition.
     */
    private final double multiplier;

    /**
     * Creates a new condition with the specified multiplier.
     *
     * @param multiplier The amount by which the base price of a toy should be
     *                   multiplied to determine its value.
     */
    Condition(double multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * A toy's condition affects its resale value. The multiplier is used to
     * determine by how much the value is affected.
     *
     * @return The multiplier for this condition.
     */
    public double getMultiplier() {
        return multiplier;
    }

    /**
     * As a toy is used, its condition degrades to the next lower level. This
     * helper method returns the next lower level.
     *
     * @return The next lower condition, e.g. NEAR_MINT -> VERY_GOOD.
     */
    public Condition degrade() {
        Condition degraded;
        switch(this) {
            case MINT:
                degraded = NEAR_MINT;
                break;
            case NEAR_MINT:
                degraded = VERY_GOOD;
                break;
            case VERY_GOOD:
                degraded = GOOD;
                break;
            case GOOD:
                degraded = FAIR;
                break;
            case FAIR:
                degraded = POOR;
                break;
            default:
            case POOR:
                degraded = BROKEN;
        }
        return degraded;
    }
}
