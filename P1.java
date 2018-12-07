import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P1 extends MenuOptions
{
    
    public P1(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            Hero.n = 1;
          }
    }    
}
