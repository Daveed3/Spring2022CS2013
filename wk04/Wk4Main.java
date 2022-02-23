package wk04;

public class Wk4Main {
	public static void main(String[] args) {
		int[][] sampleArrays = {
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
				{1, 6, 2, 8},
				{7, 6, 2, 4, 9}
		};
		
		System.out.println(bunnyEars(10));
		System.out.println(bunnyEars(5));
		System.out.println(bunnyEars(16515));
		
//		int[] iterations = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//		for (int i=0; i<iterations.length; i++) {
//			double p = zenoParadox(100, iterations[i]);
//			System.out.println("Iteration " + iterations[i] + " is distance " + p);
//		}
		
	}

	public static int bunnyEars(int bunnyNum) {
		if (bunnyNum == 0) {
			return 0;
		}
		
		if (bunnyNum % 2 == 1) {
//			If it is odd
			return 3 + bunnyEars(bunnyNum-1);
		} else {
//			If it is even
			return 2 + bunnyEars(bunnyNum-1);
		}
	}
	
	public static double zenoParadox(double distance, int iterations) {
		if (iterations == 0) {
			return 0;
		}
		
		return distance/2 + zenoParadox(distance/2, iterations - 1);
	}

}
