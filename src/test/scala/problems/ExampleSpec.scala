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

  it should "get last but one" in {
    val last:Option[Int] = Main.lastButOnev1(List[Int](4))
    last should be (None)
    Main.lastButOnev1(List[Int](5,7)) should be (Some(5))

    
  }

  it should "find kth element" in {
    Main.kth(List[Int](4,3),3) should be (None)
    Main.kth(List[Int](4,3),2) should be (Some(3))
  }

  it should "reverse a list" in {
    Main.reverse(List()) should be (List())
    val original = List(4,8,2,5)
    val expected = List(5,2,8,4)
    val result:List[Int] = Main.reverse(original)
    //System.out.println(result)
    result should be (expected)
  }

  it should "check for palindrome"  in {
    Main.isPalindrome(List()) should be (true)
    Main.isPalindrome(List(1)) should be (true)
    Main.isPalindrome(List(1,3)) should be (false)

    Main.isPalindrome(List(3,5,5,3)) should be (true)

    Main.isPalindrome(List(3,3)) should be (true)
    Main.isPalindrome(List(3,5,6,5,3)) should be (true)

  }

  it should "flatten nested lists" in {
    val a = List(List(1,4),List(3,4,5),List(1))
    val expected = List(1,4,3,4,5,1)
    Main.flatten1(a) should be (expected)

    Main.flatten1(List(List(5),List(9))) should be (List(5,9))

    Main.flatten2(a) should be (expected)

    Main.flatten2(List(List(5),List(9))) should be (List(5,9))
  }

  it should "remove consecutive duplicates" in {
    val input = List(1,5,7,3,5,5,5,3,7,1,1)
    val result = Main.compress(input)
    val expected = List(1,5,7,3,5,3,7,1)
    result should be (expected)
  }

}
