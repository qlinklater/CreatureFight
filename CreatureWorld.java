import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *(Quentin Linklater) 
 * Course CS20
 * Teacher MR.Hardman
 * LAB #1, Program #1
 * (9/29/2017)
 * 
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;

    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);
        
        prepareCreatures();
       Greenfoot.start();
    }
    
    private void prepareCreatures()
    {
        addObject(playerOneCreature,playerOneCreature.getImage().getWidth()/2,getHeight() - playerOneCreature.getImage().getHeight()/2);
        addObject(new Button(Color.RED,50), getWidth()/2 ,getHeight() - 100);
        addObject(playerTwoCreature,getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
        addObject(new Button(Color.RED,50), getWidth()/2,100);
    }
    
    public Creature getPlayerOne()
    {
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()

    {
        return playerTwoCreature;
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);
        
        if( playerOneCreature.getHealthBar().getCurrent() <= 0 )
        {
            removeObjects(allObjects);
            showText("Player Two Wins",getWidth()/2,getHeight()/2 );
            Greenfoot.stop();
        }
        
          if( playerTwoCreature.getHealthBar().getCurrent() <= 0 )
        {
            removeObjects(allObjects);
            showText("Player One Wins",getWidth()/2,getHeight()/2 );
            Greenfoot.stop();
        }
   }
}
