import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class WaterWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterWorld extends World
{
    //class variables
    private ArrayList<Integer> values;
    private Random random;
    private Sbob sbob;
    private String scoreBoardPartOne;
    private String fullScoreBoard;
    public WaterWorld()
    {    
        // Creates a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        //creates the player character and places him on the screen
        sbob = new Sbob();
        addObject(sbob, 328, 537);
        sbob.setLocation(399, 527);
        //part of the scoreboard string that we want to be displayed immidiatly and won't change
        scoreBoardPartOne = "You have collected: %s";
    }
    public void dropGold(){
        PirateGold g = new PirateGold();
        addObject(g, Greenfoot.getRandomNumber(getWidth()), 10);
    }
    public void dropTrap(){
        CrabTrap t = new CrabTrap();
        addObject(t, 50 + Greenfoot.getRandomNumber(getWidth()-100), 10);
    }
    public void act(){
        values = new ArrayList<>();
        random = new Random();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        if (Greenfoot.getRandomNumber(120) == 5){
            int num = random.nextInt(values.size());
            for (int i=0; i<=num; i++){
                dropGold();
            }
        }
        if (Greenfoot.getRandomNumber(720) < 15){
            int num = random.nextInt(values.size());
            for (int i=0; i<=num; i++){
            dropTrap();
        }
        }
        if (sbob.trapped){
            //displays the game over text if sbob gets caught in the trap, and then ends the game
            showText("GAME OVER",400,300);
            Greenfoot.stop();
        }
        //Displays the "scoreboard"
        //the scoreboard is just a string
        //the format string method was used to concatenate the strings and to keep the function call short for displaying the scoreboard
        fullScoreBoard = String.format(scoreBoardPartOne, String.valueOf(sbob.gold) + " gold!");
        showText(fullScoreBoard, 600, 50);
    }
}

