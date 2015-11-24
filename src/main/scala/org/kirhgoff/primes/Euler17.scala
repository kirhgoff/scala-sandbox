package org.kirhgoff.primes

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 20/11/15.
 */

object Words {
  def basic(number:Int) = {
    number match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case 10 => "ten"
      case 11 => "eleven"
      case 12 => "twelve"
      case 13 => "thirteen"
      case 14 => "fourteen"
      case 15 => "fifteen"
      case 16 => "sixteen"
      case 17 => "seventeen"
      case 18 => "eighteen"
      case 19 => "nineteen"
      case 20 => "twenty"
      case 30 => "thirty"
      case 40 => "forty"
      case 50 => "fifty"
      case 60 => "sixty"
      case 70 => "seventy"
      case 80 => "eighty"
      case 90 => "ninety"
      case 100 => "hundred"
      case 1000 => "thousand"
    }
  }

  def complicated(number:Int):String = number match {
    case x if x <= 20 => basic(x)
    case x if x < 100 && x % 10 == 0 => basic(x)
    case x if x < 100 => basic(x / 10 * 10) + " " + basic(x % 10)
    case x if x < 1000 && x % 100 == 0 => basic(x / 100) + " hundred"
    case x if x > 100 && x < 1000 => basic(x / 100) + " hundred and " + complicated(x % 100)
    case x if x >= 1000 && x % 1000 == 0 => basic(x / 1000) + " thousand"
  }

  def apply(number:Int) = complicated(number)
}

object Euler17 {
  val wordsLength = (1 to 1000).map(x => Words(x).replace(" ", "").length).sum
  println(wordsLength)
}

