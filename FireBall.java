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
        if (Hero.lives == 1) {
            for (Actor hero : getIntersectingObjects(Hero.class)) {
                if (hero != null) {
                    getWorld().removeObject(hero);
                    Hero.lives--;
                    break;
                }
              }
            }
        if (Hero.lives == 2 || Hero.lives == 3) {
            for (Actor hero : getIntersectingObjects(Hero.class)) {
                if (hero != null) {
                    MyWorld World = new MyWorld();
                    Greenfoot.setWorld(World);
                    Hero.lives--;
                    break;
                }
              }
            }
            
    }     
}
