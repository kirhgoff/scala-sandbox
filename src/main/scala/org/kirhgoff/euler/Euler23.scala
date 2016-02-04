package org.kirhgoff.euler

import org.kirhgoff.numbers.{FactorForm, Primes}

import scala.collection.immutable.Range.Inclusive

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
 * which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n
 * and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
 * the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than
 * 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis
 * even though it is known that the greatest number that cannot be expressed
 * as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Euler23 {
  val started = System.currentTimeMillis
  private val TopRange: Int = 28123
  val primes = Primes.primesUpTo(TopRange)
  println (s"Primes are calculated ${primes.size}")

  private val targetNumbers = (1 to TopRange).toList.sorted
  val allNumbers = targetNumbers
    .filter(!primes.contains(_))
    .map(n => new FactorForm(n, Primes.divisors(n, primes)))
  println(s"Processed all numbers ${allNumbers.size}")

  val abundant = allNumbers.filter(ff => ff.properDivisors.sum > ff.number).map(ff => ff.number)
  println(s"Found abundant numbers ${abundant.size}")

  //Possible to optimize
  //val (first, second) = abundant.partition(_ < TopRange/2)
  //val abundantPairs = (for (x <- first; y <- second) yield x + y).distinct.filter(_ < TopRange).sorted
  val abundantPairs = (for (x <- abundant; y <- abundant) yield x + y).filter(_ < TopRange).distinct.sorted
  println(s"Found abundant pairs ${abundantPairs.size}")

  val nonAbundant = filterNumbers(targetNumbers, abundantPairs, List())
  println(s"nonAbundant ${nonAbundant.size}")

  println(s"Result is ${nonAbundant.sum} in ${(System.currentTimeMillis() - started)/1000} sec") //4179805

  def filterNumbers(numbers:List[Int], filters:List[Int], result:List[Int]):List[Int] = {
    numbers match {
      case Nil => result
      case number :: numbersTail =>
        filters match {
          case Nil => result ++ numbersTail
          case filter :: filtersTail if filter < number => filterNumbers(numbers, filtersTail, result)
          case filter :: filtersTail if filter == number => filterNumbers(numbersTail, filtersTail, result)
          case filter :: filtersTail if filter > number => filterNumbers(numbersTail, filters, number :: result)
        }
    }
  }
}
