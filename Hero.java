import java.util.*;
import greenfoot.*;
/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public static int money;
    public String teller;
    public static int p = 1;
    public String dir;
    public static int lives = 5;
    public static int key = 0;
    public static boolean hasKeyBlue;
    TileEngine te;
    private int col;
    private int row;
    public static int n = 1;
    public static int diamonds;
    
    private int i;
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");

    }

    @Override
    public void act() {
        handleInput();
        col = getX() / 70;
        row = getY() / 70;
        velocityX *= drag;
        velocityY += acc;
        getWorld().showText(" X = " + Integer.toString(getX()),950,50);
        getWorld().showText(" Y = " + Integer.toString(getY()),950,75);
        getWorld().showText(" Points = " + Integer.toString(money),950,100);
        getWorld().showText(" Diamonds = " + Integer.toString(diamonds),950,125);
        getWorld().showText(" Lives = " + Integer.toString(lives),950,150);
        getWorld().showText(" Key = " + Integer.toString(key),950,175);
        getWorld().showText(" World = " + getWorld(),850,200);
        getWorld().showText(" Col = " + Integer.toString(col),950,225);
        getWorld().showText(" Row = " + Integer.toString(row),950,250);
        
        hudHealth();
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        if(money > 40) {
            money -= 40;
            lives++;
          }
    }

    private void hudHealth() {
        List <Health> health = getWorld().getObjects(Health.class);
        health.get(0).addKey(new GreenfootImage("hud_heartEmpty.png"),100,100);
        health.get(1).addKey(new GreenfootImage("hud_heartEmpty.png"),150,100);
        health.get(2).addKey(new GreenfootImage("hud_heartEmpty.png"),200,100);
        if (Hero.lives >= 1) {
            health.get(0).addKey(new GreenfootImage("hud_heartHalf.png"),100,100);
        }
        if (Hero.lives >= 2) {
            health.get(0).addKey(new GreenfootImage("hud_heartFull.png"),100,100);
        }
        if (Hero.lives >= 3) {
            health.get(1).addKey(new GreenfootImage("hud_heartHalf.png"),150,100);
        }
        if (Hero.lives >= 4) {
            health.get(1).addKey(new GreenfootImage("hud_heartFull.png"),150,100);
        }
        if (Hero.lives >= 5) {
            health.get(2).addKey(new GreenfootImage("hud_heartHalf.png"),200,100);
        }   
    }

    /*private void remove() {
        if(isTouching(CoinGold.class)) {
            removeTouching(CoinGold.class);
            money += 35;}
        if(isTouching(CoinSilver.class)) {
            removeTouching(CoinSilver.class);
            money += 2;
        }

    }*/
    
    private boolean ground() {
        Actor ground = getOneObjectAtOffset (0,getImage().getHeight() / 2, Tile.class);
        return ground != null;
    }

    private void handleInput() {
        if (Greenfoot.isKeyDown("space")){
            velocityY = -15;
        }
        if (Greenfoot.isKeyDown("w") && ground() == true) {
            velocityY = -15;
            if (velocityY != 0) {
                setImage("p"+n+"_jump.png");
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            if (velocityY != 0) {
                setImage("p"+n+"_jump.png");
                getImage().mirrorHorizontally();
            }
            else if (velocityX < 0) {
                animation();
                getImage().mirrorHorizontally();
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            if (velocityY != 0) {
                setImage("p"+n+"_jump.png");
            }
            else if (velocityX > 0) {
                animation(); 
            }
        }
        if (velocityX == 0 && velocityY == 0) {
            setImage("p"+n+"_front.png");
        }
        if (Greenfoot.isKeyDown("s") && velocityX == 0) {
            setImage("p"+n+"_duck.png");
        } 
    }

    private int getWidth() {
        return getImage().getWidth();
    }

    private int getHeight() {
        return getImage().getHeight();
    }

    private void animation() {
        String dir = "images/p"+n+"_walk/PNG/p"+n+"_walk";
        if (p != 12){
            teller = Integer.toString(p);
            p++; 
        } else if (p == 12){
            p = 1;}

        setImage(dir+teller+".png");
    }

}
