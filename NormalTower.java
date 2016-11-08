import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalTower extends Tower
{
    public NormalTower()
    {
        super(75, 50, 18, 7.0, true);
    }
    
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        target = getTarget();
        
        if( lastShot < RELOAD_SPEED)
            lastShot++;
        
        if( target != null )
        {
            turnToTarget();
            
            if( lastShot >= RELOAD_SPEED )
            {
                // Schuss Koordinaten berechnen
                double angle = Math.toRadians( target.getRotation() );
                double x     = target.getX() + Math.cos(angle) * target.getSpeed();
                double y     = target.getY() + Math.sin(angle) * target.getSpeed();
                
                getWorld().addObject(new NormalBullet((int) x, (int) y, (int) BULLET_SPEED, (int) TOWER_DAMAGE, "hit.wav"), getX(), getY());
                
                lastShot = 0;
            }
        }
    }     
}
