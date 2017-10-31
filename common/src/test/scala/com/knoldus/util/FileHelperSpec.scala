package com.knoldus.util

import java.io.File

import org.scalatest.{BeforeAndAfterAll, WordSpec}


class FileHelperSpec extends WordSpec with FileHelper with BeforeAndAfterAll {

  "FileHelper" should {

    "read file" in {
      val filePath = getClass.getResource("/testfile").getPath
      assert(read(filePath) === List("This is a test file", "Testing file reader"))
    }

    "write file" in {
      assert(write(List("Hello this is a test file"), "testfile") === true)
    }

    "reset file" in {
      write(List("Hello this is a test file"), "testfile")
      assert(reset("testfile") === true)
    }

  }

  override def afterAll: Unit = {
    new File("testfile").delete()
  }

}
