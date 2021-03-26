import java.util.*;

public class Main {

    public static void main(String[] args) {
    	int minRange = 5;
    	int maxRange = 20;
	    int n = Integer.parseInt(args[0]);
	    int m = Integer.parseInt(args[1]);
	    String[] t1 = new String[n];
	    String[] t2 = new String[m];
	    String[] t3 = new String[m];
	    Random random = new Random();
	    int size;
	    for(int i = 0; i < t1.length; i++){
	    	size = (int)(minRange + random.nextDouble()*(maxRange-minRange));
			t1[i] = generateString(size);
		}

	    for(int i = 0; i < t2.length; i++){
	    	t2[i] = t1[random.nextInt(n)];
			size = (int)(minRange + random.nextDouble()*(maxRange-minRange));
			t3[i] = generateString(size);
		}

		ArrayList<String> arrayList = new ArrayList<>();
	    LinkedList<String> linkedList = new LinkedList<>();
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		HashMap<String, Integer> hashMap = new HashMap<>();
		long startAL, elapsedAL, startLL, elapsedLL, startTM, elapsedTM, startHM, elapsedHM;


		//GENERATE
		startAL = System.nanoTime();
		for(int i = 0; i < t1.length; i++){
			arrayList.add(t1[i]);
		}
		elapsedAL = System.nanoTime() - startAL;

		startLL = System.nanoTime();
		for(int i = 0; i < t1.length; i++){
			linkedList.add(t1[i]);
		}
		elapsedLL = System.nanoTime() - startLL;

		startTM = System.nanoTime();
		for(int i = 0; i < t1.length; i++){
			treeMap.put(t1[i], i);
		}
		elapsedTM = System.nanoTime() - startTM;

		startHM = System.nanoTime();
		for(int i = 0; i < t1.length; i++){
			hashMap.put(t1[i], i);
		}
		elapsedHM = System.nanoTime() - startHM;

		System.out.println("Generate:");
		System.out.println("ArrayList(" + elapsedAL/Math.pow(10, 6) + " ms), LinkedList(" + elapsedLL/Math.pow(10, 6)
				+ " ms), TreeMap(" + elapsedTM/Math.pow(10, 6) + " ms), HashMap(" + elapsedHM/Math.pow(10, 6) + ")\n");

		//SEARCH
		startAL = System.nanoTime();
		for(int i = 0; i < t2.length; i++){
			arrayList.contains(t2[i]);
		}
		elapsedAL = System.nanoTime() - startAL;

		startLL = System.nanoTime();
		for(int i = 0; i < t2.length; i++){
			linkedList.contains(t2[i]);
		}
		elapsedLL = System.nanoTime() - startLL;

		startTM = System.nanoTime();
		for(int i = 0; i < t2.length; i++){
			treeMap.containsKey(t2[i]);
		}
		elapsedTM = System.nanoTime() - startTM;

		startHM = System.nanoTime();
		for(int i = 0; i < t2.length; i++){
			hashMap.containsKey(t2[i]);
		}
		elapsedHM = System.nanoTime() - startHM;

		System.out.println("Search:");
		System.out.println("ArrayList(" + elapsedAL/Math.pow(10, 6) + " ms), LinkedList(" + elapsedLL/Math.pow(10, 6)
				+ " ms), TreeMap(" + elapsedTM/Math.pow(10, 6) + " ms), HashMap(" + elapsedHM/Math.pow(10, 6) + ")\n");

		//SEARCH NOT
		startAL = System.nanoTime();
		for(int i = 0; i < t3.length; i++){
			arrayList.contains(t3[i]);
		}
		elapsedAL = System.nanoTime() - startAL;

		startLL = System.nanoTime();
		for(int i = 0; i < t3.length; i++){
			linkedList.contains(t3[i]);
		}
		elapsedLL = System.nanoTime() - startLL;

		startTM = System.nanoTime();
		for(int i = 0; i < t3.length; i++){
			treeMap.containsKey(t3[i]);
		}
		elapsedTM = System.nanoTime() - startTM;

		startHM = System.nanoTime();
		for(int i = 0; i < t3.length; i++){
			hashMap.containsKey(t3[i]);
		}
		elapsedHM = System.nanoTime() - startHM;

		System.out.println("SearchNOT:");
		System.out.println("ArrayList(" + elapsedAL/Math.pow(10, 6) + " ms), LinkedList(" + elapsedLL/Math.pow(10, 6)
				+ " ms), TreeMap(" + elapsedTM/Math.pow(10, 6) + " ms), HashMap(" + elapsedHM/Math.pow(10, 6) + ")\n");

		//REMOVE
		startAL = System.nanoTime();
		arrayList.clear();
		elapsedAL = System.nanoTime() - startAL;

		startLL = System.nanoTime();
		linkedList.clear();
		elapsedLL = System.nanoTime() - startLL;

		startTM = System.nanoTime();
		treeMap.clear();
		elapsedTM = System.nanoTime() - startTM;

		startHM = System.nanoTime();
		hashMap.clear();
		elapsedHM = System.nanoTime() - startHM;

		System.out.println("Clear:");
		System.out.println("ArrayList(" + elapsedAL/Math.pow(10, 6) + " ms), LinkedList(" + elapsedLL/Math.pow(10, 6)
				+ " ms), TreeMap(" + elapsedTM/Math.pow(10, 6) + " ms), HashMap(" + elapsedHM/Math.pow(10, 6) + ")\n");

	}

    public static String generateString(int size){
    	StringBuilder ret = new StringBuilder();
    	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    	Random random = new Random();
    	char rand;
    	for(int i = 0; i < size; i++){
    		rand = alphabet.charAt(random.nextInt(alphabet.length()));
    		ret.append(rand);
		}
    	return ret.toString();
	}
}
