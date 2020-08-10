public class NBody {
  /** read the radius of the universe in the specified file
   * STATIC methos!!!
  */
  public static double readRadius(String filename) {
    In in = new In(filename);
    int number = in.readInt();
    double radius = in.readDouble();
    return radius;
  }

  /** read the Planet's data from the specified file and return an array */
  public static Planet[] readPlanets(String filename) {
    In in = new In(filename);
    int number = in.readInt();
    double radius = in.readDouble();
    Planet[] planets = new Planet[number];
    for (int i = 0; i < number; i++) {
      double xP = in.readDouble();
      double yP = in.readDouble();
      double xV = in.readDouble();
      double yV = in.readDouble();
      double m = in.readDouble();
      String img = in.readString();
      planets[i] = new Planet(xP, yP, xV, yV, m, img);
    }
    return planets;
  }

  /** main method */
  public static void main(String args[]) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double radius = NBody.readRadius(filename);
    Planet[] planets = NBody.readPlanets(filename);
    String imagePath = "./images/starfield.jpg";

    /** draw the background image */
    StdDraw.setScale(-radius, radius);
    StdDraw.clear();
    StdDraw.picture(0, 0, imagePath);

    /** draw all the Planets */
    int number = planets.length;
    for (int i = 0; i < number; i++) {
      planets[i].draw();
    }
  }
}
