package Project.utils

/**
  * Created by shuvamoymondal on 12/24/17.
  */
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.log4j._



/**
  * Hello world!
  *
  */
object AllFunctions {

  val LOG: Logger = Logger.getLogger("App")
  LOG.setLevel(Level.INFO)
  Logger.getLogger("org").setLevel(Level.ERROR)
  val logBuilder = new StringBuilder()

  // 1)  How to add default values to function parameters:

  LOG.info("How to add default values to function parameters")
  logBuilder.append("How to add default values to function parameters")

  def coupon_rebate(name: String, quantity: Integer,default_coupon: String ="No_Code") : Double = {

    if (default_coupon == "No_Code") {
      LOG.info("No coupon received")
      quantity * 50
    }

    else {
      quantity * 25
    }

  }
  //2) Option in a function parameter

  LOG.info("How to add Option Parameter within function")
  logBuilder.append("How to add Option Parameter within function")

  def testOption(name: String, quantity: Integer,default_coupon: Option[String]): Double = {

    default_coupon match {
      case Some(coupon) =>
        quantity * 40

      case None => quantity * 70
    }

  }

  def Option_return_type(coupon: String) : Option[String] = {
    LOG.info("Return Option Parameter within function")
    Option(coupon).filter(_.nonEmpty)
  }

  //If yoo declare variable as implicit in the main function, then you do not have to pass
  //it this variable value to your implicit function while calling.

 LOG.info(s"How to define a function with an implicit parameter")
  def implicitExample (donutType: String, quantity: Int)(implicit discount: Double): Double = {
    println(s"Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }

  LOG.info("How to define a function which takes multiple implicit parameters")
  def MultipleImplicitExample(donutType: String, quantity: Int)(implicit discount: Double, storeName: String): Double = {
    println(s"[$storeName] Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }

  //Implicit class implementation.
  class DonutString(s: String) {
    def isFavoriteDonut: Boolean =
      s == "Glazed Donut"
    def conversion : String = s.map(c=> (c +1).toChar )
  }

  //Call this implicit class inside an object
  object DonutConverstions {
    implicit def stringToDonutString(s: String) = new DonutString(s)
  }


}