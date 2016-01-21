package org.kirhgoff.numbers

import Utils._
/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
sealed trait Factor {
  def variants:Int
  def flat:List[Int]
}

case class PrimeFactor(number:Int, multiplicity:Int) extends Factor {
  override def toString = multiplicity match {
    case 1 => number.toString
    case _ => number + "^" + multiplicity
  }
  override def flat = List.fill(multiplicity)(number)

  override def variants: Int = multiplicity + 1
}
case class Remainder(number:Int) extends Factor {
  override def toString = number.toString
  override def variants: Int = 2

  override def flat = List(number)
}

case class FactorForm (number:Int, factors: List[Factor]) {
  def properDivisors = {
    val flatFactors = 1 :: factors.flatMap(_.flat)
    (1 to flatFactors.length - 1)
      .flatMap(i => flatFactors.combinations(i).toList)
      .toList.map(_.product).filter(_ != number).distinct.sorted
  }
}

object Primes {

  private def noDividersExist(number: Int, primes: List[Int]) = !primes.exists(x => number % x == 0)

  def nth(number: Int) = {
    def recurse(index:Int, current:Int, primes:List[Int]):List[Int] = index match {
      case i if index == number => primes
      case i => current match {
        case x if noDividersExist(x, primes) => recurse(i + 1, x + 1, x :: primes)
        case x => recurse(i, x + 1, primes)
      }
    }

    recurse(1, 2, List())
  }

  def primesWithSieve (numbers:List[Int], primes:List[Int]):List[Int] = {
    numbers match {
      case Nil => primes
      case list => list.head match {
        case 1 => primesWithSieve(list.tail, primes)
        case number if noDividersExist(number, primes) => primesWithSieve(list.tail, number :: primes)
        case _ => primesWithSieve(list.tail, primes)
      }
    }
  }

  def primesUpTo(border: Int) = {
    val numbers = 3 to border by 2
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

