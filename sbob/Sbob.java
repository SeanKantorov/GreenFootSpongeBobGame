import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sbob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sbob extends Actor
{
    /**
     * Act - do whatever the Sbob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int gold = 10;
    public boolean trapped = false;
    public void act()
    {
        // Add your action code here.
        if (canCatchGold()){
            //keeps track of gold to add to scoreboard
            CatchGold();
            gold += 1;
        }
        if (canGetTrapped()){
            //if sbob can get trapped then it will turn the trapped variable into true, which will then end the game
            trapped = true;
        }
        //movement controls
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX() + 2, getY());
        }
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX() - 2, getY());
        }
        if (Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - 2);
        }
        if (Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+2);
        }
    }
    private boolean canCatchGold(){
        //checks if the gold can be caught
        Actor gold = getOneObjectAtOffset(0, 0, PirateGold.class);
        if (gold != null){
            return true;
        }
        else {
            return false;
        }
    }
    private void CatchGold(){
        //"catches" the gold
        Actor gold = getOneObjectAtOffset(0, 0, PirateGold.class);
        if (gold != null){
            //Greenfoot.playSound("cha_ching.wav");
            getWorld().removeObject(gold);
        }
    }
    private boolean canGetTrapped(){
        //checks if spongebob can get trapped
        Actor trap = getOneObjectAtOffset(0, 0, CrabTrap.class);
        if (trap != null){
            return true;
        }
        else {
            return false;
        }
    }
}
