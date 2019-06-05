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
    public static boolean hasKeyBlue = false;
    TileEngine te;
    private int col;
    private int row;
    public static int n = 1;
    public static int diamonds;
    private int i;
    public static boolean w1c = false;
    public static boolean w2c = false;
    public static boolean w3c = false;
    public static boolean w4c = false;
    public Hero() {
        super();
        gravity = 9;
        acc = 0.5;
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
        getWorld().showText(Integer.toString(money),100,150);
        getWorld().showText(" Diamonds = " + Integer.toString(diamonds),925,125);
        getWorld().showText(Integer.toString(lives),100,100);
        //getWorld().showText(" Key = " + Integer.toString(key),950,175);
        //getWorld().showText(" World = " + getWorld(),850,200);
        //getWorld().showText(" Col = " + Integer.toString(col),950,225);
        //getWorld().showText(" Row = " + Integer.toString(row),950,250);
        
        remove();
        hud();
        
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        if(money > 40) {
            money -= 40;
            lives++;
          }
    }

    private void hud() {
        List <Health> health = getWorld().getObjects(Health.class);
        health.get(0).addKey(new GreenfootImage("hud_heartFull.png"),100,100);
        
         List <Hud> hud = getWorld().getObjects(Hud.class);
        hud.get(0).addKey(new GreenfootImage("coinGold.png"),100,150);
    }

    private void remove() {
        if (Hero.lives >= 0) {
                if (isTouching(FireBall.class)&& getWorld() instanceof World1) {
                    setLocation(300,1200);
                    Hero.lives--;
                    death();
                }
                if (isTouching(FireBall.class)&& getWorld() instanceof World3) {
                    setLocation(2700, 655);
                    Hero.lives--;
                    death();
                }
                if (isTouching(FireBall.class)&& getWorld() instanceof World4) {
                    setLocation(3300,650);
                    Hero.lives--;
                    death();
                }
                if (isTouching(Enemy.class)) {
                    setLocation(300,400);
                    Hero.lives--;
                    death();
                }
                if (isTouching(Liquid.class)&& getWorld() instanceof World1) {
                    setLocation(300,1200);
                    Hero.lives--;
                    death();
                }
                if (isTouching(Liquid.class)&& getWorld() instanceof World4) {
                    setLocation(3300,650);
                    Hero.lives--;
                    death();
                }
        }
    }
    
    private void death() {
        if (Hero.lives == 0) {
                    getWorld().removeObject(this);
                    Greenfoot.setWorld(new Menu());
                    Hero.lives = 5;
                    Hero.hasKeyBlue = false;
                    Hero.key = 0;
                    Hero.money = 0;
        }   
    }
    
    private boolean ground() {
        Actor ground = getOneObjectAtOffset (0,getImage().getHeight() / 2, Tile.class);
        return ground != null;
    }

    private boolean chainBlock() {
        Actor chain = getOneObjectAtOffset (0,getImage().getHeight() / 2, ChainBlock.class);
        return chain != null;
    }
    
    private boolean chain() {
        Actor chain = getOneObjectAtOffset (0,0, Chain.class);
        return chain != null;
    }
    private void handleInput() {
        if (Greenfoot.isKeyDown("space") && ground() == true && chainBlock() == true) {
            velocityY = -15;
            if (velocityY != 0) {
                setImage("p"+n+"_jump.png");
                getImage().scale(56, 78);
            }
        }
        if (Greenfoot.isKeyDown("space") && ground() == true && chain() == false) {
            velocityY = -15;
            if (velocityY != 0) {
                setImage("p"+n+"_jump.png");
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -7;
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
            velocityX = 7;
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
