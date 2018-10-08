package com.example.app

import com.alibaba.fastjson.JSON
import com.typesafe.scalalogging.slf4j.Logger
import org.scalatra.ScalatraServlet
import org.slf4j.LoggerFactory

/**
  * @Author: zhangjixu
  * @CreateDate: 2018/9/29
  * @Description:
  * @Version: 1.0.0
  */
class SecondServlet extends ScalatraServlet{

  val logger = Logger(LoggerFactory.getLogger(getClass.getName))

  get("/gets") {
    logger.error(" =============== gets")
  }

  post("/post") {
    val jsonString = request.body
    val json = JSON.parseObject(jsonString)
    logger.error(s"age : ${json.getBigInteger("age")} name : ${json.getString("name")}  ")
  }

}
