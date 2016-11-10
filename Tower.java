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
    private int atkSpeed;
    
    public Tower()
    {
        damage = 10;
    }
    
    
    public Tower(int d)
    {
        damage = d;
           }
    
     /*
     * get methods
     */
    public int getDamage()
    {
        return damage;
    }
    
    /*
     * set methods
     */
    public void setDamage(int n)
    {
        damage = n;
    }
    
    public boolean isHeroInRange()
    {
        return !getObjectsInRange(300, Hero.class).isEmpty();
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
        if(atkSpeed >= 70)
        {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
            atkSpeed = 0;
        }
   } 
}
