import java.io.{BufferedWriter, FileWriter}

import org.scalatest.FunSuite
class ResultsTests extends  FunSuite {
  test ("Products quantity"){
    var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\transactions_20190411.data")
    tools.request.topOneHundredGlobalSalesOneDay(tools.map.createGlobalMap(bufferedSource))
    bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\result\\top_100_ventes_GLOBAL_20170514.data")
    var line =  bufferedSource.getLines
    for (i <- 0 to 2)
      line.next()
    val col = tools.tools.split(line.next(), '|')
    assert(col(1).toInt === 140)
  }
}
