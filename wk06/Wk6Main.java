package wk06;
/* Coding Questions
1b. Given an array of a single type (could be int, char, String, double...), create an algorithm that would sort the array.
What is the runtime of the algorithm you've created? Can you improve the runtime efficiency?
 
2b. Given an array of a ints, create an algorithm that would make every even element to the power of itself (i.e. given
{1, 3, 4, 5} the result should be {1, 27, 4, 3125} since 3 and 5 are in the even positions and 3^3 is 27 and 5^5 is 3125).
What is the runtime of the algorithm you’ve created? Can you improve the runtime efficiency? 
 
3b. Given an array of doubles, create an algorithm that would remove the decimal from the double by making it an (<int> *
10^-<int>) (i.e. {2.0, 4.25, 7.125} could be {“20 * 10^-1”, “425 * 10^-2”, “7125 * 10^-3”} --- note the use of strings,
assume we’re just converting the double to a string  and we don’t need to convert back). What is the runtime of the
algorithm you’ve created? Can you improve the runtime efficiency? 
 
4b. Given an array of a single type (could be int, char, String, double...), create an algorithm that would sort the array.
What is the runtime of the algorithm you've created? Can you improve the runtime efficiency?

5b. Given an array of ints, create an algorithm where every element in the even position is made an exponent of itself (i.e.
given {1, 4, 6, 3, 1} -> the even position elements are 4 and 3 (2nd and 4th element). We will then make 4^4 and 3^3 in that array returning {1, 256, 6, 27, 1}). What is the runtime of the algorithm you created?


 */

public class Wk6Main {
	public static void main(String[] args) {
		int[] sample1 = {7, 2, 5, 8, 1, 7, 5, 1, 9};
		int[] sample2 = {5, 2, 4, 1, 2, 3};
		double[] sampleDoubles1 = {2.5, 4.84, 4.7451, 426.5471, 235.745324};

		String[] sampleStrings = removeDecimals2(sampleDoubles1);
		for (int i=0; i<sampleStrings.length; i++) {
			System.out.println(sampleStrings[i]);
		}
	}
	
	public static void _printArr(int[] arr) {
		for (int i=0;i<arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
		System.out.println();
	}
	
	// Problem 1b and 4b
	public static int[] sortSingleTypeInt(int[] arr) {
//		Check each element, 
		for (int i=0; i<arr.length; i++) {
			for (int j=i; j<arr.length; j++) {
//				Using a second pointer to help compare
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
	
	// Problems 2b and 5b (2 versions)
	public static int[] intPowItself(int[] ints) {
		for (int i=0; i<ints.length; i++) {
			if (i%2==0) {
				for (int j=1;j<ints[i];j++) {
					ints[i] *= ints[i];
//					3 * 3 * 3
//					 4 * 4 * 4 * 4
				}
			}
		}
		return ints;
	}
	public static int[] intPowItself2(int[] ints) {
		for (int i=0; i<ints.length; i++) {
			int num = ints[i];
			if (i%2==0) {
				ints[i] = (int)(Math.pow(ints[i], num));
			}
		}
		return ints;		
	}
	
	//Problem 3b (2 versions)
	public static String[] removeDecimals(double[] doubles) {
		String[] result = new String[doubles.length];
		int ele = 0;
		for (int i=0; i<doubles.length; i++) {
//			For each double, record 10^-x where x is the number of decimals the double has
			double val = doubles[i]; 
			int exponent = 0;
			while (val - (int)(val) != 0) {
				exponent++;
				val *= 10;
				if ((val - (int)val) * 10 < 1) {
					break;
				}
			}
			result[ele] = ((int)val + " * 10^-" + exponent);
			ele++;
		}
		
		return result;
	}
	public static String[] removeDecimals2(double[] doubles) {
		String[] result = new String[doubles.length];
		int ele = 0;
		for (int i=0; i<doubles.length; i++) {
//			Turn value into a string, find the "." and get the length of the digits to the right
			double val = doubles[i];
			String strVal = val+"";
			String[] strSplit = strVal.split("\\.");
			int exponent = (strSplit[1]).length();
			
			val *= Math.pow(10, exponent);
			result[ele] = (int)val + " * 10^-" + exponent;
			ele++;
		}
		
		return result;
	}
}
