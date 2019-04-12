object app {
  def main(args: Array[String]): Unit = {
    //"C:\\Users\\amouedden\\Desktop\\Tests\\transactions_20170514.data"
    //"C:\\Users\\amouedden\\Desktop\\Tests\\data10.data"
    val filePath = "C:\\Users\\amouedden\\Desktop\\Tests\\transactions_20190411.data"
    val bufferedSource = io.Source.fromFile(filePath)
    if (tools.tools.checkTransactionFileName(tools.tools.split(filePath, '\\')(5))) {
      tools.request.topOneHundredGlobalSalesOneDay(tools.map.createGlobalMap(bufferedSource))
      bufferedSource.close()
    }
    else
      println("Le nom du fichier n'est pas compatible")
  }
}
