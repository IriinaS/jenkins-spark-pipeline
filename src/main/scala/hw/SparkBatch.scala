package hw

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col

object SparkBatch {

  def getUniqueHotels(hotelAndWeather: DataFrame): Long = {
    val uniqueHotelsDF = hotelAndWeather
      .select(col("id"),
        col("name"),
        col("address"),
        col("city"),
        col("country"))
      .distinct()

    uniqueHotelsDF.count()
  }
}
