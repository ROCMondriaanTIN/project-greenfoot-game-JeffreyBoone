import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorOpenMid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorOpenMid extends Tile
{
    public String door;
    public DoorOpenMid(String image,int width,int heigth) {
        super(image,width,heigth);
    }
    public void act() 
    {
        if (Hero.key == 0) {
        setImage("door_closedMid.png" );}
        if (Hero.key == 1) {
        setImage("door_openMid.png" );
        for (Actor hero : getIntersectingObjects(Hero.class)) {
                if ((hero != null && getWorld() instanceof MyWorld) && (Greenfoot.isKeyDown("s"))) {
                    TestWorld Test = new TestWorld();
                    Greenfoot.setWorld(Test);
                    break;
                }
                if ((hero != null && getWorld() instanceof TestWorld) && (Greenfoot.isKeyDown("s"))) {
                    MyWorld World = new MyWorld();
                    Greenfoot.setWorld(World);
                    break;
                }
        }
      }
    }   
}
