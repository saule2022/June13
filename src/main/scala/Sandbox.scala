import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ArraySeq
import scala.io.StdIn.readLine
object Sandbox extends App {

  val numbers = (0 to 12).toArray
  println(numbers.mkString(","))

  val squares = numbers.map(r => r*r)
  println(squares.mkString(", "))

  val squaresAgain = for (n <- numbers) yield n*n
  println(squaresAgain.mkString(", "))

  val squareBuffer = ArrayBuffer[Int]()
  for (n <- numbers) {
  squareBuffer += n*n
  }
  val squaresFromBuffer = squareBuffer.toArray
  println(squaresFromBuffer.mkString(", "))

  val squaresFromMap = numbers.map(Math.pow(_,2).toInt)
  println(squaresFromMap.mkString(", "))

  val plusTen = numbers.map(_+10)
  println(plusTen.mkString(", "))

def complicated(n: Int):Double = {
  (n - 32) * 9 / 5
}

val calculatedNumber = numbers.map(complicated)
println(calculatedNumber.mkString(", "))

val myOddNumbers = numbers.map(it => it % 2 == 1)
  println(myOddNumbers.mkString(", "))

  val myNewValues = numbers.filter(_ % 4 == 0).map(_ + 100).map(_ * 3)
  println(myNewValues.mkString(", "))
}
