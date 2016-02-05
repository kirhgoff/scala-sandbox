package org.kirhgoff.numbers

/**
  * Created by kirilllastovirya on 6/02/2016.
  */
object LastoClass {
  val number = 667
  val base = 6

  def translate (number:Int, base:Int, result:List[Int]) : List[Int] = {
    number match {
      case x if x < base => x :: result
      case x => translate (number/base, base, x % base :: result)
    }
  }

  val result = translate(number, base, Nil)
  println (s"Number $number translated into base $base is ${result.mkString("")}")


}
