/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naumaxia;

/**
 *
 * @author Harrys
 */
public class Location {
    private int row;
    private int col;
    private Ships ship;
    private boolean marked;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setShip(Ships ship) {
        this.ship = ship;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Ships getShip() {
        return ship;
    }
    
    public void mark(){
        marked = true;
        /* an yparxei ploio, to xtypaw*/
        if(!this.isEmpty()){
            
            if(this.ship.getPoints()>1){
                this.ship.hit();
                this.ship.getHitMessage();
                
            }
            else if(this.ship.getPoints()<=1 ){
                this.ship.hit();
                this.ship.getSinkMessage();
            }
            else{
                System.out.println("You have already sink this ship!");
            }
        }
         /* an den yparxei ploio, emfanizw mhnuma */
        else{
            System.out.println("----------You missed!------------");
        }
        
    }
    public boolean isMarked(){
        return marked;
    }
    public boolean isEmpty(){
        if (ship == null) 
            return true;
        else 
            return false;
    }
    public void isHit(){
        
    }
    
    
    public String toString(){
    if (!marked) {
        return ".  ";
    } else if (ship == null) {
        return "o  ";
    } else if (!ship.isSinking()) {
        return "x  ";
    } else {
        return "x" + ship.getLetter() + " ";
    }
}
    
    
    public String toStringWithShips() {
    if (!marked && ship == null) {
        return ".  ";
    } else if (marked && ship == null) {
        return "o  ";
    } else if (marked && ship != null) {
        if (ship.isSinking()) {
            return "x" + ship.getLetter() + " ";
        } else {
            return "x" + ship.getLetter() + " ";
        }
    } else {
        return ship.getLetter() + "  ";
    }
}
}
