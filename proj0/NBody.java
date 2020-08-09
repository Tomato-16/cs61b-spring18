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
}
