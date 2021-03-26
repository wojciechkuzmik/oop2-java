package com.company;

public class Main {

	public static void test1() throws Exception {
		for(int i = 0; i < 1000; i++){
			long l1 = (long)((Math.random()*Long.MAX_VALUE)/2 - 1);
			long l2 = (long)((Math.random()*Long.MAX_VALUE)/2 - 1);
			BigInt a = new BigInt(Long.toString(l1));
			BigInt b = new BigInt(Long.toString(l2));
			long l3 = l1 + l2;
			BigInt c = new BigInt(Long.toString(l3));
			if(!(a.add(b).equals(c))){
				System.out.println("error1!");
				throw new Exception();
			}
		}
	}

	public static void test2() throws Exception {
		long l1 = 1L;
		long l2 = 999999999999999999L;
		BigInt a = new BigInt(Long.toString(l1));
		BigInt b = new BigInt(Long.toString(l2));
		long l3 = l1 + l2;
		BigInt c = new BigInt(Long.toString(l3));
		if(!(a.add(b).equals(c))){
			System.out.println("error2!");
			throw new Exception();
		}
	}

	public static void test3() throws Exception {
		long l1 = 999999999999999999L;
		long l2 = 1L;
		BigInt a = new BigInt(Long.toString(l1));
		BigInt b = new BigInt(Long.toString(l2));
		long l3 = l1 + l2;
		BigInt c = new BigInt(Long.toString(l3));
		if(!(a.add(b).equals(c))){
			System.out.println("error3!");
			throw new Exception();
		}
	}

    public static void main(String[] args) {
	    BigInt a = new BigInt("45613412");
	    System.out.println(a);
	    byte[] arr = {1, 2, 3, 5, 7, 2};
	    BigInt b = new BigInt(arr);
        System.out.println(b);
        BigInt c = new BigInt(b);
		System.out.println(c);
		System.out.println(a.add(b));
		System.out.println(b.add(a));
		try {
			test1();
		}
		catch (Exception e){
			System.exit(1);
		}
		try {
			test2();
		}
		catch (Exception e){
			System.exit(2);
		}
		try {
			test3();
		}
		catch (Exception e){
			System.exit(3);
		}
    }
}
