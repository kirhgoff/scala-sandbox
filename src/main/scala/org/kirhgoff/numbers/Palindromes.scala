package org.kirhgoff.numbers

import org.kirhgoff.numbers.Utils._

import scala.collection.mutable

/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */

object Palindromes {
  def palindromeFor(number:Int) = {
    val digitsList:List[Int] = digits(number)
    val length = digitsList.length
    numberFromDigits(digitsList) * pow(10, length) + number
  }

  def isPalindrome(number:Int): Boolean = {
    val forward:List[Int] = digits(number)
    val backwards:List[Int] = forward.reverse

    !(forward, backwards).zipped.exists((a, b) => a != b)
  }
}

class FactorizedPalindrome(val number:Int, val divisors:List[Factor]) {
  val rawDivisors = divisors.flatMap {
    case x: PrimeFactor => List.fill(x.multiplicity)(x.number)
    case x: Remainder => List(x.number)
  }.sorted.reverse

  def initiallyNotFit = rawDivisors.exists(x => x > 999)
  def length = rawDivisors.length

  override def toString = number + " => " + divisors.map(x => x.toString).mkString("[", ", ", "]")  +
    "\tlen=" + length
}

case class PalindromeResult(palindrome:Int, a:Int, b:Int) {
  override def toString = palindrome + " = " + a + " * " + b
}

/**
 * Folds to check it is possible to get a*b where both numbers are 3 digit
 */
object RowAggregator {
  def fold(palindrome:FactorizedPalindrome):Option[PalindromeResult] = fold(palindrome.number, 1, palindrome.rawDivisors)

  def fold(palindrome:Int, head:Int, remainder: List[Int]):Option[PalindromeResult] = {
    val headProduct = head * remainder.head
    val remainderProduct = remainder.tail.product
    (headProduct, remainderProduct) match {
      case (a, b) if isThreeDigit(a) && isThreeDigit(b) => Some(PalindromeResult(palindrome, a, b))
      case (a, _) if isMoreThanThreeDigit(a) => None
      case (_, _) if remainder.tail.length == 1 => None
      case (_, _) => fold(palindrome, headProduct, remainder.tail)
    }
  }
}

case class SieveResult(result:Option[PalindromeResult], palindromes:List[FactorizedPalindrome])

class InitialSieve {
  def headIsThreeDigits (palindrome:FactorizedPalindrome): Boolean = isThreeDigit(palindrome.rawDivisors.head)

  def headAndRemainder (palindrome:FactorizedPalindrome) = {
    val divisors = palindrome.rawDivisors
    (divisors.head, divisors.tail.product) match {
      case (a, b) if isThreeDigit(a) && isThreeDigit(b) => Some(PalindromeResult(palindrome.number, a, b))
      case _ => None
    }
  }

  def sieve(palindromes:List[FactorizedPalindrome]):SieveResult = {
    val iterator = palindromes.iterator
    var processed = collection.mutable.MutableList[FactorizedPalindrome]()
    while (iterator.hasNext) {
      val palindrome = iterator.next()
      headAndRemainder(palindrome) match {
        case Some(result) => return SieveResult(Some(result), processed.toList)
        case _ if !headIsThreeDigits(palindrome) => processed += palindrome
        case _ =>
      }
    }
    SieveResult(None, processed.toList)
  }
}

class PermutationSieve (val sieveResult: SieveResult) {
  def sieve:Option[PalindromeResult] = {
    for (p <- sieveResult.palindromes) {
      println("Checking " + p)
      val permutations:Iterator[List[Int]] = p.rawDivisors.permutations
      while(permutations.hasNext) {
        val raw:List[Int] = permutations.next()
        val result: Option[PalindromeResult] = RowAggregator.fold(p.number, 1, raw)
        if (result.nonEmpty) {
          return result
        }
      }
    }
    None
  }
}

//TODO split to api
/**
 A palindromic number reads the same both ways.
 The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 Find the largest palindrome made from the product of two 3-digit numbers.
 */
object Euler4 {
  def apply() = {
    val primes = Primes.primesUpTo(1000)
    val palindromes = (100 to 999).filter(x => !endsWithZero(x))
      .map(Palindromes.palindromeFor).sorted.reverse

    val factorized = palindromes
      .map(p => new FactorizedPalindrome(p, Primes.divisors(p, primes)))
      .filter(d => !d.initiallyNotFit).toList


    val result: SieveResult = new InitialSieve().sieve(factorized)

    result.palindromes.foreach(p => println(p))
    println("Overall " + result.palindromes.length + " max is " + result.result)

    val finalResult = new PermutationSieve(result).sieve

    println("Final " + finalResult)

    //Final Some(888888 = 962 * 924) - is not correct, WTF!
    println(bruteForceShort)
  }

  def bruteForce() = {
    val candidates = mutable.MutableList[PalindromeResult]()

    for (x <- 100 to 999) {
      for (y <- 100 to 999) {
        val candidate = x * y
        if (Palindromes.isPalindrome(candidate)) {
          candidates += PalindromeResult(candidate, x, y)
        }
      }
    }
    candidates.toList.sortBy(_.palindrome).foreach(p => println(p))
  }

  def bruteForceShort = {
    (for (x <-100 to 999; y <- 100 to 999; z = x*y; if z.toString.equals(z.toString.reverse)) yield z).max
  }
}




