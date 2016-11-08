import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WayPoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WayPoint extends Actor
{
     public static WayPoint start;
    private WayPoint next;
    
    public WayPoint()
    {
        setImage(new GreenfootImage(1, 1));
        
        // Connect Waypoints with each other...
        if(start != null)
        {
            start.next = this;
        }
        
        start = this;
    }
    
    /**
     * Returns the Handle of the next Waypoint.
     */
    public WayPoint getNextWayPoint()
    {
        return next;
    }   
}
