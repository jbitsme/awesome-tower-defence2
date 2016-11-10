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
      move(10);
      ifAtWorldEdge();
    }
    
    public void ifAtWorldEdge()
    {
        if( atWorldEdge() )
        {
            getWorld().removeObject(this);
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
    
    public boolean canSee(Class clss)
    {
        return getOneObjectAtOffset(0, 0, clss) != null;
    }
    
    public void eat(Class clss)
    {
       Actor actor = getOneObjectAtOffset(0, 0, clss);
       if(actor != null)
       {
           getWorld().removeObject(actor);
       }
    }
}
