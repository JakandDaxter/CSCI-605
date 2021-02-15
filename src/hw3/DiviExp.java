package hw3;

public class DiviExp implements Expression {

    Expression left;
    Expression right;

    public DiviExp(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public DiviExp(){

    }

    @Override
    public int evaluate() {
        return this.left.evaluate() / this.right.evaluate();
    }

    @Override
    public String emit() {

        StringBuilder str = new StringBuilder();

        String leftEmit = this.left.emit();
        String rightEmit = this.right.emit();

        str.append('(');
        str.append(leftEmit);
        str.append(" / ");
        str.append(rightEmit);
        str.append(')');

        return str.toString();
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getLeft() {
        return left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public Expression getRight() {
        return right;
    }
}
