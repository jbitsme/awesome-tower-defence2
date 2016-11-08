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
     * do what Donald Trump does best! finding pray
     */
    public void act() 
    {
        findPray();
    }
    
    /**
     * make Donald Trump move around.
     */
    public void findPray()
    {
        if(canMove()) {
            return;
        }
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() -1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }
    
    /**
     * test if Donald Trump can move, to find pray
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // test for outside border
        if(x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        return true;
    }
    /**
     * makes DonaldTrump turn left when he hits the end of the the road.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
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
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }

            setRotation(270);
        }

    }

