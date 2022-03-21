import scala.io.StdIn.readLine
object TaskFourFizzBuzz extends App{
  val fizz = 5
  val buzz = 7
  val minValue = 1
  val maxValue = 100

for (x <- minValue to maxValue) {
  if (x % fizz == 0 && x % buzz == 0)
    print("FizzBuzz, ")
  else if (x % buzz == 0)
    print("Buzz, ")
  else if (x % fizz == 0)
    print("Fizz, ")
  else
    print(x + ", ")
}
}
