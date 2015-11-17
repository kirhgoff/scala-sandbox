package org.kirhgoff.primes 

import org.scalatest._

class EulerAppTest extends FlatSpec with Matchers {

  "RowAggregator" should "properly fold rows" in {
    RowAggregator.fold(1, 1, List(123, 123)) should equal(Some(PalindromeResult(1, 123, 123)))
    RowAggregator.fold(1, 1, List(1234, 123)) should equal(None)
    RowAggregator.fold(1, 1, List(123, 4, 1, 2)) should equal(None)
  }

  "Palindromes" should "properly detect palindromes" in {
    Palindromes.isPalindrome(123321) should equal(true)
    Palindromes.isPalindrome(163321) should equal(false)
    Palindromes.isPalindrome(9999) should equal(true)
    Palindromes.isPalindrome(978) should equal(false)
  }

  "Primes" should "calculate primes with sieve" in {
    Primes.primesWithSieve((1 to 20).toList, List(7, 5, 3, 2)) should equal(List(19, 17, 13, 11, 7, 5, 3, 2))
  }

}
