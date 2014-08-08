package oopsie

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by sajit on 8/8/14.
 */
class Oopsec extends FlatSpec with Matchers {

  it should "initialize" in {
    val text = "Why is the earth round?"
    val shortAnswer:ShortAnswer = ShortAnswer(text)
    shortAnswer.text should be (text)
  }

}
