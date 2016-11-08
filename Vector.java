/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector  
{
     // instance variables - replace the example below with your own
    public double x;
    public double y;

    public Vektor(double pX, double pY)
    {
        x = pX;
        y = pY;
    }
    
    public double getLength()
    {
        return Math.hypot(x, y);
    }
    
    public double skalarprodukt(Vektor v1, Vektor v2)
    {
        return ((v1.x*v2.x) + (v1.y*v2.y));
    }
    
    public double getAngle(Vektor v1, Vektor v2)
    {
        double bogenmaß = Math.acos(skalarprodukt(v1, v2)/(v1.getLength()*v2.getLength()));
        
        return (360/(2*Math.PI))*bogenmaß;
    }
}
