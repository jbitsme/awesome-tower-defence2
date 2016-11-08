import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    private int powerUp;
    private int speed;
    
    /*
     * Create a Hero
     */
    public Hero()
    {
        powerUp = 0;
    }
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeypress();
        lookForPowerUp();
    }    

    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            setRotation(180);
            move(speed);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(0);
            move(speed);
        }
        if (Greenfoot.isKeyDown("up")) 
        {
            setRotation(270);
            move(speed);
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            setRotation(90);
            move(speed);
        }
    }

    /**
     * Check if we have found a PowerUp.
     * If we have, take it, if not do nothing.
     */
    public void lookForPowerUp()
    {
        if (isTouching(PowerUp.class))
        {
            removeTouching(PowerUp.class);
            
            powerUp = powerUp + 1;
        }
    } 
    
    /**
     * Sets the speed of the Hero
     */
    public int setSpeed()
    {
        speed = 5;
    }
   
}
