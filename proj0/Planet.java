public class Planet {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;

  /** Contructor method of class Planet */
  public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
      xxPos = xP; yyPos = yP;
      xxVel = xV; yyVel = yV;
      mass = m;   imgFileName = img;
  }
  public Planet(Planet p) {
      xxPos = p.xxPos; yyPos = p.yyPos;
      xxVel = p.xxVel; yyVel = p.yyVel;
      mass = p.mass;   imgFileName = p.imgFileName;
  }

  /** calculate the distance between this Planet and the other Planet */
  public double calcDistance(Planet other) {
      return Math.sqrt((other.xxPos - this.xxPos)*(other.xxPos - this.xxPos) +
                       (other.yyPos - this.yyPos)*(other.yyPos - this.yyPos));
  }

  /** calculate the force exerted by the other Planet */
  public double calcForceExertedBy(Planet other) {
    return 6.67E-11 * this.mass * other.mass / (calcDistance(other) * calcDistance(other));
  }

  /** calculate the force exerted by other Planet on X and Y direction */
  public double calcForceExertedByX(Planet other) {
    return calcForceExertedBy(other) * (other.xxPos - this.xxPos) / calcDistance(other);
  }
  public double calcForceExertedByY(Planet other) {
    return calcForceExertedBy(other) * (other.yyPos - this.yyPos) / calcDistance(other);
  }

  /** calculate the net force exerted by a group of Planets on X and Y direction */
  public double calcNetForceExertedByX(Planet[] others) {
    int index = 0;
    double distance = 0.0;
    for (; index < others.length; index++) {
      if (!this.equals(others[index])) {
          distance += calcForceExertedByX(others[index]);
      }
    }
    return distance;
  }
  public double calcNetForceExertedByY(Planet[] others) {
    int index = 0;
    double distance = 0.0;
    for (; index < others.length; index++) {
      if (!this.equals(others[index])) {
          distance += calcForceExertedByY(others[index]);
      }
    }
    return distance;
  }

  /** calculate the updated value of Planet */
  public void update(double dt, double fX, double fY) {
    double accelerationX = fX / this.mass;
    double accelerationY = fY / this.mass;
    xxVel += dt * accelerationX;
    yyVel += dt * accelerationY;
    xxPos += dt * xxVel;
    yyPos += dt * yyVel;
  }
}
