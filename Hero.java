

import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public int money;
    public int teller;
    public int y;
    public int x;

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
        
        velocityX *= drag;
        velocityY += acc;
        getWorld().showText(" X = " + Integer.toString(getX()),950,50);
        getWorld().showText(" Y = " + Integer.toString(getY()),950,75);
        getWorld().showText(" Points = " + Integer.toString(money),950,100);
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        remove();
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }
    public void remove() {
        if(isTouching(CoinGold.class)) {
        removeTouching(CoinGold.class);
        money += 2;
    }
  }
    
    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            velocityY = -10;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -2;
            animation();
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 2;
            animation();
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

    public void animation() {
       String dir = "images/p1_walk/PNG/p1_walk";
       for (y = 1; x <= 12; y++){
         if (y <10){
             String teller = "0"+y; 
        } else if (y < 12){
             String teller = ""+y;   
        } else if (y == 12){
             y = 1;}
       
        setImage(dir+Integer.toString(teller)+".png");
    }
        
}
 }      

   