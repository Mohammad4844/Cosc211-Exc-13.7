package geometric;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * We need to test out a method that outputs to System.out. We can't really do that normally, so I
 * first changed the output stream to another PrintStream, which was then compared to the expected
 * output. At the end of the program, the output stream is set to System.out.
 */
public class TestColorable {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  /**
   * Sets the System Output output stream to a custom made PrintStream before running tests
   */
  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  /**
   * Sets the System Output back to the default output after running the tests
   */
  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void test() {
    GeometricObject[] arrayOfShapes = {new Circle(1 / Math.sqrt(Math.PI)), new Square(15),
        new Rectangle(4, 2), new Square(0), new Square(3)};
    for (GeometricObject shape : arrayOfShapes) {
      System.out.println(shape.getArea());
      if (shape instanceof Colorable)
        ((Square) shape).howToColor();
    }
    String actualOutput = outContent.toString();
    String expectedOutput = """
        0.9999999999999999
        225.0
        Color all four sides
        8.0
        0.0
        Color all four sides
        9.0
        Color all four sides
        """;
    assertEquals(actualOutput, expectedOutput);
  }

}

