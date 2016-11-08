import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends UI
{
    protected double RADIUS;       // The radius in wich the tower can attack Creeps.
    protected double RELOAD_SPEED; // Calls of act() methode before the tower can shoot again.
    protected double TOWER_DAMAGE; // The Damage that the Tower does to the creeps.
    protected int lastShot;        // Counts the calls of the act methode from the Tower untill it reacheas the value of REALOAD_SPEED.
    protected double BULLET_SPEED; // Bullet speed
    protected boolean attackFirst; // If True the tower will always shoot at the Creep with the lowest id in range = the creep nearst to the exit of the map, else it will alway shoot at the creep with the highest id in range.
    protected Creep target;        // Handel in wich the current target is stored.
    
    /**
     * Create a new Tower
     * 
     * @param radius        Radius of the tower.
     * @param reloadSpeed   Calls of Act methode before next shoot.
     * @param damage        Damage the tower does on enemys.
     * @param bulletSpeed   Bulletspeed.
     */
    public Tower(double radius, double reloadSpeed, double damage, double bulletSpeed, int towerCosts, boolean attackFirstCreep)
    {
        RADIUS        = radius;
        RELOAD_SPEED  = reloadSpeed;
        TOWER_DAMAGE  = damage;
        BULLET_SPEED  = bulletSpeed;
        lastShot      = (int) RELOAD_SPEED;
        attackFirst   = attackFirstCreep;
    }
    
    /**
     * Looks out for a target.
     * 
     * @return handle of the target
     */
    public Creep getTarget()
    {
        List objectsInRange = getObjectsInRange( (int) RADIUS, Creep.class );
    
        if( objectsInRange.size() > 0 )
        {
            int targetId = 0;
            int targetCreepId;
            
            if( attackFirst )
            {
                targetCreepId = MAX_CREEPS;
                
                for( int i = 0; i < objectsInRange.size(); i++ )
                {
                    if( ((Creep) objectsInRange.get(i)).id < targetCreepId )
                    {
                        targetCreepId = ((Creep) objectsInRange.get(i)).id;
                        targetId      = i;
                    }
                }
            }
            else
            {
                targetCreepId = 0;
                
                for( int i = 0; i < objectsInRange.size(); i++ )
                {
                    if( ((Creep) objectsInRange.get(i)).id > targetCreepId )
                    {
                        targetCreepId = ((Creep) objectsInRange.get(i)).id;
                        targetId = i;
                    }
                }
            }
            
            return (Creep) objectsInRange.get(targetId);
        }
        else return null;
    }
    
    /**
     * Rotate the Tower in the direction of the current target.
     */
    public void turnToTarget()
    {
        // Get a second point on the way of our target, this is needed for angle calculation.
        double angle = Math.toRadians( getRotation() );
        double x     = getX() + Math.cos(angle);
        double y     = getY() + Math.sin(angle);
        
        // Create two new vectors
        Vektor v1 = new Vektor(getX()-x, getY()-y);
        Vektor v2 = new Vektor(getX()-target.getX(), getY()-target.getY());
        
        
        // Let the creep do another step in mind, to look if we have to turn our tower left(-) or right(+).
        double Vangle = Math.toRadians( getRotation() + (int) Math.round(v1.getAngle(v1, v2)) );
        double vX     = x + Math.cos(Vangle);
        double vY     = y + Math.sin(Vangle);
        
        
        Vektor vV1 = new Vektor(x-vX, y-vY);
        Vektor vV2 = new Vektor(x-target.getX(), y-target.getY());
        
        // If the angle is less than 1 we have to turn left(-).
        if( (int) Math.round(vV1.getAngle(vV1, vV2)) > 1 )
        {
            turn( -(int) Math.round(v1.getAngle(v1, v2)) );
        }
        else
        {
            turn( (int) Math.round(v1.getAngle(v1, v2)) );
        }
    }
   
    /**
     * Returns the max. fire radius.
     * 
     * @return   Fire radius
     */
    public int getRadius()
    {
        return (int) RADIUS;
    }
    
    /**
     * Returns the damage, the tower does to creeps.
     * 
     * @return   Tower damage
     */
    public int getDamage()
    {
        return (int) TOWER_DAMAGE;
    }
    
    /**
     * Returns the reaload speed of the tower.
     * 
     * @return   Calls of Act methode before next shoot
     */
    public int getReloadSpeed()
    {
        return (int) RELOAD_SPEED;
    }
    
    /**
     * Changes the towers priority on wich creep in his range he will open fire.
     */
    public void attackFirstCreep(boolean attackFirstCreep)
    {
        attackFirst = attackFirstCreep;
    }
    
    /**
     * Returns the towers target priority
     * 
     * @return   Target priority.
     */
    public boolean getTargetPriority()
    {
        return attackFirst;
    }
    
    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation( getRotation()+angle );
    }
}

