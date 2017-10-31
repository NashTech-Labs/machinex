package com.knoldus.util.reader

import java.io.File

import org.scalatest.{BeforeAndAfterAll, WordSpec}


class JsonReaderSpec extends WordSpec with BeforeAndAfterAll {

  val jsonFilePath = getClass.getResource("/sample_json_file").getPath
  val jsonReader = new JsonReader(jsonFilePath)

  "JsonReader" should {

    "read file" in {
      assert(jsonReader.read.head === Map("field1" -> "string", "field2" -> 543))
    }

  }

  override def afterAll: Unit = {
    new File("sample_json_file").delete()
  }

}
