import org.specs2._

class PrimesSpec extends Specification {

    "Primes" should {
      "be able to find primes up to the number" in {
        Primes.primesUpTo(4) shouldEqual List(2, 3)
      }
    }
}