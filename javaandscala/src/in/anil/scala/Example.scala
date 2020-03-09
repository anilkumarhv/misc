package in.anil.scala

object Example extends App {
  val nums = Seq(1, 2, 3, 4, 5)

  println(nums.scan(1)(_ + _))
  println(nums.scanLeft(1)(_ + _))
  println(nums.scanRight(1)(_ + _))

  val sum = nums.fold(0)((acc, a) => acc - a)
  val sum1 = nums.foldLeft(0)((acc, a) => acc - a)
  val sum2 = nums.foldRight(0)((a, acc) => acc - a)
  println(sum)
  println(sum1)
  println(sum2)

  def sumr(a: Int, b: Int): Int = {
    a + b
  }

  val rsum = nums.reduce(sumr);
  val rsum1 = nums.reduceLeft(sumr);
  val rsum2 = nums.reduceRight(sumr);
  println(rsum)
  println(rsum1)
  println(rsum2)

  val names = Seq("Al", "Christina", "Kim")
  println(names.flatten)
  println(names.flatten(_.toUpperCase))
  println(names.flatMap(_.toLowerCase))

  val sbc: (Int, Int) => Int = sumr
  println(nums.fold(1)(sbc))

  val anilName = "Anil Kumar H V"
  val charList = anilName.map(_ != 'a').toList
  val duplist = anilName.trim.toList.filter(c => c != 'a')
  println(duplist)


  val toRemove = "a".toSet
  val words = anilName.filter(toRemove)

  println(words)

  println(charList)
  println(anilName.map(_.toString))
  println(anilName.flatMap(_.toUpper.toString))

  val sbc1: (Int, Int) => Int = (a, b) => {
    a + b
  }

  val sumAdd: (Int, Int) => Int = (a, b) => a + b
}
