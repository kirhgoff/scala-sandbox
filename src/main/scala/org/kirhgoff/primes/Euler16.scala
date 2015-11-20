package org.kirhgoff.primes

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 19/11/15.
 */
object Euler16 {

  val pow = Utils.pow(BigInt(2), 1000)
  val digits = Palindromes.digits(pow)
  val sum = digits.sum
  println(s"$pow\t\t\t$sum")
}
