package in.anil.scala

import java.util.regex.{Matcher, Pattern}

case object ReplaceXmlName extends App {
  var text = "<Test:Name>hello</Test:Name>"
  val pattern = Pattern.compile("(?<=<)\\w+:")
  val matcher = pattern.matcher(text)

  val exp = "(?<=<)\\w+:".r
  val sReplacer = ""
  val result = exp.replaceAllIn(text, sReplacer)
  println(result)



  while ( {
    matcher.find
  }) text = text.replaceAll(matcher.group, sReplacer)
  println(text)

}
