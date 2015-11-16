package org.kirhgoff.primes

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 17/11/15.
 *
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

 */
object Euler9 {
  def check(a:Int, b:Int) = (1000*1000 - 2*1000*a - 2*1000*b + 2*a*b) == 0

  val triplets = for (a <- 1 to 999; b <- a + 1 to 1000) yield (a, b)
  val result = triplets.find(p => check(p._1, p._2)).get

  val a = result._1
  val b = result._2
  val c = 1000 - a - b

  println(s"a=$a b=$b c=$c")
  println(s"a^2=${a*a} b^2=${b*b} c^2=${c*c}")
  println(s"abs=${a*b*c}")
}
