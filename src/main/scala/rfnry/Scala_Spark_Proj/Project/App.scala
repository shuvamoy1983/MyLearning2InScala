package Project

import org.apache.log4j._
import Project.utils.AllFunctions
import Project.utils.AllFunctions.DonutConverstions._




/**
 * Hello world!
 *
 */

// ./spark-submit --class Project.App /Users/shuvamoymondal/Scala_Spark_Proj/target/Scala_Spark_Proj-1.0-SNAPSHOT.jar
object App {

  def main(args: Array[String]): Unit = {

    val LOG: Logger = Logger.getLogger("Application")
    LOG.setLevel(Level.INFO)
    Logger.getLogger("org").setLevel(Level.ERROR)
    val logBuilder = new StringBuilder()

    try {

      LOG.info("Process Started")
      logBuilder.append("Process Started")


      println("Without Default " + AllFunctions.coupon_rebate("Donuts", 4, "Code123"))
      println("Default value " + AllFunctions.coupon_rebate("Donuts", 4))
      println("Without Option Value" +AllFunctions.testOption("Donuts", 4,None))
      println("With Option Value" + AllFunctions.testOption("Donuts", 4,Some("Copun123")))

      //getOrElse used when you declare variable with option keyword
      val todayCoupon: Option[String] = AllFunctions.Option_return_type("C1234")
      println(s"Today's coupon code = ${todayCoupon.getOrElse("No Coupon's Today")}")

      AllFunctions.Option_return_type("") match  {
        case Some(coupon) => println(s"Coupon is found $coupon ")
        case None => println("Not found")
      }

      AllFunctions.Option_return_type("C1234").map(x => println(s"Return value is $x"))
      println(AllFunctions.Option_return_type("C1234").fold("No Coupon available") (todayCoupo => todayCoupo))

      implicit val discount: Double = 0.1
      implicit val storename: String ="Moody"
      println(s"All customer will receive a ${discount * 100}%discount")
      println(AllFunctions.implicitExample("Glazed Donut", 5))
      println("Multiple implicit " + AllFunctions.MultipleImplicitExample("Glazed Donut", 5))

      //Now call the implicit function using variable with dot operator
      LOG.info("Test for Implicit Function")
      val donut= "Muffin"
      val convert ="HAL"
      println("donut.isFavoriteDonut",donut.isFavoriteDonut)
      println(convert.conversion)

    }


    catch {

      case generalException: Exception =>  {
        logBuilder.append(generalException.fillInStackTrace())
        logBuilder.append(System.getProperty("Line Separator"))
        LOG.error(generalException.fillInStackTrace())
        throw new RuntimeException(generalException)

      }

    }



  }
}