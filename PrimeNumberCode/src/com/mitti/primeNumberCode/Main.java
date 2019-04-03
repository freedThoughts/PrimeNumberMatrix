package com.mitti.primeNumberCode;

public class Main {

    public static void main(String[] args) {
        int N = 100; // As per input


        if (N == 0) return;
        int[] arr = new int[N];
        arr[0] = 2; // First prime number
        new Main().getPrimeNumbers(N, arr);

        // Printing the Table
        for(int i = 0; i < N; i++) {
            System.out.print("   " + arr[i] + "   ");
        }
        System.out.println();

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print("   " + arr[i] * (j == 0 ? 1 : arr[j]) + "   ");
            System.out.println();
        }
    }


    /*
    Saving the prime numbers in Array arr.
    For every new number, i,  to test if prime :-
        - We are only considering the prime numbers found till the time in array, arr.
            This means that we are checking by dividing i by only prime numbers less than i.
        - In the inner loop, for each iteration of arr, arr[m], we are keeping track of previousQuotient, found by dividing i by current value in arr, arr[m]
            If the previousQuotient is less than arr[m], meaning - we already checked all possible cases for divisibility of i. And the number i is prime.
        - In the inner loop, we would keep on checking the divisibility of i by arr[m], till the time when either of two not found -
                - We would find i as non prime. Setting variable isNonPrime as true and exit from loop
                - We would reach to the point in arr, where previousQuotient is less than arr[m]. This number i, found as prime number.
        - Outer loop would exits when we would find all N prime numbers and arrIndex would reach to N.

            ****************************************************************************************************************************************
             Time complexity - O( K * SquareRoot(N)), where K can be any number which get incremented till  we find all N prime numbers.
                                                           N is as per input
             Space complexity - O(N)
       */

    void getPrimeNumbers(int N, int[] arr) {
        if (N == 1) return;

        for (int i = 3, arrIndex = 1; arrIndex < N; i++) {
            int previousQuotient  = i;
            boolean isNonPrime = false;

            // O(Square root of arrIndex)
            for (int m = 0; m < arrIndex && previousQuotient > arr[m]; m++) {
                if (i % arr[m] == 0) {
                    isNonPrime = true;
                    break;
                }
                previousQuotient  = i / arr[m];
            }

            if (!isNonPrime) {
                arr[arrIndex] = i;
                arrIndex++;
            }
        }
    }
}
