class Calc {

  /** Test grammar with BDD
   *
   *  "Target" should "behaviour" {
   *   // Test details using assertion
   *  }
   */
  /** Get Integer's array, and return the Integer sum them all.
   *
   *  Overflow occure when sum them all is over Integer.MAX_VALUE.
   *
   *  @param seq Integer's array
   *  @return an Integer value sum all Integers into the array
   */
  def sum(seq: Seq[Int]): Int = seq.sum

  /** Receive two Integers, and return float values Divided the numerator by the denominator
   *
   *  @param numerator   Number to divide
   *  @param denominator Number to be divided
   *
   *  @return Float value, or Exception is thrown when trying to divide with 0
   */
  def div(numerator: Int, denominator: Int): Double = {
    if (denominator == 0) throw new ArithmeticException("/ by zero")
    numerator.toDouble / denominator.toDouble
  }

  /** Receive one Integer value, and return boolean value whether it is Integer type or not
   *
   *  @param n Integer value
   *  @return Boolean value,
   */
  def isPrime(n: Int): Boolean =
    if (n < 2) false else !(2 to Math.sqrt(n).toInt).exists(n % _ == 0)

  /** sample
   *
   *  @param s
   *  @param n
   */
  def sample(s: String, n: Int): Unit =
    println(s"${s}: ${n}")
}
