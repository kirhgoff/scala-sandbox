package org.kirhgoff.primes

import org.kirhgoff.primes.Utils._

/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */

class FactorizedPalindrome(val number:Int, val divisors:List[Factor]) {

  val rawDivisors = divisors.flatMap {
    case x: PrimeFactor => List.fill(x.multiplicity)(x.number)
    case x: Remainder => List(x.number)
  }.sorted.reverse

  def initiallyNotFit = rawDivisors.exists(x => x > 999)

  def headIsThreeDigits: Boolean = isThreeDigit(rawDivisors.head)

  def headAndRemainder = {
    (rawDivisors.head, rawDivisors.tail.product) match {
      case (a, b) if isThreeDigit(a) && isThreeDigit(b) => Some(PalindromeResult(number, a, b))
      case _ => None
    }
  }

  def length = rawDivisors.length
  def combinations = factorial(length)
  override def toString = number + " => " + divisors.map(x => x.toString).mkString("[", ", ", "]")  +
    "\tlen=" + length
}

object Palindromes {

  def digits(number:Int):List[Int] = number match {
    case 0 => List()
    case something => (something % 10) :: digits(something / 10)
  }

  def numberFromDigits(digits:List[Int]) = digits.foldLeft(0)((number, digit) => number*10 + digit)

  def palindromeFor(number:Int) = {
    val digitsList:List[Int] = digits(number)
    val length = digitsList.length
    numberFromDigits(digitsList) * pow(10, length) + number
  }

}

case class PalindromeResult(palidrome:Int, a:Int, b:Int) {
  override def toString = palidrome + " = " + a + " * " + b
}

trait PalindromeSieve {
  def sieve(palindromes:List[FactorizedPalindrome]):(Option[PalindromeResult], List[FactorizedPalindrome])
}

class ThreeDigitHeadSieve extends PalindromeSieve{
  override def sieve(palindromes:List[FactorizedPalindrome]):(Option[PalindromeResult], List[FactorizedPalindrome]) = {
    val iterator = palindromes.iterator
    var processed = collection.mutable.MutableList[FactorizedPalindrome]()
    while (iterator.hasNext) {
      val palindrome = iterator.next()
      palindrome.headAndRemainder match {
        case Some(result) => return (Some(result), processed.toList)
        case _ if !palindrome.headIsThreeDigits => processed += palindrome
        case _ =>
      }
    }
    (None, processed.toList)
  }
}

class StartFromBiggest extends PalindromeSieve {
  override def sieve(palindromes: List[FactorizedPalindrome]): (Option[PalindromeResult], List[FactorizedPalindrome]) = {
    val iterator = palindromes.iterator
    var processed = collection.mutable.MutableList[FactorizedPalindrome]()
    while (iterator.hasNext) {
      val palindrome = iterator.next()
      val factors = palindrome.rawDivisors
      val a:Int = factors.head * factors.tail.head
      val b:Int = factors.tail.tail.product

      (a, b) match {
        case (a, b) if isThreeDigit(a) && isThreeDigit(b) => return (Some(PalindromeResult(palindrome.number, a, b)), processed.toList)
        case _ => processed += palindrome
      }
    }
    (None, processed.toList)
  }

}


