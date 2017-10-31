package com.knoldus.common


case class FileType(`type`: String)

object FileTypes {

  val json = FileType("json")
  val text = FileType("text")
  val csv = FileType("csv")
}
