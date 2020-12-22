package hw

case class HotelAndWeather(id: BigInt,
                           name: String,
                           country: String,
                           city: String,
                           address: String,
                           latitude: String,
                           longitude: String,
                           avg_tmpr_f: Double,
                           avg_tmpr_c: Double,
                           wthr_date: String,
                           geo_hash: String)
