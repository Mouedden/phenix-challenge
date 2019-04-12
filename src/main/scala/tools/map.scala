package tools

import scala.io.BufferedSource

object map {
  def createGlobalMap(bufferedSource: BufferedSource): scala.collection.mutable.Map[String, Int] = {
    var mapData = scala.collection.mutable.Map[String, Int]()
    var columns: Array[String] = new Array[String](5)
    var value: Int = 0
    var stopLoopFlag = true
    while(stopLoopFlag == bufferedSource.getLines().hasNext) {
      try {
        for (line <- bufferedSource.getLines()) {
          columns = tools.split(line, '|')
          if (columns.length == 5) {
            try {
              if (mapData.contains(columns(1).substring(0, 8) + "_" + columns(3))) {
                value = mapData.getOrElse(columns(1).substring(0, 8) + "_" + columns(3), 0) + columns(4).toInt
                mapData += (columns(1).substring(0, 8) + "_" + columns(3) -> value)
              }
              else
                mapData += (columns(1).substring(0, 8) + "_" + columns(3) -> columns(4).toInt)
            }
            catch {
              case ex: NumberFormatException => {
                System.err.println("Erreur d'entréeee")
              }
            }
          }
          else
            None
        }
      }
      catch {
        case ex: java.lang.OutOfMemoryError => {
          mapData.clear()
          stopLoopFlag = bufferedSource.getLines().hasNext
        }
      }
    }
    mapData
  }
}
