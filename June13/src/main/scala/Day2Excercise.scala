import scala.io.StdIn.readLine

object Day2Exercise extends App {
  println("Ask user for input")
  val number = readLine("Please Enter a number").toInt //you could add error checking if you remember from last class
  println(number)
  val numbers = (1 to number).toArray
 //val squares = numbers.map(n =>n*n)
  val oddSquares = numbers.map(n =>n*n).filter(n => n*n %2 == 1)
  println(oddSquares.mkString(","))


  def multiply(accumulator: Int, oddSquares: Int): Int = {
    val theMultipl = accumulator * oddSquares

    theMultipl
  }
  println(oddSquares.reduce(multiply))
  //print product(multiplication) of odd squares of numbers from 1 to user input
  //so user enters 5
  //answer would be 1*9*25 = 225

  //so for reduce part you should define mult function or you could write it inline but that is a bit harder

  //goal would be to use view map filter reduce in a single line
  //you can do it first in separate operations of course
}