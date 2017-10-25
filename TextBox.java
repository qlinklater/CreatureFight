import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage ing;
    private boolean border = false;
    private String text;
    private int fontSize;
    private Color foreground;
    private Color background;
    
    public TextBox( String message, int fs, boolean hasBorder, Color fg, Color bg )
    {
        fontSize = fs;
        border = hasBorder;
        foreground = fg;
        background = bg;
        text = message;
        
        ing = new GreenfootImage( message, fontSize, foreground, background );
        
        display();
    }
    
    public void display()
    {
        if( border == true )
        {
            ing.setColor( Color.BLACK );
            ing.drawRect( 0, 0, ing.getWidth() - 1, ing.getHeight() - 1 );
        }
        
        setImage( ing );
    }
    
    public String getText()
    {
        return text;
    }
    
    public void setText( String message )
    {
        text = message;
        ing = new GreenfootImage( text, fontSize, foreground, background );
        display();
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}