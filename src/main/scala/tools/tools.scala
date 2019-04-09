package tools

object tools {
  def split(line: String): Array[String] = {
    "\\|".r.split(line)
  }
}
