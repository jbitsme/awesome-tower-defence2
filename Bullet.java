import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      move(4);
    }
    
    public void ifAtWorldEdge()
    {
        if(getX()<0)
        {
            getWorld().removeObject(this);
        }
        if(getX()>600)
        {
            getWorld().removeObject(this);
        }
        if(getY()<0)
        {
            getWorld().removeObject(this);
        }
        if(getY()>425)
        {
            getWorld().removeObject(this);
        }
         
    }
}