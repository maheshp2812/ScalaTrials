package example

// This is a definition of a trait. Traits are similar to interfaces in Java 8.
// Since objects of traits cannot be instantiated, they do not support
// parameterized constructors.
trait Flyable {
  def fly(): Unit
}
