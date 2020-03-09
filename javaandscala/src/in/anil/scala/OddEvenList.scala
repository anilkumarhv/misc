package in.anil.scala

object OddEvenList extends App {
  val list = Seq(
    Person(1, "anil"),
    Person(2, "anilsad"),
    Person(3, "anilsad1"),
    Person(4, "anilsd"),
    Person(5, "anilsd"),
    Person(2, "anilsad"),
    Person(3, "anilsad1")
  )

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val even: (Int) => Boolean = n => n % 2 == 0
  val odd: (Int) => Boolean = n => n % 2 == 1
  var evenList = List.empty[Int]
  var oddList = List.empty[Int]
  nums.foreach {
    case n if even(n) => evenList = evenList :+ n
    case n if odd(n) => oddList = oddList :+ n
  }

  //  val evens = nums.foldLeft(evenList)((accu, n) => {
  //    if (even(n)) {
  //      evenList = accu :+ n
  //    }
  //    evenList
  //  })
  //  println(evens)

  println(evenList)
  println(oddList)

  //  println(nums.filter(n => n % 2 == 0))

  println(list.groupBy(p => p.id).view.mapValues(person => person.map(_.name)).values.toList)
}

case class Person(id: Int, name: String)