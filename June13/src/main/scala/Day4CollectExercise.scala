object Day4CollectExercise extends App {
  println("Day 4 Exercise on Partial Functions and collect")
  //TODO write two partial functions
  //getEvenSquare applies to only positive even numbers  -> returns square
  //doPositives will work on positive numbers
  //getOddCube applies to only positive odd numbers -> returns cube
  //combine both partial functions into a single partial function
  //doPositives will work on positive numbers
  //val numbers = (-5 to 28).toArray
  //using collect get the new values into
  //TODO
  //val processedNumbers =
  //println the results
  val numbers = (-5 to 28).toArray
  val getEvenSquare: PartialFunction[Int, Int] = {
    case x: Int if x>0 && x != 0 => x*x
  }
  val getOddCube: PartialFunction[Int, Int] = {
    case x: Int if x>0 && x != 0 => x*x*x
  }
  val EvenSquareOddCube = getEvenSquare orElse getOddCube
  val processedNumbers = numbers.collect(EvenSquareOddCube)
  println(processedNumbers.mkString(","))
}
