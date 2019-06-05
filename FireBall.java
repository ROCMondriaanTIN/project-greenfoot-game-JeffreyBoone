import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBall extends Tile
{    
    public FireBall(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        setImage("fireball.png" );
        getImage().scale(70,70);
        turn(5);
        move(20);
        move(-20);
        
           
    }     
}
