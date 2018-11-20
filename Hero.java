    
    
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
        public int y = 1;
        public int x;
        public String dir;
        
        
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
            getWorld().showText(" World = " + getWorld(),850,125);
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
            money += 2;}
            else if(isTouching(CoinSilver.class)) {
            removeTouching(CoinSilver.class);
            money += 1;
            }
        }
    
    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            velocityY = -10;
            if (velocityY != 0) {
               setImage("p1_jump.png");
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -2;
            if (velocityY != 0) {
               setImage("p1_jump.png");
               getImage().mirrorHorizontally();
               }
            else if (velocityX < 0) {
               animation();
               getImage().mirrorHorizontally();
              }
        }
        if (Greenfoot.isKeyDown("d")) {
            velocityX = 2;
            if (velocityY != 0) {
               setImage("p1_jump.png");
               }
            else if (velocityX > 0) {
               animation(); 
              }
        }
        if (velocityX == 0 && velocityY == 0) {
            setImage("p1_front.png");
        }
        if (Greenfoot.isKeyDown("s") && velocityX == 0) {
            setImage("p1_duck.png");
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
        if (y != 12){
             teller = Integer.toString(y);
             y++; 
        } else if (y == 12){
             y = 1;}
       
        setImage(dir+teller+".png");
    }
    
    
    
}

   