package hw

import org.scalatest.FunSpec
import org.scalatest.Assertions

class SparkBatchTest extends FunSpec with Assertions with SparkSessionWrapper {

  import spark.implicits._

  it("Test return unique hotels number") {
    val hotelAndWeather = Seq(
      HotelAndWeather(123, "Hotel1", "US", "Gresham", "Address1", "49.802514", "9.921491", 64.4, 18, "12-01-2020", "u0z5"),
      HotelAndWeather(146, "Hotel2", "US", "Oswego", "Address2", "43.45161", "-76.53235", 69.8, 21, "13-01-2020", "dr9x"),
      HotelAndWeather(195, "Hotel3", "US", "Gretna", "Address3", "41.097218", "-96.253174", 68, 20, "14-01-2020", "9z79"),
      HotelAndWeather(146, "Hotel2", "US", "Oswego", "Address2", "43.45161", "-76.53235", 69.8, 21, "15-01-2020", "dr9x")
    )
    val hotelAndWeatherDF = spark.sparkContext.parallelize(hotelAndWeather).toDF()

    assert(SparkBatch.getUniqueHotels(hotelAndWeatherDF) == 3)
  }
}
