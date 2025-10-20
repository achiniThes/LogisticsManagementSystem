/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logisticsmanagementsystem;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class LogisticsManagementSystem {
    
    static Scanner input = new Scanner(System.in);
    
    //displaying menue
    static void printMenue(){
        System.out.println("\n==============================================");
        System.out.println("     LOGISTICS MANAGEMENT SYSTEM      ");
        System.out.println("==============================================");
        System.out.println("1. Manage Cities");
        System.out.println("2. Manage Distances");
        System.out.println("3. Manage Vehicles");
        System.out.println("4. Handle Deliveries");
        System.out.println("5. Reports");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        
    }

    public static void main(String[] args) {
        int choice;
        do{
            printMenue();
            choice = input.nextInt();
             
            switch (choice) {
                case 1:
                    manageCities();
                    break;
                case 2:
                    manageDistances();
                    break;
                case 3:
                    manageVehicles();
                    break;
                case 4:
                    handleDeliveries();
                    break;
                case 5:
                    showReports();
                    break;
                case 6:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);    
    }        
        
    static void manageCities(){
        
 
              
        
        
        
    }
    static void manageDistances(){
    }
    static void manageVehicles(){
    }
    static void handleDeliveries(){
    }
    static void showReports(){
    }
    
}
