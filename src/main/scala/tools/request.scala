package tools

import java.io.{BufferedWriter, FileWriter}

import scala.collection.immutable.ListMap

object request {
  def topOneHundredSalesPerShopForOneday(data: scala.collection.mutable.Map[String, Int]): ListMap[String, Int] = {
    ListMap(data.toSeq.sortWith(_._2 > _._2):_*).take(100)
  }

  def topOneHundredGlobalSalesOneDay(data: scala.collection.mutable.Map[String, Int]): Unit = {
    try {
      val result = ListMap(data.toSeq.sortWith(_._2 > _._2):_*).take(100)
      val date = tools.split(result.head._1, '_')(0)
      val bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\amouedden\\Desktop\\Tests\\result\\top_100_ventes_GLOBAL_" + date + ".data"))
      bufferedWriter.write("---------------------\r\n")
      bufferedWriter.write("Produit\t| Qte vendue \r\n")
      bufferedWriter.write("---------------------\r\n")
      for((k, v) <- result) {
        bufferedWriter.write(tools.split(k.toString, '_')(1) + "\t|" + v.toString + "\r\n")
      }
      bufferedWriter.close()
    }
    catch {
      case _ => println("Erreur pour la création du fichier")
    }
  }
}
