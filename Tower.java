import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Actor
{
    protected int damage;
    protected int range;
    protected int atkSpeed;
    
    public Tower()
    {
        damage = 10;
        range = 1;
        atkSpeed = 3;
    }
    
    
    public Tower(int d, int r, int a)
    {
        damage = d;
        range = r;
        atkSpeed = a;
    }
    
     /*
     * get methods
     */
    public int getDamage()
    {
        return damage;
    }
    
    public int getRange()
    {
        return range;
    }
    
    public int getAtkSpeed()
    {
        return atkSpeed;
    }
    
    /*
     * set methods
     */
    public void setDamage(int n)
    {
        damage = n;
    }
    
    public void setRange(int n)
    {
        range = n;
    }
    
    public void setAtkSpeed(int n)
    {
        atkSpeed = n;
    }
    
    public boolean isHeroInRange()
    {
        return !getObjectsInRange(100, Hero.class).isEmpty();
    }
    
    public void pointAtObject(Actor Hero) {
        setRotation((int)(180*Math.atan2(Hero.getY()-getY(),Hero.getX()-getX())/Math.PI));
    }
     
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isHeroInRange())
        {
            Hero hero = getWorld().getObjects(Hero.class).get(0);
            turnTowards(hero.getX(),hero.getY()); 
            fire();
        }
        atkSpeed ++;
    }  

    public void fire() 
    {
        if(atkSpeed >= 3)
        {   Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            atkSpeed = 0;
        }
    } 
}
