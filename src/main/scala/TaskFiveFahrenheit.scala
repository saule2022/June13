import scala.io.StdIn.readLine
object TaskFiveFahrenheit extends App{
def fahrenheitCelsius(): Unit = {
  val Celsius = readLine("What is temperature in Celsius? ").toDouble
  val Fahrenheit = ((Celsius * 9 / 5) + 32)
  println(s"$Celsius of Celsius is $Fahrenheit of Fahrenheit.")
  }
  fahrenheitCelsius
}
