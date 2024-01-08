
package naumaxia;
import java.util.Random;
/**
 *
 * @author Harrys
 */
public class Field {
    private int numRows;
    private int numCols;
    private Location pin[][];
    private Player player;

    public Field(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        
        pin = new Location[numRows][numCols];
        
        for (int i = 0 ; i < numRows ; i++){
            for (int j = 0 ; j < numCols ; j++){
                pin[i][j] = new Location(i, j);
            }
        }
}
    public Location getLocation(int r, int c){
        return pin[r][c];
    }

    public String getLocation(String locString){
        return "";
    } 

    public Integer getRows(){
        return this.numRows;
    }
    public Integer getColumns(){
        return this.numCols;
    }
    public String toString(){
        String s = "     ";
        int i , j;
        
        for (i = 1 ; i <= numCols ; i++){
            if (i < 9) s += i + "  ";
            else s += i + " ";
        }
        s += "\n    ";
        
        for (i = 1 ; i <= numCols ; i++) s += "---";
        
        
         s += "\n";
         char r = 'A';
         for ( i = 0 ; i < numRows ; i++){
             s += r + " |  ";
             r++;
             
             for (j = 0 ; j < numCols ; j++){
                 s += pin[i][j];
             }
             s += "\n";
         }
         return s;
    }
    
    public String toStringWithShips(){
        String s = "     ";
        int i , j;
        
        for (i = 1 ; i <= numCols ; i++){
            if (i < 9) s += i + "  ";
            else s += i + " ";
        }
        s += "\n    ";
        
        for (i = 1 ; i <= numCols ; i++) s += "---";
            s += "\n";
            char r = 'A';
            for ( i = 0 ; i < numRows ; i++){
                s += r + " |  ";
                r++;
                for (j = 0 ; j < numCols ; j++){
                    s += pin[i][j].toStringWithShips();
                }
                s += "\n";
         }
         return s;
    }
    
    public boolean placeShipRandomly(Ships s, int maxTries, boolean checkMarked){
        int length = s.getLenght();
        Random random = new Random();
        int row, col, index;
        ShipDirection dir;
        int tries = 0;
        boolean isVertical, isValidLocation;
        Location location;
        
      
        
        while (true){
            /* tyxaies syntetagmenes kai kateuthinsi */
            isVertical = random.nextBoolean();


            if (isVertical) 
                dir = ShipDirection.VERTICAL;
            else 
                dir = ShipDirection.HORIZONTAL;

            row = random.nextInt(numRows);
            col = random.nextInt(numCols);

            location = pin[row][col];// arxiki thesi

            index = 0;
            isValidLocation = true;
            
            
            // oso i thesi einai egkyrh kai den exo teleiosei me oles tis theseis tou ploiou
            while (isValidLocation == true && index < length){
                // an i thesi DEN einai keni, iparxei allo ploio
                if (location.isEmpty() == false) {
                    isValidLocation = false;
                }
                
                 
                // an h thesh einai marked
                if (checkMarked == true && location.isMarked() == true){
                    isValidLocation = false;
                }

                // sth sunexeia vriskw epomenh thesh pou eksartatai apo prosanatolismo
                
                if (isValidLocation == true){
                    switch (dir){
                        case HORIZONTAL:
                            col++;
                            // elegxw an einai ektos orion pinaka 
                            if (col >= numCols)
                                isValidLocation = false;
                            break;
                        case VERTICAL:
                            row++;
                            if (row >= numRows)
                                isValidLocation = false;
                            break;
                    }
                }

                // nea thesi
                if (isValidLocation == true){
                    location = pin[row][col];
                }
                index++; 
            }

           
            // topothetw to ploio
            if (isValidLocation == true){
                
                // Afou exw elegksei length fores panw, epanaferw to row kai to col
                switch (dir){
                    case HORIZONTAL: 
                        col-= length; 
                        break;
                    case VERTICAL: 
                        row-=length; 
                        break;
                }

                // afti einai i arxiki thesi kai tin kataxoro sto ploio
                location = pin[row][col];
                s.setDir(dir);
                s.setStart(location);

                // prepei ola ta Locations na periexoyn to ploio 
                for (int i = 0 ; i < length ; i++){
                    location.setShip(s);

                    switch (dir){
                        case HORIZONTAL: 
                            col++; 
                            break;
                        case VERTICAL: 
                            row++;  
                            break;
                    }
                    location = pin[row][col];
                }
                
                return true;
            }
            else {
                tries++;
                if (maxTries > 0 && tries == maxTries) 
                    return false;
            }
        }
    }
    
}

