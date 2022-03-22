import scala.io.StdIn.readLine
object TaskNineWordLength extends App {
  val sentence = readLine("Please enter sentence. ")
  val words = sentence.split(" ")
  println(words.mkString(", "))

  val wordLengths = words.map(words => words.length)
  println(wordLengths.mkString(", "))

  val lengthOverFive = words.filter(_.length > 5)
  println(lengthOverFive.mkString(","))
}