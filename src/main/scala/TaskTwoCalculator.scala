import scala.io.StdIn.readLine

object TaskTwoCalculator {
println("Xmas bonus calculator")
  val yourName = readLine("Hi, what is your name? ")
  val yourYears = readLine(s"Nice to meet you, $yourName. How many years have you been working at the firm? ")
  val yourWage = readLine("What your monthly wage would be? ")
  if (yourYears.toInt < 2) {
    println("sorry, no bonus this year")
  }
  else if (yourYears.toInt >= 2) {
    val bonus = yourWage.toDouble * 1.15
    println(s"your bonus this year is $bonus")
  }
}
