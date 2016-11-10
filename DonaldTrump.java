import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class DonaldTrump here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DonaldTrump extends Actor
{
    private static final double WALKING_SPEED = 2.0;
    private int HerosEaten;
    
    public DonaldTrump()
    {
        HerosEaten = 0;
    }
    
    public void act()
    {
        turnAtEdge();
        randomTurn();
        move();
        atWorldEdge();
        lookForHero();
    }
    
    public void turnAtEdge()
    {
        if ( atWorldEdge() )
        {
            turn(17);
        }
    }
    
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
    
    public boolean canSee(Class clss)
    {
        return getOneObjectAtOffset(0, 0, clss) != null;
    }
    
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
            Greenfoot.setWorld(new GameOverWorld());
        }
    }
    
    public boolean atWorldEdge()
    {
        if(getX()< 1 ||getX()>getWorld().getWidth()-10)
        return true;
        if(getY()< 1 ||getY()>getWorld().getHeight()-10)
        return true;
        else
        return false;
    }
    
        /**
     * make Donald Trump move around.
     */
    public void move()
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * WALKING_SPEED);
        int y = (int) Math.round(getY() + Math.sin(angle) * WALKING_SPEED);
        
        setLocation(x, y);
    }
    
    /**
     * test if Donald Trump can move, to find pray
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        // test for outside border
        if(x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        return true;
    }
    
    public void lookForHero()
    {
        if ( canSee(Hero.class) ) 
        {
            eat(Hero.class);
            
            HerosEaten = HerosEaten + 1;
        }
    }
}

