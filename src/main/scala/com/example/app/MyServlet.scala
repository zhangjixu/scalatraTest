package com.example.app

import com.typesafe.scalalogging.slf4j.Logger
import net.liftweb.json._
import org.scalatra.ScalatraServlet
import org.slf4j.LoggerFactory

import scala.util.parsing.json.JSON

/**
  * @Author: zhangjixu
  * @CreateDate: 2018/9/29
  * @Description:
  * @Version: 1.0.0
  */

case class School(name: String, age: Int)

class MyServlet extends ScalatraServlet {

  val logger = Logger(LoggerFactory.getLogger(getClass.getName))


  get("/") {
    "zhangsan"
  }

  get("/get") {
    val name = params.getOrElse("name", "张三")
    val age = params.getOrElse("age", 19)

    logger.error(s" name : $name age : $age")

    name + age
  }

  post("/post") {
    val jsonString = request.body
    val jsonObj = JSON.parseFull(jsonString)
    val json = jsonObj.getOrElse("").asInstanceOf[Map[String, Any]]
    val name = json.getOrElse("name", "李四").toString
    val age = json.getOrElse("age", 23)

    logger.error(s" name : $name age : $age")

    name + age
  }

  post("/parse") {
    val jsonString = request.body
    implicit val formats = DefaultFormats
    val jValue = parse(jsonString)
    val school = jValue.extract[School]

    logger.error(s" name : ${school.name} age : ${school.age}")

    school
  }

}
