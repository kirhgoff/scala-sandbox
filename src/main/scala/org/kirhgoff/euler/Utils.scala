package org.kirhgoff.euler

/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Utils {
  def pow (value:Int, power:Int):Int = power match {
    case 0 => 1
    case something => value * pow(value, power - 1)
  }

  def endsWithZero(x: Int): Boolean = x % 10 == 0

  def factorial(value:Int):Int = value match {
    case 1 => 1
    case other => other*factorial(other -1)
  }

  def isMoreThanThreeDigit(x:Int) = x > 999
  def isThreeDigit(x:Int) = x > 99 && x <= 999
  def isSixDigit(x:Int) = x > 99999 && x <= 999999

}
