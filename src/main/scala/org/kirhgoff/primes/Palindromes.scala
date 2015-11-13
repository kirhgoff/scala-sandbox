package org.kirhgoff.primes

import org.kirhgoff.primes.Utils._
/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */

class Divisors(val divisors:List[Factor]) {
  //TODO
}

object Palindromes {

  def digits(number:Int):List[Int] = number match {
    case 0 => List()
    case something => (something % 10) :: digits(something / 10)
  }

  def numberFromDigits(digits:List[Int]) = digits.foldLeft(0)((number, digit) => number*10 + digit)

  def palindromeFor(number:Int) = {
    val digitsList:List[Int] = digits(number)
    val length = digitsList.length
    numberFromDigits(digitsList) * pow(10, length) + number
  }

}
