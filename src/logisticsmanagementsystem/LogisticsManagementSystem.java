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
    static String[] cities = new String[30];
    static int cityCount = 0;
    static double [][] distances=new double[30][30];
    
    static String[] vehicleTypes = {"Van", "Truck", "Lorry"};
    static int[] vehiclCcapacity = {1000, 5000, 10000};     
    static int[] vehicleRate = {30, 40, 80};  //per km         
    static int[] vehicleAvgSpeed = {60, 50, 45};            
    static int[] vehicleFuelEfficiency = {12, 6, 4};            

   
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
    //main method
    public static void main(String[] args) {
        int choice;
        do{
            printMenue();
            choice = input.nextInt();
             
            switch (choice) {
                case 1:
                    manageCities(); //calling managecities() function
                    break;
                case 2:
                    manageDistances(); //calling manageDistances() function
                    break;
                case 3:
                    manageVehicles();  //calling managevehicles() function
                    break;
                case 4:
                    handleDeliveries(); //calling handleDeliveries() function 
                    break;
                case 5:
                    showReports(); //showReports() function
                    break;
                case 6:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);    
    }        
    
    //city management
    static void manageCities(){
        System.out.println("\n--Manage Cities--");
        System.out.println("1.Add a city");
        System.out.println("2.Rename a city");
        System.out.println("3.Remove a city");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int cityChoice = input.nextInt();
        input.nextLine(); 
        
        switch (cityChoice){
            case 1->addcity(); //caling addcity() method
            case 2->renamecity(); //caling  renamecity() method
            case 3->removecity(); //calling removecity() method 
            case 4-> System.out.println("Back to main menue..");//returning to main meue
            default->System.out.println("Invalid choice");    
                    
        }
    }
    
    static void addcity(){  //adding a new city
        if (cityCount >= 30) {
            System.out.println("City limit exceeded");
            return;
        }
        System.out.print("Enter the city name:");
        String newCityName=input.nextLine();
        cities[cityCount]=newCityName;
        cityCount++; //increasing counter
        
        System.out.println("New city "+newCityName+" added");
        
    }
    
    static void renamecity(){  //renameing a city
        if (cityCount == 0) {  //checking whether if there are cities to rename
            System.out.println("No cities added yet");
            return;
        }
        
        for (int i = 0; i < cityCount; i++) {
            System.out.println(i + ") " + cities[i]); //List of the cities
        }
        
        System.out.print("Enter index of the city to rename: ");
        int index = input.nextInt();
        input.nextLine();
        
        if (index >= 0 && index < cityCount) {
            System.out.print("Enter new city name: ");
            cities[index] = input.nextLine(); //storing renamed city
            System.out.println(" City having index "+index+ " renamed to "+ cities[index]);
        }    
        else {
            System.out.println("Invalid city index");
        }
        
    }
    
    
    static void removecity(){ //removeing a city
        if (cityCount == 0) { //checking whther is there any cities added to remove
            System.out.println("No cities added yet");
            return;
        }
        
        for (int i = 0; i < cityCount; i++) {
            System.out.println(i + " " + cities[i]); //List of the cities
            
        }
        
        System.out.print("Enter index of the city to remove:");
        int index = input.nextInt();
        
        if (index >= 0 && index < cityCount) {
            String removedCity = cities[index];
            
            for (int i = index; i < cityCount - 1; i++) {  //shifting cities to the left after removing relavant city
                cities[i] = cities[i +1];
            }
            cityCount--;  //decreasing city counter
            System.out.println(removedCity+" city removed");
        } 
        else {
            System.out.println("Invalid city index");
        }
    } 
    
    //Distance management
    static void manageDistances(){
        if (cityCount < 2) { //checking whether there at least two cities to measure distance
            System.out.println("There is no at least 2 cities to measure distance");
            return;
        }

        System.out.println("\n--Manage Distances--"); //Asking the requirement
        System.out.println("1. Input/edit distance");
        System.out.println("2. Show distance table");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1->enterDistance();
            case 2->showDistanceTable();
            case 3-> System.out.println("Back to main menue..");//returning to main meue
            default->System.out.println("Invalid choice");
        }
    }
    
    static void enterDistance(){
        
        for (int i = 0; i < cityCount; i++) { //city list
        System.out.println(i + ") " + cities[i]);
        }
        
        System.out.print("Enter index of city1:"); //getting start point city index
        int city1 = input.nextInt();

        System.out.print("Enter index of city2:"); //getting destination city index
        int city2 = input.nextInt();
        
        if (city1 == city2) {
        System.out.println("Distance from a city to itself must be 0");
        return;
        }
        
        System.out.print("Enter distance between two cities in km:");
        double cityDistance = input.nextDouble();
        
        distances[city1][city2] = cityDistance;//storing distances in an array
        distances[city2][city1] = cityDistance; 
        System.out.println("Distance updated....");

    }
    static void showDistanceTable(){
        if (cityCount == 0) {  //checking city count
        System.out.println("No cities added....");
        return;
        }

        System.out.println("\n--Distance table--"); //creating distance table
        System.out.print("        ");
        
        for (int i = 0; i < cityCount; i++) { 
            System.out.printf("%8s",cities[i]);
        }
        
        System.out.println();
        
        for (int i = 0; i < cityCount; i++) {  
            System.out.printf("%8s",cities[i]); //adding city names in row
                for (int j = 0; j < cityCount; j++) {
                    System.out.printf("%8.1f",distances[i][j]); // adding city distances
                }
        System.out.println();
        }
        

    }

    //Vehical management    
    static void manageVehicles(){
        System.out.println("\n--Vehicle Management--");
        System.out.println(" Vehicle type   Capacity (kg)   Rate per km (LKR)   Avg Speed (km/h)   Fuel Efficiency (km/l)");
    
        for (int i = 0; i < vehicleTypes.length; i++) { //loop through 3 vehicle types
            System.out.printf("%8s   %15d   %13d   %15d   %15d%n",vehicleTypes[i],  vehiclCcapacity [i], vehicleRate [i],vehicleAvgSpeed[i],vehicleFuelEfficiency [i]);
                     
        }         
                      
    }                  
            
              
        
                
        
    
    static void handleDeliveries(){
    }
    static void showReports(){
    }
    

}
