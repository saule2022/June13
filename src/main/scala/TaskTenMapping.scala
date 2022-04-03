import TaskNineWordLength.wordLengths

import scala.io.StdIn.readLine

object TaskTenMapping extends App {
  //counts words *immutable by default
  val sentence = readLine("Please enter sentence. ")
  val words = sentence.split(" ")

  val wordLengths = words.map(words => words.length)
  val wordsMap = Map(words.mkString(", ") -> wordLengths.mkString(", "))

  val wordsLengthArray = for ((word, length) <- words zip wordLengths) yield word -> length
  println(wordsLengthArray.mkString(","))
  println(wordsLengthArray.length)
  val realWordsLengthMap = wordsLengthArray.toMap
  println(realWordsLengthMap)

  //counts characters

  def countCharsByCounting(text: String):Map[Char, Int] = {
    val charCountMap = scala.collection.mutable.Map[Char, Int]()
    for (c <- text) {
      charCountMap += (c -> text.count(_ == c))
    }
    charCountMap.toMap
  }
  println(countCharsByCounting("let's see what we have here"))
}
