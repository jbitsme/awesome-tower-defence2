import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeypress();
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
            move(5);
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(0);
            move(5);
        }
        if (Greenfoot.isKeyDown("up")) 
        {
            setRotation(270);
            move(5);
        }
        if (Greenfoot.isKeyDown("down")) 
        {
           setRotation(90);
           move(5);
        }
    }
}
