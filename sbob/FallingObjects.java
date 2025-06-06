import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObjects extends Actor
{
    /**
     * Act - do whatever the FallingObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //class variables
    private int dropSpeed = 1;
    private boolean onBottom = false;
    
    //procedures
    public void act()
    {
        // Add your action code here.
        fall();
    }
    public void fall()
    {
        //moves the object down if it isn't touching the bottom
        if (!onBottom){
            this.setLocation(getX(),getY() + dropSpeed);
            onBottom = checkBottom();
    }
    }
    private boolean checkBottom()
    {
        //checks if an object is on the "floor" so  the code will know to stop the falling of an object
        if (getY() > 570){
            getWorld().removeObject(this);
            return true;
        }
        else {
            return false;
        }
    }
}
