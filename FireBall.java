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
        turn(5);
        move(20);
        move(-20);
        if (Hero.lives == 1 && isTouching(Hero.class)) {
            for (Actor def : getIntersectingObjects(Hero.class)) {
                if (Hero.lives == 1 && isTouching(Hero.class)) {
                    getWorld().removeObject(def);
                    Greenfoot.setWorld(new Menu());
                    Hero.lives = 2;
                    Hero.hasKeyBlue = false;
                    Hero.key = 0;
                    Hero.money = 0;
                    break;
                }
              }
            }
           
    }     
}
