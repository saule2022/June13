import scala.io.StdIn.readLine
object TaskXmasTree extends App {
  //TODO ask person's name
  //TODO ask for tree height
  //TODO print a xmas tree (or another tree) by calling printTree function with the correct parameters
  //tree height should be the one assigned
  //simple version for height 3 would be
  //  *
  // ***
  //*****

  //for full points I would like to see the following
  //if user enters name Valdis  and height 9
  //then we should print
  //        *
  //       VVV
  //      AAAAA
  //     LLLLLLL
  //    DDDDDDDDD
  //   IIIIIIIIIII
  //  SSSSSSSSSSSSS
  // VVVVVVVVVVVVVVV
  //AAAAAAAAAAAAAAAAA

  //let's consider maximum height 40 (so person's name letters could repeat many times)

  //def printTree(myName: String, treeTall: Int, symbol: Char = '*', maximumHeight: Int = 40): Unit = {

    println("X-mas tree")

  val myName = readLine("What is your name? ").toUpperCase()
  val treeTall = Math.round(readLine("How tall would you like your tree (from 1 to 40)? ").toInt)

  if (treeTall < 1 || treeTall > 40) println("Tree height should be between 1 and 40. Please try again.")
  else {

    def printTree(myName: String, treeTall: Int, symbol: Char = '*', space: String = " ", max: Int = 40): Unit = {
      println(space * treeTall + symbol)
      for (n <- 1 until treeTall) println(space * (treeTall - n) + ((myName * max) (n - 1)).toString * (n * 2 + 1))
    }
    printTree(myName, treeTall)
  }
}