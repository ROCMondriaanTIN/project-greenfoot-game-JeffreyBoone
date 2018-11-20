import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorOpenTop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorOpenTop extends Tile
{
    public String door;
    public DoorOpenTop(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        setImage("door_openTop.png" ); 
        for (Actor hero : getIntersectingObjects(Hero.class)) {
                if (hero != null && getWorld() instanceof MyWorld) {
                    TestWorld Test = new TestWorld();
                    Greenfoot.setWorld(Test);
                    break;
                }
                if (hero != null && getWorld() instanceof TestWorld) {
                    MyWorld World = new MyWorld();
                    Greenfoot.setWorld(World);
                    break;
                }
            }
    }  
}
