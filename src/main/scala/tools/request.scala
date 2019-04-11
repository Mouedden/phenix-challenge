package tools

import scala.collection.immutable.ListMap

object request {
  def topOneHundredSalesPerShopForOneday(data: scala.collection.mutable.Map[String, Int]): ListMap[String, Int] = {
    ListMap(data.toSeq.sortWith(_._2 > _._2):_*).take(100)
  }

  def topOneHundredGlobalSalesOneDay(data: scala.collection.mutable.Map[String, Int]): ListMap[String, Int] = {
    ListMap(data.toSeq.sortWith(_._2 > _._2):_*).take(100)
  }
}
