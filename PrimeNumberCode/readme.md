Problem :- Write​ ​a​ ​program​ ​that​ ​prints​ ​out​ ​a​ ​multiplication​ ​table​ ​of​ ​the​ ​first​ ​N ​prime​ ​number.
		The​ ​first​ ​row​ ​and​ ​column​ ​of​ ​the​ ​table​ ​should​ ​have​ ​the​ ​N ​primes,​ ​with​ ​each cell​ ​containing​ ​the​ ​product​ ​of​ ​the​ ​primes​ ​for​ ​the​ ​corresponding​ ​row​ ​and column.

Description of function :-
    Saving the prime numbers in Array arr.
    For every new number, i,  to test if prime,
        - We are only considering the prime numbers found till the time in array, arr.
            This means that we are checking by dividing i by only prime number less than i.
        - For each value in arr, arr[m], we are keeping track of previousQuotient, found by dividing i by current value in arr, arr[m]
            If the previousQuotient is less than arr[m], meaning - we already checked all possible cases for divisibility of i. And the number i is prime.
        - In the inner loop, we would keep on checking the divisibility of i by arr[m], till the time when either of two not found -
                - We would find i as non prime. Setting variable isNonPrime as true and exit from loop
                - We would reach to the point in arr, where previousQuotient is less than arr[m]. This number i, found as prime number.
        - Outer loop would exits when we would find all N prime numbers and arrIndex would reach to N.
	
Complexity :-
             Time complexity - O( K * SquareRoot(N)), where K can be any number which get incremented till  we find all N prime numbers.
                                                           N is as per input
             Space complexity - O(N)