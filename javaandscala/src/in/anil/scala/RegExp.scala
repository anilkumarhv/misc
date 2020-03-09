package in.anil.scala

object RegExp extends App {

  val Name = """(Mr|Mrs|Ms)\. (\w+) (\w+)""".r
//  val Name = """(Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+)""".r
  val smith = "Mr. John Smith"

  val Name(title, first, last) = smith
  val matchesFound = Name.findAllIn(smith)
  matchesFound.foreach(println)

//  println(title)
//  println(first)
//  println(last)

}
