package example


// The below object is a singleton object. Static methods in Java are written as normal methods
// in singleton objects. The main() method (which is static in Java) is the entry point
// to the program.
object Main {
  // This method is to showcase pattern matching for case classes. Email, SMS and VoiceRecording
  // are subtypes of Notification. The match keyword (powerful version of switch in Java) is used to
  // map the object type to the appropriate notification message. The result of the match expression
  // is a value of the lowest common supertype of the return types of each case.
  def showNotification(notification: Notification): String = {
    notification match {
        // The body of the email is irrelevant to the code, so it is replaced by a wildcard.
        // Thus, the third argument of the pattern is matched, but not stored to a variable.
      case Email(sender, title, _) =>
        s"This is an email from $sender with title $title"
      case SMS(number, message) =>
        s"This is an SMS from $number with message $message"
      case VoiceRecording(name, link) =>
        s"This is a voice recording from $name with link $link"
    }
  }

  // Similar to Java's main method, it accepts an array of strings as arguments and returns nothing,
  // hence the return type is Unit (similar to void in Java). main is assigned a block.
  def main(args: Array[String]): Unit = {
    // Objects are instantiated with the new keyword, similar to Java.
    // Below we can see that the object is assigned to a value, not a variable
    // Thus, duck1 cannot be reassigned to another object. Also the type of duck1
    // is not explicitly mentioned as Scala supports type inference.
    val duck1 = new MallardDuck("Joe")
    // Here the type of duck2 is explicitly mentioned
    val duck2: Duck = new RubberDuck("Mark")

    val notifications = List[Notification](
      new Email("sender1", "title1", "This is the body"),
      new SMS("caller1", "message1"),
      new VoiceRecording("contactName1", "link1")
    )

    for(notification <- notifications)
      println("Notification: " + showNotification(notification))
  }
}
