import scala.io.StdIn.readLine
object TaskEightSequence extends App {
  //Calculate cubes of these integers including start and end AND store results in a sequence
  //Print the saved sequence on screen

  //extra challenge save odd cubes and print them
  val startNumber = readLine("Hi, what is starting number? ").toInt
  val endNumber = readLine("What is ending number? ").toInt
  var sum = 0

  for (n <- startNumber to endNumber) {
    val cubeNumbers = n * n * n
    sum += cubeNumbers
  }

  val sequence = Seq(sum)
  println(sequence.mkString(", "))
}
//use yeld
