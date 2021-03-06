package org.kirhgoff.euler

import org.kirhgoff.numbers.Arrays

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
  //val symbols:Array[Byte] = Array[Byte](0, 1, 2)
  //val symbols:Array[Byte] = Array[Byte](1, 2, 3, 4)
  val symbols:Array[Byte] = Array[Byte](0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

  //WTF with indices?
  Arrays.permutate(999999, 1, symbols)
  println(symbols.mkString)

}
