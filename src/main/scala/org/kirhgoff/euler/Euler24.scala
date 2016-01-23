package org.kirhgoff.euler

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 23/01/16.
 *
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of
 * the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically,
 * we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation
 * of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * */
object Euler24 {
  val lower = 123456789L
  val upper = lower * 10L
  val range = Range.Long(lower, upper, 1) //max 10 digits number
  //def permutations = range.filter(n => n.toString.toList.distinct.size == 10)

  var number = lower
  var index:Long = 0L
  while(number < upper && index != 1000000L) {
    if (number.toString.toList.distinct.size == 10) {
      index = index + 1
      if (index % 100 == 0) println(s"index=$index number=$number")
    }
    number = number + 1
  }

  println(number)
}
