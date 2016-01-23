package org.kirhgoff.euler

import org.kirhgoff.numbers.{Fibonacci, Utils}
import java.lang.Math._
import scala.collection.mutable

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 23/01/16.
 *
 *

The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

 */
object Euler25 {
  println(find(1000))
  println(binet(1000))

  def find (digitsLimit:Int) : Int = {
    var n = 2
    var a = BigInt(1)
    var b = BigInt(1)
    var c = BigInt(0)

    while(Utils.digitsCount(b) < digitsLimit) {
      c = a + b
      a = b
      b = c
      n = n + 1
      //println(s"n=$n a=$a b=$b")
    }
    n
  }

  def findRecursive (digitsLimit:Int) : Int = {
    def internal(n:Int, a:BigInt, b:BigInt):Int = {
      if (Utils.digitsCount(b) == digitsLimit) n
      else internal(n + 1, b, a + b)
    }
    internal(2, BigInt(1), BigInt(1))
  }

  //WTF! it is wrong
  def binet (d:Double) = {
    val phi = (1.0 + sqrt(5.0)) / 2.0

    d*log(10) + log(sqrt(5.0)) / log(phi)
  }

  def investigate() {
    println("fibb\tn")
    var prevFibb = BigInt(1)
    var prevN = BigInt(2)
    var periods: mutable.MutableList[BigInt] = mutable.MutableList()
    for (n <- BigInt(1) to BigInt(200)) {
      val fibb = Fibonacci.nth(n)
      if (Utils.digitsCount(prevFibb) + 1 == Utils.digitsCount(fibb)) {
        println(s"$fibb\t$n\t${n - prevN}")
        prevN = n
        periods += (n - prevN)
      }
      prevFibb = fibb
    }
    println(periods)
    //PizanoPeriod = 5
  }

}
