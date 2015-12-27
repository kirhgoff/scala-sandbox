package org.kirhgoff.euler

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 27/12/15.
 *
Let d(n) be defined as the sum of proper divisors of n
(numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b
are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are
1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
therefore d(220) = 284. The proper divisors of
284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

 */
object Euler21 {
  val primes = Primes.primesUpTo(10000)
  val allNumbers = (2 to 10000)
    .filter(!primes.contains(_))
    .map(n => new FactorForm(n, Primes.divisors(n, primes)))

  println(allNumbers.mkString("\n"))
}
