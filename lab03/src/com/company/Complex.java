package com.company;

public class Complex {
    double re;
    double im;
    final static public Complex I = new Complex(0, 1);
    final static public Complex ZERO = new Complex();
    final static public Complex ONE = new Complex(1);

    public Complex(double re, double im) { this.re = re; this.im = im;}

    public Complex(double re) { this.re = re; this.im = 0;}

    public Complex() { this.re = 0; this.im = 0;}

    @Override
    public String toString(){
        if(this.im > 0 && this.re != 0)
            return this.re + " + " + this.im + "i";
        else if (this.im < 0 && this.re != 0)
            return this.re + " - " + Math.abs(this.im) + "i";
        else if (this.im == 0 && this.re == 0)
            return "0.0";
        else if (this.re != 0)
            return this.re + "";
        else
            return this.im + "i";

    }

    public double getRe() {return this.re;}
    public double getIm() {return this.im;}

    public static Complex add(Complex a, Complex b){
        Complex temp = new Complex();
        temp.re = a.getRe() + b.getRe();
        temp.im = a.getIm() + b.getIm();
        return temp;
    }

    public static Complex subtract(Complex a, Complex b){
        Complex temp = new Complex();
        temp.re = a.getRe() - b.getRe();
        temp.im = a.getIm() - b.getIm();
        return temp;
    }

    public static Complex multiply(Complex a, Complex b){
        Complex temp = new Complex();
        temp.re = a.getRe()*b.getRe() - a.getIm()*b.getIm();
        temp.im = a.getIm()*b.getRe() + a.getRe()*b.getIm();
        return temp;
    }

    public static Complex multiply(Complex a, double b){
        Complex temp = new Complex();
        temp.re = a.getRe()*b;
        temp.im = a.getIm()*b;
        return temp;
    }

    public static Complex divide(Complex a, Complex b){
        Complex temp = new Complex();
        temp.re = (a.getRe()*b.getRe() + a.getIm()*b.getIm()) / (Math.pow(b.getRe(), 2) + Math.pow(b.getIm(), 2));
        temp.im = (a.getIm()*b.getRe() - a.getRe()*b.getIm()) / (Math.pow(b.getRe(), 2) + Math.pow(b.getIm(), 2));
        return temp;
    }

    public double mod(){
        return Math.sqrt(Math.pow(this.getRe(), 2) + (Math.pow(this.getIm(), 2)));
    }

    public static Complex sqrt(double a){
        Complex temp = new Complex();
        if (a > 0)
            temp.re = Math.sqrt(a);
        else
            temp.im = Math.sqrt(Math.abs(a));
        return temp;
    }

    @Override
    public boolean equals(Object a){
        if(this == a) return true;
        Complex temp = (Complex) a;
        return (this.re == temp.getRe() && this.im == temp.getIm());
    }

    public void conjugate(){
        this.im = -this.im;
    }

    public void opposite(){
        this.im = -this.im;
        this.re = -this.re;
    }
}
