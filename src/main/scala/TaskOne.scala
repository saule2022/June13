import scala.io.StdIn.readLine

object TaskOne extends App {
    val yourName = readLine("Hi, what is your name? ")
    val yourAge = readLine(s"Nice to meet you, ${yourName}. How old are you? ")
    val year = 2022
    val yearHundret = 100 - yourAge.toInt + 2022
    println(s"You will be 100 years ol in $yearHundret.")
}
