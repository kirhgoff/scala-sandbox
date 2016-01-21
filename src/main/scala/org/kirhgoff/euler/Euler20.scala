package org.kirhgoff.euler

import org.kirhgoff.numbers.{Palindromes, Utils}

/**
 *

n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Euler20 {
  val factorial:BigInt = Utils.factorial(BigInt(100))
  val digits = Palindromes.digits(factorial)
  val sum = digits.sum
  println("F:" + factorial)
  println("Digits: " + digits)
  println("Sum: " + sum)
}
