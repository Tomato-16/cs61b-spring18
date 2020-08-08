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
}
