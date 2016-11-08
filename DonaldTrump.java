import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DonaldTrump here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DonaldTrump extends Actor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    
    private int direction;
    
    public DonaldTrump()
    {
        setDirection(EAST);
    }
    
    /**
     * Act - do whatever the DonaldTrump wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void setDirection(int direction)
    {
        if((direction >= 0) && (direction <= 3)) {
            this.direction = direction;
        }
        switch(direction) {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
            setRotation(270);
        }
  
    }
}
