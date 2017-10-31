package com.knoldus.conceptlearning

import java.io.File

import com.knoldus.conceptlearning.find_s.FindS
import org.scalatest.{BeforeAndAfterAll, WordSpec}


class FindSSpec extends WordSpec with BeforeAndAfterAll{

  val finds = new FindS()

  override def beforeAll: Unit ={
    finds.training(Map("feature1" -> "value1", "feature2" -> "value1", "result" -> true))
    finds.persist
  }

  "FindS" should {

    "be trained" in {
      val result = finds.training(Map("feature1" -> "value1", "feature2" -> "value2", "result" -> true))
      assert(result === true)
    }

    "be predict" in {
      val result = finds.predict(Map("feature1" -> "value1", "feature2" -> "value1"))
      assert(result)
    }

    "return hypothesis" in {
      val result = finds.getHypothesis
      assert(result === Map("feature2" -> "?", "feature1" -> "value1"))
    }

  }

  override def afterAll: Unit ={
    new File("/tmp/find_s").delete()
  }

}
