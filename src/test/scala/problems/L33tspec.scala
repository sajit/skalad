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
}
