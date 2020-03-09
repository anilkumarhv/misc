package in.anil.scala

import java.time.LocalDate

object ScalaProg {

  def main(args: Array[String]): Unit = {
    println(pack1(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

    val numbers = Seq(1, 2, 3, 4, 5, 6, 7)
    val newNum = numbers.map(_ + 3).toList
    println(newNum)

    println(numbers.sliding(4, 1).toList)

    println(numbers.grouped(4).toList)

    def maxLengthFourSublist(list: List[Int]): List[Int] = {
      list.sliding(4, 1).maxBy(_.sum)
      //      list.grouped(4).maxBy(_.sum)
    }

    println(maxLengthFourSublist(numbers.toList))
    numbers.zipWithIndex.foreach {
      case (day, count) => println(s"$count is $day")
    }
    numbers.view.zipWithIndex.foreach { z => println(s"${z._2} is ${z._1}") }

    for ((num, ind) <- numbers.zip(LazyList from 1)) {
      println(s"$ind is $num")
    }
    val date = LocalDate.of(1991, 12, 12)
    println(date.getDayOfWeek)

  }

  def pack[A](l: List[A]): List[List[A]] = {
    @scala.annotation.tailrec
    def _pack(res: List[List[A]], rem: List[A]): List[List[A]] = rem match {
      case Nil => res
      case ls =>
        val (s: List[A], r: List[A]) = rem span {
          _ == rem.head
        }
        _pack(res ::: List(s), r)
    }

    _pack(List(), l)
  }

  def pack1[A](l: List[A]): List[List[A]] = {
    @scala.annotation.tailrec
    def _pack2(res: List[List[A]], rem: List[A]): List[List[A]] = rem match {
      case Nil => res
      case h :: tail if (res.isEmpty || res.last.head != h) => _pack2(res ::: List(List(h)), tail)
      case h :: tail => _pack2(res.init ::: List(res.last ::: List(h)), tail)
    }

    _pack2(List(), l)
  }
}

