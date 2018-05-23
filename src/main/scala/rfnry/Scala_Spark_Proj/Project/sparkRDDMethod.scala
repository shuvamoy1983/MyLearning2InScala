package Project


import utils.Utility.sparkContext
import utils.Utility.sparkEntry
import utils.Utility.returnRdd
import org.apache.spark.rdd





object sparkRDDMethod extends App{

  val spark = sparkEntry

  //val c= spark.sparkContext.textFile("/Users/shuvamoymondal/test1.txt").map(_.replaceAll("$","&")).map(_.split('|'))
  val c = returnRdd
  c.take(3).foreach(i=> println(i))

}
