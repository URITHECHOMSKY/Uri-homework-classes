
/**
 * Write a description of class Point3D here.
 *
 * @author (Uri Chomsky)
 * @version (28/04/24)
 */
public class    Point3D
{
    // instance variables - replace the example below with your own

    private double x1;
    private double y1;
    private double z1;

    public Point3D()
    {
        // initialise instance variables
        x1 = 0;
        y1 = 0;    
        z1 = 0;
    }
    /**
     * Constructs the origin point in the xyz cordinates
     * @param x is the x cordinate and so fourth for y and z

     */
    public Point3D(double x,double y,double z)
    {
        this.x1= x;
        this.y1 = y;    
        this.z1 = z;
    
    }
    /**
     * Constructs a second 3d point
     * @param second is the second point
     */
    public Point3D(Point3D second)
    {
	x1 = second.getX();
	y1 = second.getY();
	z1 = second.getZ();
    }
    /**
     * return the cordinates in (x,y,z) 
     * @return a string of (x,y,z).
     */	
    public String toString() {
	return "(" + x1 + "," + y1 + "," + z1 + ")";
    }

    /**
     * @return the cordinate for the given varibel
     */
    public double getX()
    {
        return x1;
    }
    public double getY()
    {
        return y1;
    }
    public double getZ()
    {
        return z1;
    }
    
    /**
     * sets the xyz coordinate for the points
     * @param num is the value that given to the varibel 
     */
    
    public void setX(double num)
    {
        x1=num;
    }
    public void setY(double num)
    {
        y1=num;
    }
    public void setZ(double num)
    {
        z1=num;
    }
    /**
     * check the position of the x cordinante of the first point reletive to the
     * second point
     * @param second represent the second point
     * @return true if the point is behind the second point and else
     * if its in front of
     */
    public boolean isBehind(Point3D second)
    {
	return (x1 < second.getX());
    }
    /**
     * check the position of the x cordinante of the first point reletive to the
     * second point
     * @param second represent the second point
     * @return true if the point is in front of the second point and else 
     * if its behind
     */
    public boolean isInFrontOf(Point3D second) {
	return second.isBehind(this);
    }
    /**
     * check the position of the y cordinante of the first point reletive to the
     * second point
     * @param second represent the second point
     * @return true if the point is to the left the second point and else
     * if its in to the right
     */
    public boolean isLeft(Point3D second)
    {
	return (y1 < second.getX());
    }
    /**
     * check the position of the y cordinante of the first point reletive to the
     * second point
     * @param second represent the second point
     * @return true if the point is in front of the right point and else 
     * if its to the left
     */
    public boolean isRight(Point3D second) {
	return second.isLeft(this);
    }
 
    /**
     * check the position of the z cordinante of the first point reletive to the
     * second point
     * @param second represent the second point
     * @return true if the point is above the second point and else
     * if its under
     */
    public boolean isAbove(Point3D second)
    {
	return (z1 < second.getX());
    }
    /**
     * check the position of the z cordinante of the first point reletive to the
     * second point
     * @param second represent the second point
     * @return true if the point is under the second point and else 
     * if its to the above
     */
    public boolean isUnder(Point3D second) {
	return second.isLeft(this);
    }
 
        
    
    /**
     * Determines whether or not two points are equal.
     * @param second a Point3D object compared with this Point3D
     * @return true if the two points are equals,and return false otherwise
     */
    public boolean equal(Point3D second) 
    {
       if((x1==second.getX()) && (y1==second.getY())&&(z1==second.getZ()))
       {
           return true;
       }
       else
       {
           return false;
       }
        
    }
    /**
     * move a point in a corinate by a d(x,y,z)
     * represents Point3D in (x+dx,y+dy,z+dz)
     * @param dx move the x cordinate
     * @param dy move the y cordinate
     * @param dz move the z cordinate
     */
    public void move(double dx, double dy, double dz)
    {
	x1 += dx;
	y1 += dy;
	z1 += dz;
    }
    public double distance(Point3D p) {
	return Math.sqrt(Math.pow(x1 - p.getX(), 2) + Math.pow(y1 - p.getY(), 2) + Math.pow(z1 - p.getZ(), 2));
    }

}
