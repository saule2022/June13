import scala.io.StdIn.readLine
object TaskThreeHealth extends App {
  println("Temperature exercise")
  val yourTemperature = readLine("Hi, what is your temperature? ").toDouble
  if (yourTemperature < 35) {
    println("That is a bit too cold.")
  }
  else if (yourTemperature >= 35 && yourTemperature <= 37) {
    println("You are all right!")
  }
    else println("You have a fever! Consider contacting a doctor.")
}
