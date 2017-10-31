package com.knoldus.util

import org.scalatest.WordSpec


case class Test(field1: String, field2: Int)

class JsonHelperSpec extends WordSpec with JsonHelper{

    "JsonHelper" should {

      "write case class" in {
        assert(write(Test("string", 543)) === """{"field1":"string","field2":543}""")
      }

      "parse json into case class" in {
        assert(parse("""{"field1":"string","field2":543}""").extract[Test] === Test("string", 543))
      }

      "print pretty" in {
        assert(pretty("""{"field1":"string","field2":543}""").length === 39)
      }

      "parse maps" in {
        assert(parseMaps("""[{"field1":"string","field2":543}]""") === List(Map("field1" -> "string", "field2" -> 543)))
      }

      "parse map" in {
        assert(parseMap("""{"field1":"string","field2":543}""") === Map("field1" -> "string", "field2" -> 543))
      }
    }

}
