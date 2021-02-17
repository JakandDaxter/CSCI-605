package hw3;

/**
 * The MulExp class evaluates expressions using the multiply operator
 * It returns the numeric (int) value of the evaluated expression and also
 * emits a String representation of the expression
 */

public class MulExp implements Expression{

    /**
     * Expression to the left of the operator
     */

    Expression left;

    /**
     * Expression to the right of the operator
     */

    Expression right;

    /**
     * Constructor for multiply operation
     * @param left The left expression
     * @param right The right expression
     */

    public MulExp(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     *  Method to evaluate left and right expressions using the multiply operator
     *  @return integer value after performing division operation
     */

    @Override
    public int evaluate() {
        return this.left.evaluate() * this.right.evaluate();
    }

    /**
     * Method to emit a string representation of the expression
     * @return string representation of the evaluated expression
     */

    @Override
    public String emit() {
        StringBuilder str = new StringBuilder();

        String leftEmit = this.left.emit();
        String rightEmit = this.right.emit();

        str.append('(');
        str.append(leftEmit);
        str.append(" * ");
        str.append(rightEmit);
        str.append(')');

        return str.toString();
    }

    /**
     * Set the left expression
     */

    public void setLeft(Expression left) {
        this.left = left;
    }

    /**
     * Get the left expression
     * @return the right expression
     */

    public Expression getLeft() {
        return left;
    }

    /**
     * Set the right expression
     */

    public void setRight(Expression right) {
        this.right = right;
    }

    /**
     * Get the right expression
     * @return the right expression
     */

    public Expression getRight() {
        return right;
    }
}
