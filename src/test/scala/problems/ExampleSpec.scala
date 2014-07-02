package problems

import org.scalatest.{Matchers, FlatSpec}


import scala.collection.mutable.Stack



/**
 * Created by skunnumkal on 7/2/14.
 */
class ExampleSpec extends FlatSpec with Matchers {


  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }

  it should "get last" in {
    val last:Option[Int] = Main.last(List[Int]())
    last should be (None)
    Main.last(List[Int](5,7)) should be (Some(7))
  }


}
