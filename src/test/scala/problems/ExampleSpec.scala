package problems

import org.scalatest.{Matchers, FlatSpec}


import scala.collection.mutable.Stack



/**
 * Created by skunnumkal on 7/2/14.
 */
class ExampleSpec extends FlatSpec with Matchers {




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

  it should "pack consdecutive elements into sublists" in {
    val result = Main.pack(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    val expected = List(List('a', 'a', 'a', 'a','a','a'), List('b'), List('c', 'c'), List('d'), List('e', 'e', 'e', 'e'))
    result should be (expected)
  }

  it should "neo pack" in {
    val result = Main.neopack(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    val expected = List(List('a', 'a', 'a', 'a'), List('b'), List('c', 'c'),List('a','a'), List('d'),
      List('e', 'e', 'e', 'e'))
    result should be (expected)
  }


  it should "encode neopacked" in {
    val result = Main.neopack(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))

    val encoded = Main.encodeX(result)
    val expected = List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
    encoded should be(expected)
  }

  it should "encode after neopacking " in {
    val input = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val result:List[(Int,Char)] = Main.encode1(input)
    val expected = List((4,'a'), (1,'b'), (2,'c'), (2,'a'), (1,'d'), (4,'e'))
    result should be (expected)
  }

  it should "passthrough tuples of 1 occurrence" in {
    val input = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val result:List[(Int,Char)] = Main.encode1(input)
    val encodedR = Main.encodeAny(result)
    val expected = List((4,'a'),'b',(2,'c'),(2,'a'),'d',(4,'e'))

    encodedR should be (expected)

  }

  it should "decode an encoded list" in {
    val input = List((4,'a'), (1,'b'), (2,'c'), (2,'a'), (1,'d'), (4,'e'))
    val expected = List('a','a','a','a','b','c','c','a','a','d','e','e','e','e')
    val result = Main.decode(input)
    result should be (expected)
  }

  it should "duplicate elements in three different ways" in {
    val input = List(1,5,7,8)
    val expected = List(1,1,5,5,7,7,8,8)
    Main.duplicateUp_v1(input,2) should be (expected)
    Main.doubleUp_v2(input) should be (expected)
    Main.doubleUp_v3(input) should be (expected)
  }

  it should "drop every 3rd element" in {
    val input = List(5,7,8,2,5,7,9)
    val expected = List(5,7,2,5,9)
    Main.dropNth(input,3) should be (expected)
  }

  it should "split at position 3" in {
    val input  = List(5,6,7,8,9)
    val (x,y) = Main.split(3,input)
    x.length should be (3)
    y.length should be (2)
    x should be (List(5,6,7))
    y should be (List(8,9))
  }

  it should "throw exception for bad length" in {
    val input  = List(5,6,7,8,9)
    intercept[NoSuchElementException] {
      val (x,y) = Main.split(10,input)
    }

  }

  it should "slice up a list" in {
    val input = List(4,6,7,4,5,6,8,1,6)
    val output = Main.extract(2,5,input)
    output should be (List(7,4,5))
  }

  it should "rotate 4 times" in {
    val input = List(4,6,7,4,5,6,8,1,6)
    val expected = List(6,8,1,6,4,6,7,4,5)
    Main.rotate(4,input) should be (expected)
  }

  it should "return a tuple of everytihng other than element" in {
    val input = List(5,7,8,2,5,7,9)
    val expected = List(5,7,2,5,7,9)
    val (list,el) = Main.removeAt(3,input)
    el should be (8)
    list should be (expected)
  }

  it should "insert into a position" in {
    val input = List(5,7,8,2,5,7,9)
    val result = Main.insertAt(3,input,0)
    result should be (List(5,7,8,0,2,5,7,9))
  }

  it should "generate a range" in {
    Main.range(5,10) should be (List(5,6,7,8,9))
  }

  it should "randomly select n items" in {
    val input = List(5,7,8,0,2,5,7,9)
    val result = Main.randomSelect(3,input)
    println(result)
    result.length should be (3)
    result.foreach{ el => input.contains(el) should bes (true)}


  }

  it should "do a lotto " in {
    val result = Main.lotto(6,49)
    result.length should be (6)
    result.foreach{ el => el should be < 49}
  }

  it should "shuffle but not lose" in {
    val input = List(5,9,0,18,5,8,1,4,7)
    val out = Main.shuffle(input)
    println("Shuffled " + out)
    out.foreach{el => input.contains(el) should be (true)}
  }

  it should "return samle length list for 1 selection" in {
    val input = List(1,5,7,8,3,4,0)
    val result = Main.combinations(1,input)
    val oneSelects = List(List(1),List(5),List(7),List(8),List(3),List(4),List(0))
    result should be (oneSelects)
  }

  it should "7c2 is 21" in {
    val input = List(1,5,7,8,3,4,0)
    val result = Main.combinations(2,input)
    //println(result)
    result.length should be (21)
  }

}
