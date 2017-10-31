package com.knoldus.conceptlearning

import java.io.File

import com.knoldus.common.Model
import com.knoldus.conceptlearning.find_s.{FindS, FindSTrainer}
import org.scalatest.{BeforeAndAfterAll, WordSpec}

import scala.io.Source



class FindSTrainerSpec extends WordSpec with BeforeAndAfterAll{

  val fildsTrainer = new FindSTrainer{
    val trainingSampleFilePath: String = "../learning/src/test/resources/trainingsample2.json"
    val model: Model = new FindS()
  }

  override def beforeAll: Unit ={
//    fildsTrainer.training(Map("feature1" -> "value1", "feature2" -> "value1", "result" -> true))
//    finds.persist
  }


  "FindSTrainer" should {

    "train" in {
      val response = fildsTrainer.train
      val resultHypothesis = fildsTrainer.model.getHypothesis
      assert(resultHypothesis === Map("field2" -> 543, "field1" -> "string"))
    }


  }

  override def afterAll: Unit ={
    new File("/tmp/find_s").delete()
  }

}
