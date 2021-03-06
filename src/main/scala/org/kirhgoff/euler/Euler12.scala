package org.kirhgoff.euler

import org.kirhgoff.numbers.{Primes, Factor}

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 19/11/15.
  The sequence of triangle numbers is generated by adding the natural numbers.
  So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
  The first ten terms would be:

  1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

  Let us list the factors of the first seven triangle numbers:

   1: 1
   3: 1,3
   6: 1,2,3,6
  10: 1,2,5,10
  15: 1,3,5,15
  21: 1,3,7,21
  28: 1,2,4,7,14,28
  We can see that 28 is the first triangle number to have over five divisors.

  What is the value of the first triangle number to have over five hundred divisors?
 */
object Euler12 {
  val primes = Primes.primesUpTo(100000)

  val iterator = Iterator.iterate(TriangleNumber(1, 1, List())) {
    case number => {
      val newIndex = number.index + 1
      val newValue = number.value + newIndex
      TriangleNumber(newIndex, newValue, Primes.divisors(newValue, primes))
    }
  }

  val triangleNumbers = iterator.takeWhile(p => p.divisersCount <= 600)
    .toList.filter(p => p.divisersCount > 500).sortBy(t => t.divisersCount)

  triangleNumbers.foreach(n => println(n))

}

case class TriangleNumber(index:Int, value:Int, factors:List[Factor]) {
  override def toString = value + "=>" + factors.mkString(", ") + "=>" + divisersCount
  def divisersCount = factors.map(_.variants).product
}
