package org.kirhgoff.euler

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 17/11/15.

  The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
  Find the sum of all the primes below two million.

 */
object Euler10 {
  //:) val primesSum = Primes.primesUpTo(2000000).map(x => x.toLong).sum
  var numbers = (2 to 2000000).toSet

  val primesSieve = Primes.primesUpTo(200000)
  println(s"Sieve size ${primesSieve.length}")

  val bigSieve = for (p <- primesSieve;i <- p to 2000000 / p) yield i*p
  println(s"Big sieve size=${bigSieve.length}")

  val remains = numbers diff bigSieve.toSet
  println(s"Remaining size=${remains.size}")

  val primes = Primes.primesWithSieve(remains.toList, primesSieve)
  println(s"Primes size=${primes.size}")

  //val primesString = primes.sorted.mkString("\n")
  //Some(new PrintWriter("./primes.txt")).foreach{p => p.write(primesString); p.close}
  println("Sum=" + primes.map(p => p.toLong).sum)

}
