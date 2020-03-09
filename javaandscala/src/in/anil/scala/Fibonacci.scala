package in.anil.scala

import scala.annotation.tailrec
import scala.language.postfixOps

object Fibonacci extends App {

  val fib: LazyList[Int] = 0 #:: fib.scanLeft(1)(_ + _)
  //  val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

  println(fib take 10 toList)

  lazy val gcdVal: (Int, Int) => Int = gcd

  println(factorial(5))
  println(gcdVal(10, 20))

  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def factorial(n: BigInt): BigInt = {
    @tailrec
    def fact(x: BigInt, result: BigInt): BigInt = if (x == 0) result else fact(x - 1, result * x)

    fact(n, result = 1)
  }

  val strr = Abct(10, "abc")("anil")
  println(strr)

  val x = 0

  def f(y: Int): Int = y + 1

  val result = {
    val x = f(3)
    x * x
  } + x

  println(result)

  def fibonacci(in: Int): Int = {
    in match {
      case n if n <= 0 => 0
      case 0 | 1 => 1
      case n => fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  val f = fibonacci(3)

  println(f)


}

case class Abct(int: Int, string: String) extends (String => String) {
  override def apply(v1: String): String = string.concat(v1).concat(String.valueOf(int))
}
