package org.kirhgoff.euler

import org.kirhgoff.numbers.Utils

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 19/11/15.
 */
object Euler16 {

  val pow = Utils.pow(BigInt(2), 1000)
  val digits = Utils.digits(pow)
  val sum = digits.sum
  println(s"$pow\t\t\t$sum")
}
