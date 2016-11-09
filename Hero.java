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
    private boolean speedUp; //If eaten a Extra Speed PowerUp then speed up
    
        
    /**
     * Create a Hero
     */
    public Hero()
    {
        powerUp = 0;  
        speedUp = false;
    }

    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeypress();
        lookForPowerUp();
        setSpeed();
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
            move(setSpeed());
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(0);
            move(setSpeed());
        }
        if (Greenfoot.isKeyDown("up")) 
        {
            setRotation(270);
            move(setSpeed());
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            setRotation(90);
            move(setSpeed());
        }
    }

    /**
     * Sets the speed of the Hero
     */
    public int setSpeed()
    {
        if (speedUp == true)
        {
            speed = 40;
        }
        else{
            speed = 1;
        }
        return speed;
        
    }
    
    /**
     * Check if we have found a PowerUp.
     * If we have, take it, if not do nothing.
     */
    public void lookForPowerUp()
    {
        if (isTouching(PowerUp.class))
        {
            if(isTouching(ExtraSpeed.class))
            {
                speedUp = true;
            } 
            removeTouching(PowerUp.class);
            powerUp++;
            
        }
    }
    
   
}
