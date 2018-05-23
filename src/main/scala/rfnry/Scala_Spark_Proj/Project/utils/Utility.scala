package Project.utils

import Project.sparkRDDMethod.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd
import org.apache.spark.rdd.RDD
import schema._


object Utility {


  def sparkEntry: SparkSession = {

    val spark: SparkSession =
      SparkSession
        .builder()
        .appName("AppName")
        .config("spark.master", "local")
        .getOrCreate()

    spark
  }

  def sparkContext: SparkContext = {
   val conf = new SparkConf()
    val sc = new SparkContext(conf)
    sc
  }

  def returnRdd  : RDD[Person]= {
    val c= spark.sparkContext.textFile("/Users/shuvamoymondal/test1.txt").map(_.replace("$","")).map(_.split('|'))
      .map(p=> Person(p(0),p(1)))
    return c
  }
}
