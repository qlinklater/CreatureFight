import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    private HealthBar creatureBar;
    private int healthNumber;
    private boolean playerOneCreature;
    private String type;
    
    /**
     * Default constructor for objects of the Creature class
     * 
     * @param There are no parameters
     * @return an object of the Creature class
     */
    public Creature()
    {
         healthNumber = 500;
         creatureBar = new HealthBar( healthNumber, healthNumber, 10 );
    }

    /**
     * Constructor that allows customization of objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @return an object of the Creature class
     */
    public Creature( int health, boolean isPlayerOne, String creatureType )
    {
        healthNumber = health;
        creatureBar = new HealthBar( healthNumber, healthNumber, 10 );
        type = creatureType;
        playerOneCreature = isPlayerOne;
    }
    
    /**
     * getType gets the type of element a creature is 
     * 
     * @param there is no parameters
     * @return returning the creatures type
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * HealthBar getting the current health value for creature
     * 
     * @param there is no prameters
     * @return returning creatures health bar
     */
    protected HealthBar getHealthBar()
    {
        return creatureBar;
    }
    
    /**
     * WhetherPlayerOne chicking if it's pl;ayer 1 or 2 turn 
     * 
     * @param there is no parameteres
     * @return returning playerOneCreature turn
     */
    public boolean getWhetherPlayerOne()
    {
        return playerOneCreature;
    }
   
    public void attack( int idx )
    {
        //empty method that will get overriden in subclasses
        
    }
    
    public void switchCreature( int idx )
    {
        //empty method that will get overriden in subclasses
        
    }
    
    public void switchedIn()
    {
        //empty method that will get overriden in subclasses
    }

    public void act() 
    {
        //empty method that will get overriden in subclasses
    }   

}
