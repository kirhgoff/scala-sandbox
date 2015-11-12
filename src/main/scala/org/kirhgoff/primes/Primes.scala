package org.kirhgoff.primes

/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Primes {

  private def noDividersExist(number: Int, primes: List[Int]) = !primes.exists(x => number % x == 0)

  def primesUpTo(border: Int) = {
    val numbers = 2 to border
    numbers.foldLeft(List(2))((primes, number) => if (noDividersExist(number, primes)) number :: primes else primes)
  }
}