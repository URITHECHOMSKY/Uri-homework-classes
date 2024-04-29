
/**
 * Write a description of class Box3D here.
 *
 * @author (Uri Chomsky)
 * @version (28/04/24)
 */
public class Box3D
{
    // instance variables - replace the example below with your own
    private Point3D base1;
    private int length1;
    private int width1;
    private int height1;

    /**
     * Constructs a box with 1x1x1 size
     */
    public Box3D()
    {
        base1 = new Point3D();
        length1 = 1;
        width1 = 1;
        height1 =1; 
        
    }

    /**
     * construct a box with a base point and three demensions
     * @param point is the base point
     * @param length is the length of the sides of the box
     * @param width is the width of the sides
     * @param height is the height of the sides 
     * 
     */
    public Box3D(Point3D point, int length, int width, int height)
    {
	this.base1 = new Point3D(point); 
	this.length1= (length > 0) ? length : 1;
	this.width1 = (width > 0) ? width : 1;
	this.height1 = (height > 0) ? height : 1;
    }
    /**
     * take the given dimensions of the box and construct it
     */
    public Box3D(Box3D box)
    {
	base1 = new Point3D(box.getBase());
	length1 = box.getLength();
	width1 = box.getWidth();
	height1 = box.getHeight();
    } 
    
    /**
     * return the size of the demensions of the cube 
     * @return the size as an int 
     */
    public Point3D getBase()
    {
	return new Point3D(base1);
    }    
    public int getLength()
    {
	return length1;
    }
    public int getWidth()
    {
	return width1;
    }
    public int getHeight()
    {
	return height1;
    }
    /**
     * set the size of the demension 
     */
    public void setHeight(int num)
    {
        if(num > 0) 
        {
            height1 = num;
	}
    }
    public void setLength(int num)
    {
        if(num > 0) 
        {
            length1 = num;
	}
    }
    public void setWidth(int num)
    {
        if(num > 0) 
        {
            width1 = num;
	}
    }
    public void setBase(Point3D point)
    {
        base1 = new Point3D(point);
    }
    /**
     * return the sizes of the demnsion of the box in string 
     */
    public String toString()
    {
	return ("The base point is " + base1.toString() + ", length = " + length1 + ", width = " + 
		width1 + ", height = " + height1);
    }
    /**
     * check if the two boxes are equal or not
     * @param second is the second box we comare with the first box
     * @return true if the two boxes are equals, false otherwise
     */
    public boolean equals(Box3D second)
    {
	return ((this.base1.equals(second.base1)) && (this.length1 == second.getLength())
		&& (this.width1 == second.getWidth()) && (this.height1 == second.getHeight()));
    }
    /**
     * Moves the box in the (x,y,z) coordinate system 
     * by (x+dx,y+dy,z+dz) this change dosnt affect 
     * the demensions of the cube
     * @param dx add dx to the x cordinate
     * @param dy add dy to the y cordinate
     * @param dz add dz to the z cordinate
     * 
     *      * @return the new location of the box
     */
    Box3D move(double dx, double dy, double dz)
    {
	Point3D tempPoint = new Point3D(this.base1);
	tempPoint.move(dx,dy,dz);
	return new Box3D(tempPoint, length1, width1, height1);
    }
    /**
     * using the formula of caculating the upper right back point of the box 
     * @return the upper right back point of this box
     */
    public Point3D getUpRightBackPoint()
    {
	return new Point3D(base1.getX() - length1, base1.getY() + width1, base1.getZ() + height1);
    }
    /**
     * return the center point if the box by using the formula
     * @return the center point of the box
     */
    public Point3D getCenter()
    {
	return new Point3D(base1.getX() - (length1 / 2), base1.getY() +
		(width1 / 2), base1.getZ() + (height1 / 2));
    }
    /**
     * caculating the distance between the two center point of the boxes
     * @param second is the second box
     * @return the distance between the center points 
     */
    public double distance(Box3D second) 
    {
	return this.getCenter().distance(second.getCenter());
    }
    /**
     * @return volume of the Box
     */
    public int getVolume()
    {
	return (length1 * width1 *  height1);
    }
    /**
     * @return the surface area of teh box
     */
    public int getSurfaceArea()
    {
        return ((width1 * length1) + (length1 * height1) + (width1 * height1)) * 2;
    }
    /**
     * Determines which box has a greater volume 
     * @param second is the second box that the function comapre to the other box
     * @return true if the first box Volume is greater then the second box volume and return false otherwise.
     */
    public boolean isLargerCapacity(Box3D second)
    {
	return this.getVolume() > second.getVolume();
    }
    /**
     * Determines whether this box can contain the second box.
     * @param second a second box that the function is checking if it can be contained by the first one
     * @return true if the box can contain the second one and false if it cant. 
     */
    public boolean contains(Box3D second)
    {
	return (width1 > second.getWidth()) && (length1 > second.getLength()) && (height1 > second.getHeight());
    }
	
    /**
     * Checks if the box is above the second box
     * @param second is the box that the function check if it under the first box
     * @return true return true if the box is above the second box and false if it dosnt.
     */
    public boolean isAbove(Box3D second) 
    {
	return this.base1.isAbove(second.move(0, 0, second.getHeight()).getBase());
    }
    
}
