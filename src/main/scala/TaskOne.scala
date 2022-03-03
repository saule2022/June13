import java.time.Year
import scala.io.StdIn.readLine
object TaskOne extends App {
    val yourName = readLine("Hi, what is your name? ")
    val yourAge = readLine(s"Nice to meet you, $yourName. How old are you? ")
    val year = Year.now.getValue
    val yearHundred = 100 - yourAge.toInt + year
    println(s"You will be 100 years old in $yearHundred.")
}
