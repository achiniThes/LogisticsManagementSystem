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
    static int[] vehiclecapacity = {1000, 5000, 10000};     
    static int[] vehicleRate = {30, 40, 80};  //per km         
    static int[] vehicleAvgSpeed = {60, 50, 45};            
    static int[] vehicleFuelEfficiency = {12, 6, 4};    
    
    static String[] sourceCity = new String[50]; //assuming maximum deiliveries is 50
    static String[] destinationCity = new String[50];
    static double[] weight = new double[50];
    static String[] vehicletype = new String[50];
    
    
    static double[] cost = new double[50];
    static double[] time = new double[50];
    static int deliveryCount = 0;
    
    static double minimumDistance;
    static String bestPath = "";

   
    //displaying menue
    static void printMenue(){
        System.out.println("\n==============================================");
        System.out.println("     LOGISTICS MANAGEMENT SYSTEM      ");
        System.out.println("==============================================");
        System.out.println("1. Manage Cities");
        System.out.println("2. Manage Distances");
        System.out.println("3. Manage Vehicles");
        System.out.println("4. Handle Deliveries");
        System.out.println("5. Finding The Least-Cost Route (Least-Distance)");
        System.out.println("6. Reports");
        System.out.println("7. Exit");
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
                    leastCostRoute(); //calling handleDeliveries() function 
                    break;    
                case 6:
                    showReports(); //showReports() function
                    break;
                case 7:
                    saveData(); //calling handleDeliveries() function 
                    break;    
                case 8:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);    
    }        
    
    //city management
    static void manageCities(){
        int choice;
        do{
        System.out.println("\n--Manage Cities--");
        System.out.println("1.Add a city");
        System.out.println("2.Rename a city");
        System.out.println("3.Remove a city");
        System.out.println("4.Back to Main Menu");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();
        input.nextLine(); 
        
        switch (choice){
            case 1->addcity(); //caling addcity() method
            case 2->renamecity(); //caling  renamecity() method
            case 3->removecity(); //calling removecity() method 
            case 4-> System.out.println("Back to main menue..");//returning to main meue
            default->System.out.println("Invalid choice");    
                    
        }
        }while(choice!=4);
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
            System.out.println("City having index "+index+ " renamed to "+ cities[index]);
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
        int choice;
        do{
        System.out.println("\n--Manage Distances--"); //Asking the requirement
        System.out.println("1. Input/edit distance");
        System.out.println("2. Show distance table");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();
        

        switch (choice) {
            case 1->enterDistance();
            case 2->showDistanceTable();
            case 3-> System.out.println("Back to main menue..");//returning to main meue
            default->System.out.println("Invalid choice");
        }
        }while(choice!=3);
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
            System.out.printf("%8s   %15d   %13d   %15d   %15d%n",vehicleTypes[i],  vehiclecapacity [i], vehicleRate [i],vehicleAvgSpeed[i],vehicleFuelEfficiency [i]);
                     
        }         
                      
    }                  
            
              
    //Delivery Request Handling/Cost, Time, and Fuel Calculations/Delivery Records/ Finding The Least-Cost Route (Least-Distance)
    static void handleDeliveries(){
        System.out.println("--Handling Deliveries--");
        if (cityCount < 2) { //checking whether there at least two cities to measure distance
            System.out.println("There is no at least 2 cities to measure distance");
            return;
        }
        
        for (int i = 0; i < cityCount; i++) { //city list
            System.out.println(i + ") " + cities[i]);
        }
        
        System.out.print("Enter index of city1:"); //getting source city index
        int city1 = input.nextInt();

        System.out.print("Enter index of city2:"); //getting destination city index
        int city2 = input.nextInt();
        
        if (city1 == city2) {
            System.out.println("Same city entered twice");
            return;
        }
        
        System.out.print("Enter weight in kg: ");
        double w = input.nextDouble();
        
         System.out.println("\n--Vehicle types--");
         for (int i = 0; i < vehicleTypes.length; i++) {
            System.out.printf("%d. %s (Capacity: %dkg, Rate per km: %d)\n",
                (i + 1), vehicleTypes[i], vehiclecapacity[i], vehicleRate[i]);  //showing list of vehicals with there details
        }

        System.out.print("Select vehicle (1-" + vehicleTypes.length + "): ");
        int v = input.nextInt() - 1;  //selecting which vehical to carry pacakage

        if (v < 0 || v >= vehicleTypes.length) { //v-vehical index
            System.out.println("Invalid selection....");
            return;
        }

        if (w >vehiclecapacity[v]) {
            System.out.println("Weight exceeds....");
            return;
        }
        
        // Cost, Time, and Fuel Calculation
        double D = distances[city1][city2];
        double R = vehicleRate[v]; //from vehicle type
        double S = vehicleAvgSpeed[v];  //km/h
        double E = vehicleFuelEfficiency[v];
        double F=310.0; //fuel price
        
        //calculations
        double deliveryCost= D*R*(1+w/10000);
        double estimatedDeliveryTime=D/S; //hours
        double fuelConsumption=D/E;
        double fuelCost=fuelConsumption*F;
        double totalCost=deliveryCost+fuelCost;
        double profit=deliveryCost*0.25;
        double customerCharge=totalCost+profit;
        
        //Delivery records
        sourceCity[deliveryCount] = cities[city1];
        destinationCity[deliveryCount] = cities[city2];
        vehicletype[deliveryCount] = vehicleTypes[v];
        weight[deliveryCount] = w;
        cost[deliveryCount] = customerCharge;
        time[deliveryCount] = estimatedDeliveryTime;
        deliveryCount++;
        
        //summary
        System.out.println("\n===============================");
        System.out.println("     DELIVERY COST SUMMARY     ");
        System.out.println("===============================");
        System.out.println("From: " + cities[city1]);
        System.out.println("To: " + cities[city2]);
        System.out.println("Distance: "+D+" km");
        System.out.println("Vehicle: " + vehicleTypes[v]);
        System.out.println("Weight: "+w+" kg");
        System.out.println("Base Cost: "+ deliveryCost+ "LKR");
        System.out.println("Fuel Used: "+fuelConsumption+" L");
        System.out.println("Fuel Cost: "+fuelCost+" LKR");
        System.out.println("Optional Cost: "+totalCost+" LKR");
        System.out.println("Profit: "+profit+" LKR");
        System.out.println("Customer Charge: "+customerCharge+" LKR");
        System.out.println("Estimated Time: "+estimatedDeliveryTime+" hours");
        System.out.println("===============================");
        
       
    }
    
    static void leastCostRoute(){
        if (cityCount < 2) {
        System.out.println("There is no at least 2 cities");
        return;
        }

        for (int i = 0; i < cityCount; i++) { //city list
        System.out.println(i + ") " + cities[i]);
        }
        
        System.out.print("Enter source city index: ");
        int city1 = input.nextInt();
        System.out.print("Enter destination city index: ");
        int city2 = input.nextInt();

        if (city1 == city2) {
            System.out.println("Source and destination cannot be the same!are same");
        }

        boolean[] visited = new boolean[cityCount];
        visited[city1] = true;
        minimumDistance = Double.MAX_VALUE;
        bestPath = "";

        searchingRoute(city1, city2, visited, 0, cities[city1]);

        if (bestPath.isEmpty()) {
            System.out.println("No valid path found");
        } 
        else{
        System.out.println("--Least Cost Result--");
        System.out.println("                              ");
        System.out.println("Shortest Route: " + bestPath);
        System.out.printf("Total Distance: %.2f km%n", minimumDistance);
       
        }
    }


    static void searchingRoute(int current, int dest, boolean[] visited, double totalDist, String path) {
        if (current == dest) {
            if (totalDist < minimumDistance) {
                minimumDistance = totalDist;
                bestPath = path;
            }
            return;
        }

        for (int i = 0; i < cityCount; i++) {
            if (!visited[i] && distances[current][i] > 0) {
                visited[i] = true;
                searchingRoute(i, dest, visited, totalDist + distances[current][i], path + " -> " + cities[i]);
                visited[i] = false; // backtrack
            }
        }
    }
        
    static void showReports(){
            
    }
    static void saveData(){
    }

}
