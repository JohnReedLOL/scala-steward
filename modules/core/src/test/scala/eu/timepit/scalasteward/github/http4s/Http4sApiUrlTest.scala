package eu.timepit.scalasteward.github.http4s

import cats.implicits._
import eu.timepit.scalasteward.github.data.Repo
import eu.timepit.scalasteward.model.Branch
import org.scalatest.{FunSuite, Matchers}

class Http4sApiUrlTest extends FunSuite with Matchers {
  type Result[A] = Either[Throwable, A]
  val repo = Repo("fthomas", "refined")
  val branch = Branch("master")

  test("branches") {
    Http4sApiUrl.branches[Result](repo, branch).map(_.toString) shouldBe
      Right("https://api.github.com/repos/fthomas/refined/branches/master")
  }

  test("forks") {
    Http4sApiUrl.forks[Result](repo).map(_.toString) shouldBe
      Right("https://api.github.com/repos/fthomas/refined/forks")
  }

  test("pulls") {
    Http4sApiUrl.pulls[Result](repo).map(_.toString) shouldBe
      Right("https://api.github.com/repos/fthomas/refined/pulls")
  }
}
