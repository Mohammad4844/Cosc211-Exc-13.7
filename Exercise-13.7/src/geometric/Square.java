package geometric;

public class Square extends GeometricObject implements Colorable {
  
  private double side;

  public Square() {
    this.side = 0;
  }

  public Square(double side) {
    this.side = side;
  }

  public double getSide() {
    return side;
  }

  public void setSide(double side) {
    this.side = side;
  }

  /**
   * Gives the area of the square
   */
  @Override
  public double getArea() {
    return side * side;
  }

  /**
   * Gives the perimeter of the square
   */
  @Override
  public double getPerimeter() {
    return 4 * side;
  }

  @Override
  public void howToColor() {
    System.out.println("Color all four sides");
  }

}
