package com.company;

import java.util.Arrays;

final public class BigInt {
    final private byte[] array;

    BigInt(String str) {
        array = new byte[str.length()];
        char[] temp = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            array[i] = (byte) (temp[i] - 48);
        }
    }

    BigInt(byte[] arr) {
        array = Arrays.copyOf(arr, arr.length);
    }

    BigInt(BigInt b) {
        array = Arrays.copyOf(b.array, b.array.length);
    }

    @Override
    public String toString() {
        char[] temp = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = (char) (array[i] + 48);
        }
        return new String(temp);
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) return true;
        if (!(ob instanceof BigInt)) return false;
        BigInt a = (BigInt) ob;
        return Arrays.equals(this.array, a.array);
    }

    public byte[] getNum() {
        return Arrays.copyOf(array, array.length);
    }

    public BigInt add(BigInt other) {
        int sizeThis = this.array.length;
        int sizeOther = other.array.length;
        byte carry = 0;
        byte addend1, addend2;
        if (sizeThis > sizeOther) {
            byte[] temp1 = new byte[sizeThis];
            for (int i = sizeThis; i > sizeThis - sizeOther; i--) {
                addend1 = (byte)(this.array[i - 1]);
                addend2 = (byte)(other.array[i - (sizeThis - sizeOther) - 1]);
                carry += (byte) (addend1 + addend2);
                if (carry > 9) {
                    temp1[i - 1] = (byte) (carry % 10);
                    carry = (byte) (carry / 10);
                }
                else {
                    temp1[i - 1] = carry;
                    carry = 0;
                }
            }
            for(int i = sizeThis - sizeOther - 1; i >= 0; i--){
                carry += this.array[i];
                if (carry > 9) {
                    temp1[i] = (byte) (carry % 10);
                    carry = (byte) (carry / 10);
                }
                else {
                    temp1[i] = carry;
                    carry = 0;
                }
            }
            if (carry > 0) {
                byte[] temp2 = new byte[sizeThis + 1];
                temp2[0] = carry;
                for (int i = 0; i < sizeThis; i++) temp2[i + 1] = temp1[i];
                return new BigInt(temp2);
            } else return new BigInt(temp1);
        } else {
            byte[] temp1 = new byte[sizeOther];
            for (int i = sizeOther; i > sizeOther - sizeThis; i--) {
                addend1 = (byte)(other.array[i - 1]);
                addend2 = (byte)(this.array[i - (sizeOther - sizeThis) - 1]);
                carry += (byte) (addend1 + addend2);
                if (carry > 9) {
                    temp1[i - 1] = (byte) (carry % 10);
                    carry = (byte) (carry / 10);
                }
                else {
                    temp1[i - 1] = carry;
                    carry = 0;
                }
            }
            for(int i = sizeOther - sizeThis - 1; i >= 0; i--){
                carry += other.array[i];
                if (carry > 9) {
                    temp1[i] = (byte) (carry % 10);
                    carry = (byte) (carry / 10);
                }
                else {
                    temp1[i] = carry;
                    carry = 0;
                }
            }
            if (carry > 0) {
                byte[] temp2 = new byte[sizeThis + 1];
                temp2[0] = carry;
                for (int i = 0; i < sizeThis; i++) temp2[i + 1] = temp1[i];
                return new BigInt(temp2);
            } else return new BigInt(temp1);
        }

    }
}
