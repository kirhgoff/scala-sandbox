package org.kirhgoff.primes 

object SimpleApp extends App {
	val primes = Primes.primesUpTo(1000)
  val palindromes = (1 to 999).filter(x => x % 10 != 0).map (Palindromes.palindromeFor)

  palindromes.foreach(p => println (p + " => " + Primes.divisors(p, primes)))
}
