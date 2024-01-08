/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package naumaxia;

/**
 *
 * @author Harrys
 */

 import java.util.Scanner;  

public class Naumaxia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*  PLAYER 1 */
        System.out.println( "\n---------------------------------------------------------------------------\n");

        System.out.println("\nHello player1, please enter your name to continue: ");

        Scanner myObj = new Scanner(System.in);  
        String p1Name = myObj.nextLine();  
        System.out.println( "\nHello "+ p1Name+" ,welcome to NAUMAXIA");
        System.out.println( "---------------------------------------------------------------------------\n");
      
        Player p1 = new Player();
        p1.setName(p1Name);

        /*  PLAYER 2 */
        System.out.println("Please enter second's player name ");

        String p2Name = myObj.nextLine();  
        System.out.println( "\nHello "+ p2Name+" ,welcome to NAUMAXIA");
        System.out.println( "---------------------------------------------------------------------------\n");

        Player p2 = new Player();
        p2.setName(p2Name);

        
        int r= 0;
        int c= 0;
        while(r<10|| r>15 && c<10 || c>15){
            System.out.println("Please give the number of rows and columns(between 10-15) of the players' field");
            r=myObj.nextInt();
            c=myObj.nextInt();
        }
        p1.initField(r, c);
        p2.initField(r, c);
        
        p1.placeShips(p2.getField());
        p2.placeShips(p1.getField());    


        while(true){
            System.out.println("----- "+p1Name+" its your turn!");
            System.out.println("Your table is:");
            System.out.println( "---------------------------------------------------------------------------\n");
            System.out.println(p2.getField().toStringWithShips());
            System.out.println( "---------------------------------------------------------------------------\n");
            System.out.println("And your oppenents table is\n");
            System.out.println( "---------------------------------------------------------------------------\n");
            System.out.println(p1.getField().toString());
            p1.selectMove();
            System.out.println( "-------------------------------------------------------------------------------------------------------------------------------\n");

            System.out.println("----- "+p2Name+" its your turn!");
            System.out.println("Your table is:");
            System.out.println( "---------------------------------------------------------------------------\n");
            System.out.println(p1.getField().toStringWithShips());
            System.out.println( "---------------------------------------------------------------------------\n");
            System.out.println("And your oppenents table is\n");
            System.out.println( "---------------------------------------------------------------------------\n");
            System.out.println(p2.getField().toString());
            p2.selectMove();
            System.out.println( "-------------------------------------------------------------------------------------------------------------------------------\n");

            
        }
    }
    
}
