package hw3;

public class IntExp implements Expression{

    private int value;

    public IntExp(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return this.value;
    }

    @Override
    public String emit() {
        return String.valueOf(value);
    }
}
