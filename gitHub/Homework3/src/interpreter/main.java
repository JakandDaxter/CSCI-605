package interpreter;

import interpreter.AddExp;
import interpreter.IntExp;

public class main {
    public static void main(String[] args) {
        IntExp two = new IntExp(2);
        IntExp three = new IntExp(3);

        AddExp adder = new AddExp(two, three);
        int result = adder.evaluate();
        String infix = adder.emit();
        System.out.println(infix + " = " + result);

    }
}
