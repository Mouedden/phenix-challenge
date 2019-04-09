object app {
  def main(args: Array[String]): Unit = {
    println("Hello scala, how are you?")
    val members = List(32, 19, 29)
    println(s"I have ${members(1)}")
    for (i <- members)
      println(i)
    println(double(7))
    println(s"Le max est ${max(8, 8)}")
  }
  def double(x: Int): Int = {
    println("inside the function")
    x * 2
  }
  def max(a: Int, b: Int): Int = {
    if (a >= b) a
    else b
  }
}
