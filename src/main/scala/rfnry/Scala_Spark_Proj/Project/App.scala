package Project

import org.apache.log4j._
import Project.utils.AllFunctions._
import Project.utils.AllFunctions
import Project.utils.AllFunctions.DonutConverstions._
import Project.utils.HigherOrderFunctions.{LOG, _}




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

      println("Example of Currying function",currying_function(20)(discount)(storename))

      ////  Higher Order Function calll starts here

      println("\nStep 3: How to call higher order function and pass an anonymous function as parameter")
      val totalCostOf5Donuts = totalCostWithDiscountFunctionParameter("Glazed Donut")(5){totalcost =>
        val discount = 2 // assume you fetch discount from database
        println(totalcost)
        totalcost - discount

      }
      println(totalCostOf5Donuts)

      /// Now call another same defined function for higher order function
      val chk = totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(test)
      print("chk",chk)

      //How to define a List with Tuple3 elements
      LOG.info("Step 1: How to define a List with Tuple3 elements: Call by name with parameter")
      val list = List(("Donut", 5,5.0),("Cake", 5,5.0),("Pasta",5,5.0))
      println("The place order value: " ,placeOrder(list)(2))

     // How to call a function without providing its callback parameter
      println(finalReport())
      println(finalReport(Some(
        ()=>
      println("Printing finished")
      )
      )
      )


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