/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naumaxia;

/**
 *
 * @author Harrys
 */
public abstract class Ships {
    private final int lenght;
    private final char letter;
    private final Field field;

    
    private Location start;
    private ShipDirection dir;
    private int points;

    public Ships(int lenght, int points, char letter, Field field) {
        this.lenght = lenght;
        this.points = points;
        this.letter = letter;
        this.field = field;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setDir(ShipDirection dir) {
        this.dir = dir;
    }

    public int getLenght() {
        return lenght;
    }

    public int getPoints() {
        return points;
    }


    public char getLetter() {
        return letter;
    }

    public Field getField() {
        return field;
    }

    public Location getStart() {
        return start;
    }

    public ShipDirection getDir() {
        return dir;
    }
    
    public void hit(){
        points-=1;
    }
    public void isHit(){

    }
    
    public boolean isSinking(){
        if(points==0){
            return true;
        }
        else{
            return false;
        }
    }
    public void getHitMessage(){
           System.out.println("Boom! You got hit ");
    }
    public void getSinkMessage(){
        switch(letter){
            case 'D':
                System.out.println("You sink the Destroyer");
                break;
            case 'A':
                System.out.println("You sink the AircraftCarrier");
                break;
            case 'S':
                System.out.println("You sink the Submarine");
                break;     
                
                
                
        }
           
    }
}
