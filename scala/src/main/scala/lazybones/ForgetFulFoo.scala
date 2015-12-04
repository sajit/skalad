package lazybones


class ForgetFulFoo {

  def printX(x:Int):Unit = {
    println("Just prints X " + x )
  }

  /**
   * A method that takes in a lazy param but really doesnt use it. Illustrates that lazy
   * params dont get evaluated unless called
   * @param x
   */
  def lazyPrintNonX1(x: => Int):Unit = {

    println("Doesn't really use x at all")
  }

  def lazyPrintX(x: => Int) = {
    println("Hasnt blown up yet coz x is lazy")
    println("Prints x " + x)
  }

  /**
   * Reads a value into a lazy val. Calling lazy val doesnt read that original value again
   * For proof check how many times the lines got printed
   * @param x
   * @return
   */
  def bar(x:Int):Int = {
    var result = Integer.MAX_VALUE;
    lazy val readOnce = {
      print("Evaluating x")
      result = x-1
      x
    }
    println("Lets print readOnce [Should not change result] " + readOnce)
    println("Lets print readOnce again [Should not change result] " + readOnce)
    result
  }

}
