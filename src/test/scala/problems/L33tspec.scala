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

  it should "count subseq occurences" in {
    val target = "rabbbitt"
    val search = "abbit"
    L33t.countSequences(target,search) should be (6)
    L33t.countSequences("rabbitaabbi",search) should be (1)
  }

  it should "find max continuous sub array" in {
    val in:List[Int] =  List(-2,1,-3,4,-1,2,1,-5,4)
    L33t.maxContSeqSum(in) should be (6)
  }

  it should "find min diff" in {
    val a = List(100,101,105)
    val b = List(20,23,108,200)
    L33t.findMinDiff(a,b,Integer.MAX_VALUE) should be (3)
  }
  it should "find min diff for not found words" in {
    val a = List(100,101,105)
    val b = List()
    L33t.findMinDiff(a,b,Integer.MAX_VALUE) should be (Integer.MAX_VALUE)
  }
}
