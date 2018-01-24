import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lapras extends Creature
{
    public Lapras( World w )
    {
        super( 900, false, "Water" );
        getImage().scale( 150,100 );
        w.addObject(getHealthBar(), 100, 25);
        getHealthBar().getImage().setTransparency(0);
    }
    
    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
         
        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Lapras has fainted...",getWorld().getWidth()/2,getWorld().getHeight()/2+26 );
            Greenfoot.delay(30);
            if( playerWorld.getNewTwoCreature(0).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.changeTurn(false);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(20);
                getWorld().removeObject(this);
            }
            else if( playerWorld.getNewTwoCreature(2).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(1);
                playerWorld.changeTurn(false);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(20);
                getWorld().removeObject(this);
            }
        }
    }    
    
    /**
     * attack the Creature attacks another creature changing it's health value
     * 
     * @param idx is index
     * @return Nothing is returned
     */
    public void attack( int idx )
    {
        CreatureWorld world =(CreatureWorld)getWorld();
        Creature enemy = world.getPlayerOne();
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx <= 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            if( enemyType.equalsIgnoreCase("Fire") )
            {
                enemy.getHealthBar().add( -100*2 );
                getWorld().showText("It's super effective!", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase("Rock") )
            {
                enemy.getHealthBar().add( -100*2 );
                getWorld().showText("It's super effective!", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase("Grass") )
            {
                enemy.getHealthBar().add( -100/2 );
                getWorld().showText("It's not very effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -100 );
            }
        }
        world.changeTurn(true);
    }
    
     /**
     * attackAnimation is sets of images displayed when the attack is happening
     * 
     * @param there is no parameters
     * @return Nothing is returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for( int i = 0; i < 15; i++ )
        {
            setLocation( getX() - 1, getY() + 2 );
            Greenfoot.delay(1);
        }
        setLocation( originalX, originalY );
    }
    
    /**
     * switchCreature is when the user wants or have to change creatures
     * 
     * @param idx is index
     * @returned Nothing is returnned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world =(CreatureWorld)getWorld();
        Creature switchCreature;
        if( idx == 0 )
        {
            switchCreature = world.getNewTwoCreature(0);
        }
        else
        {
            switchCreature = world.getNewTwoCreature(2);
        }
        
        if( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while( getX() < getWorld().getWidth() - 1 )
            {
                setLocation( getX() + 5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if( idx == 0 )
            {
                world.changePlayerTwo("Pikachu");
            }
            else
            {
                world.changePlayerTwo("Pidgeot");
            }
            switchCreature.switchedIn();
            world.changeTurn(true);
        }
    }
    
    /**
     * switchedIn is the animation of creatures switching out and on screen
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while( getX() > 325 )
        {
            setLocation( getX() - 5, getY() );
            Greenfoot.delay(2);
        }
    }
}
