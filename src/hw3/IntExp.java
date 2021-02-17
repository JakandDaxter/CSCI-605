package hw3;

/**
 * The IntExp class evaluates single expressions
 * It returns the numeric (int) value of the evaluated expression and also
 * emits a String representation of the expression
 */

public class IntExp implements Expression {

    /**
     * Single integer expression
     */

    private int value;

    /**
     * Constructor for a single expression
     * @param value
     */

    public IntExp(int value) {
        this.value = value;
    }

    /**
     *  Evaluates single expression
     *  @return integer value
     */

    @Override
    public int evaluate() {
        return this.value;
    }

    /**
     * @return a string representation of the single expression
     */

    @Override
    public String emit() {
        return String.valueOf(value);
    }
}
