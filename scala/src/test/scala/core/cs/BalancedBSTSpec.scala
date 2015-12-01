package core.cs


import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 10/24/14.
 */
class BalancedBSTSpec extends FlatSpec with Matchers{

  it should " create a balanced tree" in {
     val in = List(1,2,3,4,5,6)
     val root:Option[Node] = BalancedBST.convert(in)
     //

     BalancedBST.print(root.get)
    root.get.value should be(4)


  }
}
