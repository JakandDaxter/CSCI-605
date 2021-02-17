package hw3;

/**
 * The Expression interface specifies the behavior of all implementing classes
 * It returns the numeric (int) value of evaluated expressions and
 * emits String representations of the same
 *
 */

public interface Expression {
    int evaluate();
    String emit();
}
