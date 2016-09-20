package org.kirhgoff.numbers

import java.lang.Math._

/**
  * Created by kirilllastovirya on 17/09/2016.
  */
case class DivisionResult(numbers:List[Long], dotPosition:Long)

object Decimals {
  case class Buffer(result:List[Long], path:List[Long])

  def longDivideRecursive (number:Long, divisor:Long, buffer:Buffer) : Buffer = {
    if (number == divisor) return Buffer(1 :: buffer.result, buffer.path)
    if (buffer.path.contains(number)) {
      return Buffer(buffer.result, number :: buffer.path)
    }

    if (divisor > number) {
      longDivideRecursive(number*10, divisor,
        Buffer(0 :: buffer.result, buffer.path))
    } else {
      val divisorLength = length(divisor)

      var divideTuple = cut(number, divisorLength)
      if (divideTuple._1 < divisor) {
        divideTuple = cut(number, divisorLength + 1)
      }

      val dividePart = divideTuple._1
      val remainder = divideTuple._2
      val remainderLength = length(remainder)

      val result = dividePart / divisor
      val left = (dividePart % divisor) * round(pow(10, remainderLength)) + remainder
      if (left != 0) {
        longDivideRecursive(left, divisor,
          Buffer(result :: buffer.result, number :: buffer.path))
      } else {
        Buffer(result :: buffer.result, buffer.path)
      }
    }
  }

  def equalize(number: Long, divisor: Long): Long = {
    val multiplicator = log10(number * 1d / divisor) match {
      case v if v < 0 => round(pow(10, ceil(-v)))
      case _ => 1
    }
    multiplicator
  }

  def length(number:Long):Long = number match {
    case v if v < 10 => 1
    case v => round(floor(log10 (v))) + 1
  }

  def cut(number:Long, headDigits:Long): (Long, Long) = {
    val numberLength = length(number)
    val divisor = round(pow(10, numberLength - headDigits))

    (number / divisor, number % divisor)
  }
}
