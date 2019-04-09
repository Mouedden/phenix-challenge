import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap

object Trying {
  def main(args: Array[String]): Unit = {
    val colors = List("red", "green", "yellow")
    val numbers = List(8)
    colors.foreach((c: String) => println(c))
    val sizes = colors.map((c: String) => c.size)
    println(sizes)
    var total = 0
    if (numbers.size > 0) {
      total = numbers.reduce((a: Int, b: Int) => a * b)
      println(total)
    }
    else
      println("Cannot")
    var lists = new ListBuffer[Int]()
    lists += 4
    lists += 2
    lists += 9
    if (!lists.isEmpty)
      println(lists.tail == Nil)
    lists.foreach((i: Int) => println(i))
    val lis = lists.toList
    val t = lis.reduce((a: Int, b: Int) => (a + b))
    println(t)
    /*try
      var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\transactions_201904042.data")
    catch {
      case _: Throwable => println("File not found")
    }
    finally
      println("Path")*/
    var nbrLine = 0
    var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\transactions_20170514.data")
    //var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\vide.data")
    //var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\transactions_201904042.data")
    //var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\data10.data")
    println("---------------------------------------")
    var columns: Array[String] = new Array[String](5)
    var data = Map[String, Int]()
    var value: Int = 0
    for (line <- bufferedSource.getLines()) {
     columns = tools.tools.split(line)
      if (columns.length == 5) {
        //println(columns(2) + "_" + columns(1).substring(0, 8) + ".data")
        nbrLine += 1
        try {
          if (data.keySet.exists(_ == columns(2) + "_" + columns(1).substring(0, 8) + "_" + columns(3))) {
            value = data.getOrElse(columns(2) + "_" + columns(1).substring(0, 8) + "_" + columns(3), 0) + columns(4).toInt
            data += (columns(2) + "_" + columns(1).substring(0, 8) + "_" + columns(3) -> value)
          }
          else
            data += (columns(2) + "_" + columns(1).substring(0, 8) + "_" + columns(3) -> columns(4).toInt)
        }
        catch {
          case _: Throwable => println("Erreur d'entrée")
        }
        }
      else
        None
    }
    // Display a map
    //data.toList.sortBy(_._1)
    //val finalData = data.toSeq.sortBy(_._2)
    println(data)
    //val finalData = ListMap(data.toSeq.sortWith(_._2 > _._2):_*).take(100)
    val finalData = tools.request.topOneHundredGlobalSalesOneDay(data)
    for((k,v) <- finalData) println(s"$k, $v")
    println(s"La taille de la map est ${data.size}")
    println(nbrLine)
    bufferedSource.close()
  }
}
