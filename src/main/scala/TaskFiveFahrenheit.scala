import scala.io.StdIn.readLine
object TaskFiveFahrenheit extends App{
def fahrenheitCelsius(): Unit = {
  val Fahrenheit = readLine("What is temperature in Fahrenheit? ").toDouble
  val Celsius = ((Fahrenheit - 32) * 5 / 9)
  println(s"$Fahrenheit of Fahrenheit is $Celsius of Celsius")
  }
  fahrenheitCelsius
}
