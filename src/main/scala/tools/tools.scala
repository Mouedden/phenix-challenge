package tools

object tools {
  def split(line: String, ch: Char): Array[String] = {
    "\\".concat(ch.toString).r.split(line)
  }

  def checkTransactionFileName(fileName: String): Boolean = {
    if (fileName.startsWith("transaction_") && regularExpressionForDate(fileName.substring(12, 22)) && fileName.endsWith(".data") && fileName.length == 27)
      true
    else
      false
  }

  def checkReferencesFilesNames(fileName: String): Boolean = {
    if (fileName.startsWith("reference_prod-") && regularExpressionForUUID(fileName.substring(15, 51)) && fileName.endsWith(".data") && fileName.length == 56)
      true
    else
      false
  }

  def regularExpressionForDate(str: String): Boolean = {
    if (str.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))"))
      true
    else
      false
  }

  def regularExpressionForUUID(str: String): Boolean = {
    if (str.matches("([a-f0-9]{8}(-[a-f0-9]{4}){3}-[a-f0-9]{12})"))
      true
    else
      false
  }
}
