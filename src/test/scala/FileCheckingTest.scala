import java.io.{BufferedWriter, FileWriter}

import org.scalatest.FunSuite
class FileCheckingTest extends FunSuite{
  test("Transaction file name") {
    assert(tools.tools.checkTransactionFileName("transactions_20170609.data") === true)
    assert(tools.tools.checkTransactionFileName("transactions_20191314.data") === false)
    assert(tools.tools.checkTransactionFileName("transactions_20190643.data") === false)
    assert(tools.tools.checkTransactionFileName("transactions_20191314fakename.data") === false)
  }

  test("References files names") {
    assert(tools.tools.checkReferencesFilesNames("reference_prod-10f2f3e6-f728-41f3-b079-43b0aa758292.data") === true)
    assert(tools.tools.checkReferencesFilesNames("reference-prod-10f2f3e6-f728-41f3-b079-43b0aa758292.data") === false)
    assert(tools.tools.checkReferencesFilesNames("reference_prod_10f2f3e6-f728-41f3-b079-43b0aa758292.data") === false)
    assert(tools.tools.checkReferencesFilesNames("reference_prod-10f2f3e6-g728-41f3-b079-43b0aa758292.data") === false)
    assert(tools.tools.checkReferencesFilesNames("reference_prod-10f2f3e6-f728_41f3-b079-43b0aa758292.data") === false)
    assert(tools.tools.checkReferencesFilesNames("reference_prod-10f2f3e6-g728-41f3-43b0aa758292.data") === false)
    assert(tools.tools.checkReferencesFilesNames("reference_prod-10f2f3e6-g728-41f3-b079-43b0aa7582920.data") === false)
  }
}
