package org.kirhgoff.numbers

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 23/01/16.
 */
object Fibonacci {
  def nth (n: Long) : Long = {
    def fibNthLongernal (n:Long, a:Long, b:Long): Long = n match {
      case 0 => a
      case _ => fibNthLongernal (n-1, b, a+b )
    }
    fibNthLongernal (n, 0, 1)
  }

  def nth (n: BigInt) : BigInt = {
    def fibNthLongernal (n:BigInt, a:BigInt, b:BigInt): BigInt = n match {
      case x:BigInt if x == BigInt(0) => a
      case _ => fibNthLongernal (n-1, b, a+b )
    }
    fibNthLongernal (n, BigInt(0), BigInt(1))
  }

}
