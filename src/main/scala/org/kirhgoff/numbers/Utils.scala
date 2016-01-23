package org.kirhgoff.numbers

import scala.math.BigInt

/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Utils {
  def pow (value:Int, power:Int):Int = power match {
    case 0 => 1
    case something => value * pow(value, power - 1)
  }
  def pow (value:Long, power:Long):Long = power match {
    case 0 => 1L
    case something => value * pow(value, power - 1)
  }

  def pow (value:BigInt, power:Long):BigInt = power match {
    case 0 => 1L
    case something => value * pow(value, power - 1)
  }

  def endsWithZero(x: Int): Boolean = x % 10 == 0

  def factorial(value:Int):Int = value match {
    case 1 => 1
    case other => other*factorial(other -1)
  }

  def factorial(value:BigInt):BigInt = value match {
    case x if x == BigInt(1) => BigInt(1)
    case other => other*factorial(other -1)
  }

  def digits(number:Int):List[Int] = number match {
    case 0 => List()
    case something => (something % 10) :: digits(something / 10)
  }

  def digits(number:Long):List[Long] = number match {
    case 0 => List()
    case something => (something % 10) :: digits(something / 10)
  }

  def digits(number:BigInt):List[BigInt] = number match {
    case x if x == BigInt(0) => List()
    case something => (something % 10) :: digits(something / 10)
  }

  def digitsCount(n:Any) = n.toString.length

  def numberFromDigits(digits:List[Int]) = digits.foldLeft(0)((number, digit) => number*10 + digit)

  def isMoreThanThreeDigit(x:Int) = x > 999
  def isThreeDigit(x:Int) = x > 99 && x <= 999
  def isSixDigit(x:Int) = x > 99999 && x <= 999999

}
