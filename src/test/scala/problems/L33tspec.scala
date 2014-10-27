package problems

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 10/12/14.
 */
class L33tspec extends FlatSpec with Matchers{

  it should "identify overlaps" in {

    L33t.overlaps((2,3),(3,5)) should be (false)
    L33t.overlaps((2,3),(2,5)) should be (true)

    L33t.overlaps((5,7),(3,5)) should be (false)
    L33t.overlaps((4,5),(2,5)) should be (true)
  }

  it should "merge overlaps" in {


    L33t.merge((2,3),(2,5)) should be ((2,5))


    L33t.merge((4,6),(2,5)) should be ((2,6))
  }

  it should "merge all intervals" in {

    val in = List((5,6),(3,5),(2,4),(8,9))
    val result = L33t.mergeIntervals(in)
    result should be (List((2,5)))
  }

  it should "find pallindrom validity" in {
    L33t.isValidPalindrome("malayalam") should be (true)
    L33t.isValidPalindrome("mlayalam") should be (false)
    L33t.isValidPalindrome("malayalama") should be (false)
  }

  it should "find elements in a sorted matrix " in {
    val matrix = Array(Array(1,2,3,10),Array(4,5,9,13),Array(6,7,10,14))
    val sortedMatrix = new SortedMatrix(matrix)
    sortedMatrix.find(6) should be (true)
    sortedMatrix find(100) should be (false)
  }
}
