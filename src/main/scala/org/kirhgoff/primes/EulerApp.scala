package org.kirhgoff.primes

import org.kirhgoff.primes.Utils._

object EulerApp {
  //A palindromic number reads the same both ways.
  //The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
  //Find the largest palindrome made from the product of two 3-digit numbers.
  def euler4() = {
    val primes = Primes.primesUpTo(1000)
    val palindromes = (100 to 999).filter(x => !endsWithZero(x))
      .map(Palindromes.palindromeFor).sorted.reverse

    val factorized = palindromes.map(p => new FactorizedPalindrome(p, Primes.divisors(p, primes)))
      .filter(d => !d.initiallyNotFit).toList

    val firstAttempt:(Option[PalindromeResult], List[FactorizedPalindrome]) = new ThreeDigitHeadSieve().sieve(factorized)
    val secondAttempt = new StartFromBiggest().sieve(firstAttempt._2)

    secondAttempt._2.foreach(d => println(d))
    println("Overall " + secondAttempt._2.length + " max is " + secondAttempt._1)
  }

  def main(args: Array[String]) {
    euler4
  }
}
