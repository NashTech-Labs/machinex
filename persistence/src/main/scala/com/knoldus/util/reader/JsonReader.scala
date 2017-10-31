package com.knoldus.util.reader

import com.knoldus.util.{FileHelper, JsonHelper}

import scala.util.control.NonFatal


class JsonReader(filePath: String) extends FileHelper with FileReader with JsonHelper {

  /**
    * This function takes json file path and returns List[Map[String, Any]]
    *
    * @return List[Map[String, Any]]
    */
  def read: List[Map[String, Any]] = {
    println("\n\n\nRead called..................>>>>>>>>>>>>>>>!111111111111111111111111111111111")
    try {
      println("filePath***********" + filePath)
      parseMaps(read(filePath).mkString(" "))
    } catch {
      case NonFatal(ex) => throw ex
    }
  }

}
