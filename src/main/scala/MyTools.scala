object MyTools extends App {
  def numberRounding(n: Double, precision: Int = 0): Double = {
    val multiplier = Math.pow(10, precision)
    (n*multiplier).round/multiplier
  }
  //println(numberRounding(3.1415926, 2))
}

//rounding function