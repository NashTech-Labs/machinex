package com.knoldus.util.reader


trait FileReader {

  //Read file content as List[Map[String, Any]]
  def read: List[Map[String, Any]]

}
