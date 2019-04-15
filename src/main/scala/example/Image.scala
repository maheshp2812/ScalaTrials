package example

// Creation of a case class in Scala. This Pixel class only
// has 3 members - r, g and b.
case class Pixel(r: Int, g: Int, b: Int)

class Image(height: Int, width: Int) {
  // Here we create a 2d array of Pixels with dimension height x width
  val img = Array.ofDim[Pixel](this.height, this.width)

  // This is a function. Unlike methods, functions have values. In this case its
  // value is of Unit type since the expression doesn't have a value. Functions are
  // of the format (<function parameters>) => <work with the parameters>
  val setPixelAtPosition = (x: Int, y: Int, pixel: Pixel) => img(x)(y) = pixel
}

// Companion object of the Image class that contains a factory method create()
object Image {
  // This method creates an image of given dimensions with random rgb values
  // for each pixel.
  def create(height: Int, width: Int): Image = {
    println("Creating new random image...")
    val image: Image = new Image(height, width)
    val rand = new scala.util.Random
    for(i <- 0 to height-1)
      for(j <- 0 to width-1) {
        val pixel = new Pixel(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))
        image.setPixelAtPosition(i, j, pixel)
      }
    image
  }
}
