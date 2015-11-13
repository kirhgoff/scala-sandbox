package org.kirhgoff.primes

import org.kirhgoff.primes.Utils._
/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
sealed trait Factor
case class PrimeFactor(number:Int, multiplicity:Int) extends Factor {
  override def toString = multiplicity match {
    case 1 => number.toString
    case _ => number + "^" + multiplicity
  }
}
case class Remainder(number:Int) extends Factor {
  override def toString = "[" + number + "]"
}

object Primes {

  private def noDividersExist(number: Int, primes: List[Int]) = !primes.exists(x => number % x == 0)

  def primesUpTo(border: Int) = {
    val numbers = 2 to border
    numbers.foldLeft(List(2))((primes, number) => if (noDividersExist(number, primes)) number :: primes else primes)
  }

  //Deep recursion
  def divisors(number:Int, primes:List[Int]):List[Factor] = {
    primes match {
      case Nil if number == 1 => Nil
      case Nil => List(Remainder(number))
      case prime :: _ => {
        val dividePow:Int = multiplicity(number, prime)
        dividePow match {
          case 0 => divisors(number, primes.tail)
          case _ => PrimeFactor(prime, dividePow) :: divisors(number/pow(prime, dividePow), primes.tail)
        }
      }
    }
  }

  def multiplicity(number:Int, prime:Int):Int = {
    val remainder = number % prime
    remainder match {
      case 0 => 1 + multiplicity(number / prime, prime)
      case _ => 0
    }
  }


}

