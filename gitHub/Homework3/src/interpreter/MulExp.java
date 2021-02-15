package interpreter;

public class MulExp implements Expression {

    private Expression left;
    private Expression right;

    public MulExp (Expression left, Expression right){
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
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String emit() {
        return "Emit: " + "(" + this.left.emit() + "x" + this.right.emit() + ")";
    }
}

