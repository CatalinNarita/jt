package main;

import impl.*;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by naritc on 7/6/2017.
 */
public class Calculator {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        Operation add1= new Add();
        Operation sub1 = new Substract();
        Operation mul1 = new Multiply();
        Operation div1 = new Divide();

        /*Operation add = (p1,p2) -> p1+p2;
        Operation sub = (p1,p2) -> p1-p2;
        Operation mul = (p1,p2) -> p1*p2;
        Operation div = (p1,p2) -> {if (p2 == 0) throw new IllegalArgumentException(); return p1/p2;};*/
        BinaryOperator<Double> add = ((Supplier<Add>)Add::new).get()::calc;
        BinaryOperator<Double> sub = (x,y) -> x-y;
        BinaryOperator<Double> mul = (x,y) -> x*y;
        BinaryOperator<Double> div = (x,y) -> {if (y == 0) throw new IllegalArgumentException(); return x/y;};

       /* c.printOperation(add,2D,3D);
        c.printOperation(sub,2D,3D);
        c.printOperation(mul,2D,3D);
        c.printOperation(div,2D,3D);*/

        Consumer<BinaryOperator<Double>> print = p -> System.out.println(p.apply(2D,3D));
        print.accept(add);
        print.accept(sub);
        print.accept(mul);
        print.accept(div);
        System.out.println("feature01 change 1");

    }

    public void printOperation(BinaryOperator o, Double a, Double b){
        System.out.println(o.apply(a, b));
    }

}
