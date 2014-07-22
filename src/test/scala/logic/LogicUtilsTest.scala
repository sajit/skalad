package logic

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 7/22/14.
 */
class LogicUtilsTest extends FlatSpec with Matchers{

  it should "get graycode" in {
    LogicUtils.grayCode(1) should be (List("0","1"))
    LogicUtils.grayCode(2) should be (List("00","01","10","11"))
    LogicUtils.grayCode(3) should be (List("000","001","010","011","100","101","110","111"))

  }

}
