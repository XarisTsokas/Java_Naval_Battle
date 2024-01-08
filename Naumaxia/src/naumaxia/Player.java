package naumaxia;
import java.util.Scanner;  

public class Player {
    private String name;
    private int score;
    private Field field;
    
    public void initField(int r, int c){
        field = new Field(r, c);
    }
    public void placeShips(Field otherField){
        AircraftCarrier a1 = new AircraftCarrier(otherField);
        otherField.placeShipRandomly(a1,0, true);
        
        AircraftCarrier a2 = new AircraftCarrier(otherField);
        otherField.placeShipRandomly(a2, 0, true);
        
        Destroyer d1 = new Destroyer(otherField);
        otherField.placeShipRandomly(d1, 0, true);
        
        Destroyer d2 = new Destroyer(otherField);
        otherField.placeShipRandomly(d2, 0, true);
        
        Destroyer d3 = new Destroyer(otherField);
        otherField.placeShipRandomly(d3, 0, true);
        
        Submarine s1 = new Submarine(otherField);
        otherField.placeShipRandomly(s1, 0, true);
        
        Submarine s2 = new Submarine(otherField);
        otherField.placeShipRandomly(s2, 0, true);
        
    }

    
    public void selectMove(){

        Scanner myObj = new Scanner(System.in);  


        System.out.println("Select a Location (ex. a10):");
        String locationChoosed = myObj.nextLine();  
        Character xAxisS =locationChoosed.charAt(0);
        String yAxisS ="";
        for (int i=1; i<locationChoosed.length(); i++){
            yAxisS+=(Character.toString(locationChoosed.charAt(i)));    
        }

        Integer xAxis =  xAxisS-'a';
        Integer yAxis = Integer.parseInt(yAxisS)-1;


         /* elegxw an h topothesia einai entos orion */
        while(!(xAxis<this.field.getRows() && xAxis>=0 && yAxis<this.field.getColumns() && yAxis>=0)){
                System.out.println("Wrong location, please enter a valid one(ex. a10): ");
                    locationChoosed = myObj.nextLine();  
                    xAxisS =locationChoosed.charAt(0);
                    yAxisS ="";
                for (int i=1;i<locationChoosed.length();i++){
                    yAxisS+=(Character.toString(locationChoosed.charAt(i)));
                }
        
                xAxis =  xAxisS-'a';
                yAxis = Integer.parseInt(yAxisS)-1;
        
        }
        /*elegxw an yparxei ploio sthn epilegmenh topothesia */
        this.field.getLocation(xAxis, yAxis).mark();
        System.out.println("You choose: "+ xAxisS + yAxisS );
        System.out.println(this.field.toString());
        
    }

    public boolean hasWon(){
        return true;
    }

    public String getName() {
        return name;
    }
    public void setName(String userName){
        this.name=userName;
    }

    public int getScore() {
        return score;
    }

    public Field getField() {
        return field;
    }
}
