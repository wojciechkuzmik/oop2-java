package com.company;

import java.math.BigInteger;

public class Main {
    static int euclid(int a, int b){
        int temp;
        while(b != 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

    static int extendedEuclid(int a, int b){
        int x0 = 1;
        int x = 0;
        int b0 = b;
        int q, temp;
        while(b !=0){
            q = Math.abs(a/b);
            temp = x;
            x = x0 - q*x;
            x0 = temp;
            temp = a%b;
            a = b;
            b = temp;
        }
        if(x0<0){
            x0 = x0 + b0;
        }
        return x0;
    }

    public static void main(String[] args) {
	    int p = 397;
	    int q = 103;
	    int n = p*q;
	    int fi = (p-1)*(q-1);
	    int e = 3;
	    while(euclid(e, fi) != 1){
	        e += 2;
        }

	    int d = extendedEuclid(e, fi);
	    System.out.println("public_key: ("+e+", "+n+")");
        System.out.println("private_key: ("+d+", "+n+")\n");

        char[] charWord = args[0].toCharArray();
        int[] intWord = new int[args[0].length()];
        for(int i = 0; i < args[0].length(); i++){
            intWord[i] = charWord[i];
        }
        BigInteger[] bigIntegerWord = new BigInteger[args[0].length()];

        //encryption
        for(int i = 0; i < args[0].length(); i++){
            //c = t^e mod n;
            bigIntegerWord[i] = new BigInteger(String.valueOf(intWord[i])).pow(e)
                    .mod(new BigInteger(String.valueOf(n)));
        }

        for(int i = 0; i < args[0].length(); i++){
            System.out.print(bigIntegerWord[i]);
            System.out.print(" ");
        }
        System.out.println();

        char[] decryptedWord = new char[args[0].length()];

        //decryption
        for(int i = 0; i < args[0].length(); i++){

            decryptedWord[i] = (char)bigIntegerWord[i].pow(d)
                    .mod(new BigInteger(String.valueOf(n))).intValue();
        }

        for(int i = 0; i < args[0].length(); i++){
            System.out.print(decryptedWord[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
