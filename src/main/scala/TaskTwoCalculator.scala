import scala.io.StdIn.readLine

object TaskTwoCalculator extends App {
println("X-mas bonus calculator")
  val yourName = readLine("Hi, what is your name? ")
  val yourYears = readLine(s"Nice to meet you, $yourName. How many years have you been working at the firm? ")
  if (yourYears.toInt <= 2) {
    println("Sorry, no bonus this year.")
  }
  else if (yourYears.toInt > 2) {
    val yourWage = readLine("What your monthly wage would be? ")
    val bonus = yourWage.toDouble * 0.15 * (yourYears.toDouble - 2)
    val bonusI = bonus.toInt
    println(s"Your bonus this year is $bonusI.")
  }
}
