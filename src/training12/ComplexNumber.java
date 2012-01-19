/*
 * Copyright (C) 2012 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training12;

public class ComplexNumber {
    @SuppressWarnings("serial")
    private class InvalidInputForSquareRoot extends RuntimeException {
        public InvalidInputForSquareRoot(ComplexNumber cn) {
            super(
                    "Can't calculate square root for ComplexNumber because imaginary value isn't 0.0!Re="
                            + cn.getReal() + ",Im=" + cn.getImag());
        }
    }

    private double real;
    private double imag;

    public ComplexNumber(double re, double im) {
        this.real = re;
        this.imag = im;
    }

    public ComplexNumber add(ComplexNumber k) {
        return new ComplexNumber(this.real + k.getReal(), this.imag
                + k.getImag());
    }

    public ComplexNumber mult(ComplexNumber k) {
        double re = this.real * k.getReal() - this.imag * k.getImag();
        double im = this.real * k.getImag() + this.getImag() * k.getReal();
        return new ComplexNumber(re, im);
    }

    public double absoluteValue() {
        double re = this.real * this.real;
        double im = this.imag * this.imag;
        return Math.sqrt(re + im);
    }

    public ComplexNumber sqrt() throws InvalidInputForSquareRoot {
        if (this.imag != 0.0)
            throw new InvalidInputForSquareRoot(this);
        return new ComplexNumber(Math.sqrt(Math.abs(this.real)), 0.0);
    }

    public String toString() {
        // bitte nicht veraendern (wegen Backend-Kontrolle)
        return real + " + " + imag + "*i";
    }

    public static void test() {
        ComplexNumber cn1 = new ComplexNumber(2.0, 2.0);
        ComplexNumber cn2 = new ComplexNumber(3.0, 3.0);
        System.out.println(cn1.add(cn2)); // result = 5+5i
        System.out.println(cn2.add(cn1));

        System.out.println(cn1.mult(cn2)); // result = 0+12i
        System.out.println(cn2.mult(cn1));

        System.out.println(cn1.absoluteValue()); // result=2.82842...
        System.out.println(cn2.absoluteValue()); // result=4.242....

        ComplexNumber cn3 = new ComplexNumber(2.0, 0.0);

        System.out.println(cn3.sqrt()); // result = sqrt(2) = 1.41421..
        System.out.println(cn2.sqrt()); // exception incoming :D
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }
}
