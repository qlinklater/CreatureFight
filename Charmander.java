import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Charmander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Creature
{
    public Charmander( World w )
    {
        super( 700, true, "Fire" );
        getImage().scale( 150,100 );
        w.addObject(getHealthBar(), 300, w.getHeight() - 50);
        
    }
    
    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();

        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Charmander has fainted...",getWorld().getWidth()/2,getWorld().getHeight()/2+26 );
            Greenfoot.delay(30);
            if( playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.changeTurn(true);
                getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(20);
                getWorld().removeObject(this);
            }
            else if( playerWorld.getNewOneCreature(2).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(1);
                playerWorld.changeTurn(true);
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
        Creature enemy = world.getPlayerTwo();
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx <= 0 )
        {
            enemy.getHealthBar().add( -25 );
        }
        else
        {
            if( enemyType.equalsIgnoreCase("Water") )
            {
                enemy.getHealthBar().add( - 2 );
                getWorld().showText("It's not very effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -70 );
            }
        }
        world.changeTurn(false);
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
            setLocation( getX() + 1, getY() - 2 );
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
            switchCreature = world.getNewOneCreature(1);
        }
        else
        {
            switchCreature = world.getNewOneCreature(2);
        }
        
        if( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while( getX() > 0 )
            {
                setLocation( getX() - 5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if( idx == 0 )
            {
                world.changePlayerOne("Golem");
            }
            else
            {
                world.changePlayerOne("Ivysaur");
            }
            switchCreature.switchedIn();
            world.changeTurn(false);
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
        while( getX() < 75 )
        {
            setLocation( getX() + 5, getY() );
            Greenfoot.delay(2);
        }
    }
}
