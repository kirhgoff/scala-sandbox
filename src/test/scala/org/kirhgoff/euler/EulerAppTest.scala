package org.kirhgoff.euler

import org.kirhgoff.numbers._
import org.kirhgoff.words.Words
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

  "Words" should "give correct wording for numbers" in {
    Words(10) should equal("ten")
    Words(19) should equal("nineteen")
    Words(72) should equal("seventy two")
    Words(728) should equal("seven hundred and twenty eight")
    Words(520) should equal("five hundred and twenty")
    Words(100) should equal("one hundred")
    Words(113) should equal("one hundred and thirteen")
    Words(300) should equal("three hundred")
    Words(1000) should equal("one thousand")
  }

  "Arrays" should "correctly reverse arrays" in {
    var arr = Array[Byte](0, 1)
    Arrays.reverse(arr, 0, 1)
    arr should equal (Array[Byte](1, 0))

    arr = Array[Byte](0, 1, 2)
    Arrays.reverse(arr, 0, 1)
    arr should equal (Array[Byte](1, 0, 2))

    arr = Array[Byte](0, 1, 2)
    Arrays.reverse(arr, 2, 2)
    arr should equal (Array[Byte](0, 1, 2))

    arr = Array[Byte](0, 2, 1)
    Arrays.reverse(arr, 1, 2)
    arr should equal (Array[Byte](0, 1, 2))

  }

  "Arrays" should "permutate properly" in {
    var arr = Array[Byte](0, 2, 1)
    Arrays.permutate(0, arr)
    arr should equal (Array[Byte](1, 0, 2))

  }

  "Decimals" should "calculate length properly" in {
    Decimals.length(0L) should equal (1L)
    Decimals.length(1L) should equal (1L)
    Decimals.length(20L) should equal (2L)
    Decimals.length(40L) should equal (2L)
    Decimals.length(24L) should equal (2L)
    Decimals.length(100L) should equal (3L)
    Decimals.length(2314L) should equal (4L)
  }

  "Decimals" should "cut properly" in {
    Decimals.cut(234L, 1) should equal (2L, 34L)
    Decimals.cut(100L, 2) should equal (10L, 0L)
    Decimals.cut(1234L, 3) should equal (123L, 4L)
    Decimals.cut(20L, 1) should equal (2, 0)
    Decimals.cut(20L, 2) should equal (20, 0)
    Decimals.cut(40L, 1) should equal (4, 0)
  }

}
