package org.kirhgoff.primes

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 19/11/15.
 The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

 */
object Euler14 {
  case class CollatzSeq(number:Long, length:Int)

  def collatz(number:Long):List[Long] = number match {
    case 1 => Nil
    case n if n % 2 == 0 => n :: collatz(n/2)
    case n => n :: collatz(3 * n + 1)
  }

  val longestOne = (1 to 999999).foldLeft(CollatzSeq(1, 1))((maxSequence, number) => {
    val sequence = collatz(number)
    sequence.length match {
      case l if l > maxSequence.length => CollatzSeq(number, l)
      case _ => maxSequence
    }
  })

  println(longestOne)
}

