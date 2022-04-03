import scala.io.StdIn.readLine

object TaskElevenPangram extends App{

  val text = readLine("Please enter a Pangram. ").toUpperCase
  val words = text.split("")
  val uniquewords = words.toSet
  val alphabet = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z")
  val divideAlphabet = alphabet.split("")
  val alphabetChar = divideAlphabet.toSet
  if (uniquewords == alphabetChar) println("Pangram.")
  else println("not a Pangram.")

  //or a function

  def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {
    val charSet = text.toLowerCase.toSet
    val alphaSet = alpha.toSet
    alphaSet.subsetOf(charSet)
  }
  val defText = text.toLowerCase
  println(isPangram(defText))
}
