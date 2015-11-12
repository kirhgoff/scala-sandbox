package org.kirhgoff.primes 

object SimpleApp extends App {
	val primes = Primes.primesUpTo(1000)
  val palindromes = (1 to 999).map (Palindromes.palindromeFor).exit

  palindromes.map (println)
}
