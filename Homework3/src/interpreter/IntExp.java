package interpreter;

public class IntExp implements Expression {

    private int singleInt;

    public IntExp (int singleInt){

        this.singleInt = singleInt;

    }

    @Override
    public int evaluate() {
        return singleInt;
    }

    @Override
    public String emit() {
        return String.valueOf(singleInt);
    }
}

