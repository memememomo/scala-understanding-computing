
trait Expression {
  def toString:  String
  def Inspect: String = s"<<$this>>"
}

class Number(value: Int) extends Expression {
  override def toString: String = value.toString
}
object Number {
  def apply(value: Int) = new Number(value)
}

class Add(left: Expression, right: Expression) extends Expression {
  override def toString: String = s"$left + $right"
}
object Add {
  def apply(left: Expression, right: Expression) = new Add(left, right)
}

class Multiply(left: Expression, right: Expression) extends Expression {
  override def toString: String = s"$left * $right"
}
object Multiply {
  def apply(left: Expression, right: Expression) = new Multiply(left, right)
}

object Main
{
  def main(args: Array[String]): Unit = {
    val e = Add(
      Multiply(Number(1), Number(2)),
      Multiply(Number(3), Number(4))
    )
    println(e)
  }
}
