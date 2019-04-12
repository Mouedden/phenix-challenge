object app {
  def main(args: Array[String]): Unit = {
    //var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\transactions_20170514.data")
    val bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\transactions_20190411.data")
    //var bufferedSource = io.Source.fromFile("C:\\Users\\amouedden\\Desktop\\Tests\\data10.data")
    tools.request.topOneHundredGlobalSalesOneDay(tools.map.createGlobalMap(bufferedSource))
    bufferedSource.close()
  }
}
