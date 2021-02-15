package interpreter;

public class DivExp implements Expression {

    private Expression left;
    private Expression right;

    public DivExp (Expression left, Expression right){

        this.left = left;
        this.right = right;

    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight(){
        return this.right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }

    @Override
    public String emit() {
        return "Emit: " + "(" + this.left.emit() + "-" + this.right.emit() + ")";
    }
}
