import java.util.random.*;
import java.util.ArrayList;

public class Monster implements Contract {
    
    
    /**
    * String attribute monster 
    */
    String monster;
    /**
    * String attribute item 
    */
    String item;
    /**
    * String attribute direction 
    */
    String direction;
    /**
    * int attribute x
    */
    int x;
    /**
    * int attribute y
    */
    int y;
    /**
    * int attribute for default size of monster 
    */
    int size = 5;
    /**
    * int attribute to indicate if monster is holding an item, 0 for not holding, 1 for holding
    */
    int holding = 0;
    /**
    * boolean attribute to indicate if monster can fly, which default is true 
    */
    boolean canFly = true;


    /**
    * constructs attributes for Monster class
    * @param String name
    *           name of monster
    */
    public Monster(String name) {
        this.monster = name;
    }


    /**
    * overloaded constructer for Monster class with added parameter of boolean canFly for cases in which a monster cannot fly 
    * @param String name
    *           name of monster
    * @param boolean canFly
    *            boolean of whether or not monster can fly
    */
    public Monster(String name, boolean canFly) {
        this.monster = name;
        this.canFly = canFly;
    }




    /** 
    * method for monster to grab an item
    * @param String item
    *          item for monster to grab 
    */
    public void grab(String item) {
        if (holding == 1) {
            throw new RuntimeException(this.monster + " is already holding an item, cannot grab anything else");
        }
        this.holding = 1;
        System.out.println(this.monster + " has grabbed a " + item);

    }


    /** 
    * method for monster to drop an item they're holding
    * @param String item
    *          item to drop 
    * @return String 
    *           statement that the monster has dropped the item
    */
    public String drop(String item) {
        if (holding != 1) {
            throw new RuntimeException(this.monster + " is not holding anything");
        }
        this.holding = 0;
        return this.monster + " has dropped a " + item;
    }


    /** 
    * method for monster to examine an item
    * @param String item
    *          item for monster to examine
    */
    public void examine(String item) {

        ArrayList<String> examination = new ArrayList<String>();

        examination.add(" is cool!");
        examination.add(" is boring");
        examination.add(" is scary");
        examination.add(" is amazing");

        System.out.println(this.monster + " is examining a " + item);
        int randomIndex = (int) (Math.random() * examination.size());
        System.out.println(this.monster + " thinks this " + item + examination.get(randomIndex));
    }


    /** 
    * method for monster to use an item
    * @param String item
    *          item for monster to use
    */
    public void use(String item) {
        if (holding != 1) {
            throw new RuntimeException(this.monster + " is not holding anything to use");
        }
        else{
        System.out.println(this.monster + " is using a " + item);
        }
    }
    

    /** 
    * method for monster to walk 
    * @param String direction
    *          direction for monster to walk in
    * @return boolean walk
    *           boolean for if monster is walking or not 
    */
    public boolean walk(String direction) {
        System.out.println(this.monster + " is walking to the " + direction);
        return true;
    }

    /** 
    * method for monster to fly
    * @param int y
    *          
    * @param int x
    *         
    * @return boolean 
    *           boolean for if monster is flying or not 
    */
    public boolean fly(int y, int x) {
       if (this.canFly == true) {
        System.out.println(this.monster + " flew " + y + " feet in the air and travelled " + x + " miles");
        return true;
       }
       else {
        System.out.println(this.monster + " cannot fly");
        return false;
       }
    }


    /** 
    * method for monster to shrink by 1 foot      
    * @return Number 
    *           size of monster in number of feet 
    */
    public Number shrink() {
        System.out.println(this.monster + " has shrunk from " + size + " feet to " + (size-1) + " feet");
        size = size - 1;
        return size;

    }

    /** 
    * overloaded method for monster to shrink with added parameter of int for feet to shrink by
    * @param int feet
    *           number of feet to shrink by     
    * @return Number 
    *           size of monster in number of feet 
    */
    public Number shrink(int feet){
        System.out.println(this.monster + " has shrunk from " + size + " feet to " + (size-feet) + " feet");
        size = size - feet;
        return size;
    }

    /**     
    * method for monster to grow by 1 foot      
    * @return Number 
    *           size of monster in number of feet 
    */
    public Number grow() {
        System.out.println(this.monster + " has grown from " + size + " feet to " + (size+1) + " feet");
        return size + 1;

    }

    /** 
    * overloaded method for monster to grow with added parameter of int for feet to grow by
    * @param int feet
    *           number of feet to grow by     
    * @return Number 
    *           size of monster in number of feet 
    */
    public Number grow(int feet) {
        System.out.println(this.monster + " has grown from " + size + " feet to " + (size+feet) + " feet");
        size = size + feet;
        return size;

    }

    /**   
    * method for monster to rest by sleeping 
    */
    public void rest() {
        System.out.println(this.monster + " is going to sleep");
    }

    /** 
    * overloaded method for monster to rest with added parameter of int number of minutes to sleep for
    * @param int minutes
    *          minutes to sleep 
    */
    public void rest(int minutes) {
        System.out.println(this.monster + " is going to sleep for " + minutes + " minutes");
    }

    /** 
    * method to undo
    */
    public void undo() {
        System.out.println("what's been done cannot be undone");
    }

    /** 
    * method for monster to scare someone if it is not nice
    * @param boolean nice
    *          whether or not monster is nice or not
    */
    public void scare(boolean nice){
        if (nice == false) {
            System.out.println(this.monster + " has scared someone");
        }
        else{
            System.out.println(this.monster + " is too nice to scare someone");
        }
    }


    public static void main(String[] args) {
        Monster ghost = new Monster("mr. ghost");
        Monster vampire = new Monster("mr. vamp");
        Monster skeleton = new Monster("mr. bones", false);
        vampire.grab("garlic clove");
        System.out.println(vampire.drop("garlic clove"));
        vampire.grab("blood orange");
        ghost.grab("phone");
        ghost.examine("strange substance");
        skeleton.examine("strange substance");
        ghost.use("phone");
        skeleton.walk("left");
        vampire.shrink();
        vampire.shrink();
        vampire.rest();
        ghost.rest(20);
        ghost.shrink(3);
        ghost.grow(2);
        ghost.fly(50, 30);
        skeleton.fly(100,100);
        vampire.scare(false);
        ghost.scare(true);
        vampire.undo();
        ghost.grab("pen");
        
    }


}
