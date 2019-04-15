package example

// Abstract class similar to Java. Unlike traits, abstract classes support
// parameterized constructors.
abstract class Duck(name: String) extends Drawable {
  // The only member in the class is the below abstract method. This must be
  // implemented in all subclasses of Duck. Abstract class members can only
  // be public.
  def swim(): Unit
}

// Classes can have only one superclass but can use multiple traits. Flyable and Quackable
// are traits that have the abstract methods fly() and quack() respectively. These must be
// implemented in any class extending that trait.
class MallardDuck(name: String) extends Duck(name: String) with Flyable with Quackable with Drawable {
  override def swim(): Unit = println("MallardDuck is swimming...")

  override def fly(): Unit = println("MallardDuck is flying...")

  override def quack(): Unit = println("MallardDuck is quacking...")

  // The create() method in the Image singleton object is used to generate a random image.
  // Named parameters are showcased in the function call
  override def draw(): Image = {
    println("Drawing MallardDuck image...")
    Image.create(height=20, width=20)
  }

  // Since all user-defined classes are subclasses of AnyRef, we can override
  // the toString() method that is defined there.
  override def toString: String = "I am a MallardDuck"
}

class RubberDuck(name: String) extends Duck(name: String) with Quackable {
  override def swim(): Unit = println("RubberDuck is floating...")

  override def quack(): Unit = println("RubberDuck is squeaking...")

  override def draw(): Image = {
    println("Drawing RubberDuck image...")
    Image.create(height=20, width=20)
  }

  override def toString: String = "I am a RubberDuck"
}


