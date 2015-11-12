object Primes {

  private def isPrime (number:Int, primes:List[Int]) = {
    !primes.exists(x => number % x == 0)
  }

  def primesUpTo(border:Int) = {
    val numbers = 2 to border
    numbers.foldLeft(List(2))((primes, number) =>
      if (isPrime(number, primes)) number :: primes else primes
    )
  }

  def main(args: Array[String]) = {

  }
}