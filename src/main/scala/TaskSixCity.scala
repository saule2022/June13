
object TaskSixCity extends App{
println("Function to calculate city growth")
  def getCityYear(p0: Int, percentage: Double, delta: Int, targetPopulation: Int):Unit = {
    val numberOfYear = 0

  }

  println(getCityYear(1000,2,50,1200)) // should print 3
  println(getCityYear(1000,2,-50,1200)) // should print -1
  println(getCityYear(1500000,2.5,10000,2000000)) // should print 10
}
