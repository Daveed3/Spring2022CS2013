package wk06;

/*
What is the runtime of the following methods
1. 
void foo(int[] array) { 
    int sum = 0; 
    int product = 1; 
    for (inti= 0; i < array.length; i++) { 
        sum += array[i); 
    } 
    for (int i= 0; i < array.length; i++) { 
        product*= array[i]; 
    } 
    System.out.println(sum + ", " + product); 
} 
Runtime is O(2n) = O(n)
 
2. 
void printPairs(int[] array) { 
    for (int i= 0; i < array.length; i++) { 
        for (int j = 0; j < array.length; j++) { 
            System.out.println(array[i] + "," + array[j]); 
        } 
    } 
} 
Runtime is O(n^2) since the for loop is nested and goes from 0 to array.length for both
 
3. 
void printUnorderedPairs(int[] arrayA, int[] arrayB) { 
    for (int i= 0; i < arrayA.length; i++) { 
         for (int j = 0; j < arrayB.length; j++) { 
             for (int k = 0; k < 100000; k++) { 
                 System.out.println(arrayA[i] + "," + arrayB[j]); 
             } 
         } 
    } 
} 
Runtime is O(A*B) = O(n*m) since the for loops are nested but have various array lengths
 
4.
int sumDigits(int n) {
    int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
    return sum;
} 
Runtime is O(m) where m is the length of n
 
5. Void twoLists(int[] listA, int[] listB) {
    for (int i=0; i<listA.length; i++) {
        System.out.print(listA[i]);
    }
    for (int j=0; j<listB.length; j++) {
        System.out.print(listB[j]);
    }
}
Runtime is O(A+B) = O(n+m) since the loops are separate you add them; and since they are of various lengths, you split what they mean
 
6. void halves(int n) {
    while (n > 0) {
        System.out.print(n);
        n /= 2;
}
Runtime is O(log n) since n keeps getting smaller through division
 
7. void nest(int[] listA, int[] listB) {
    for (int i=0; i<listA.length; i++) {
        for (int j=0; j<listB.length; j++) {
            System.out.print(listA[i] + listB[j]);
       }
    }
}
Runtime is O(A*B) = O(n*m) since the for loops are nested but have various length arrays
 
8. void nest(int[] listA) {
    for (int i=0; i<listA.length; i++) {
        for (int j=0; j<listA.length; j++) {
            System.out.print(listA[i] + “, ” + listA[j]);
         }
    }
}
Runtime is O(A^2) = O(n^2) since the loops are nested and go from 0 to the array's length for both loops
 */

public class RuntimeQuestions {

}
