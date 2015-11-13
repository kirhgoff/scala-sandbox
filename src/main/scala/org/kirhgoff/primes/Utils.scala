package org.kirhgoff.primes

/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Utils {
  def pow (value:Int, power:Int):Int = power match {
    case 0 => 1
    case something => value * pow(value, power - 1)
  }
}
