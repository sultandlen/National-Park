import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NationalPark {

    public static boolean isBigger(NP nationalPark){ // true if area is bigger than 15000
        int area = nationalPark.getArea();
        return (area >= 15000);
    }

    public static void printToTheScreen(List<NP> classifiedList){ //prints all the list
        for (NP nationalPark : classifiedList) {
            System.out.println(nationalPark.toString());
        }
    }

    public static int calculateSumOfAreas(List<NP> classifiedList){ // calculate sum of all park's areas
        int totalArea = 0;
        for (NP np : classifiedList) {
            totalArea += np.getArea();
        }
        return totalArea;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".\\nat.data");
        Scanner sc = new Scanner(file);

        List<NP>[] classified = new ArrayList[2];
        classified[0] = new ArrayList<>(); // biggest parks
        classified[1] = new ArrayList<>(); //smallest parks

        while (sc.hasNextLine()) { // read file from txt, classify parks according to their areas
            String line = sc.nextLine();
            String[] splitted = line.split(",");

            String parkName = splitted[0];
            int area = Integer.parseInt(splitted[1].trim());
            String listingDate = splitted[2].trim();
            String locationsArray = splitted[3].trim();
            String[] splittedLocations = locationsArray.split(" ");
            ArrayList<String> locations = new ArrayList<>();
            for (int i = 0; i < splittedLocations.length; i++){
                locations.add(splittedLocations[i]);
            }
            NP nationalPark = new NP(parkName, area, listingDate, locations);

            if(isBigger(nationalPark)){
                classified[0].add(nationalPark);
            }else{
                classified[1].add(nationalPark);
            }
        }

        System.out.println("National parks bigger than 15000");
        printToTheScreen(classified[0]);
        System.out.println("\nNational parks smaller than 15000");
        printToTheScreen(classified[1]);
        int sumOfSmallAreas = calculateSumOfAreas(classified[0]);
        System.out.println("Sum of small national parks's areas: " + sumOfSmallAreas);
        int sumOfBigAreas = calculateSumOfAreas(classified[1]);
        System.out.println("Sum of big national parks's areas: " + sumOfBigAreas + "\n");


        int size1 = classified[0].size();
        int size2 = classified[1].size();
        int totalSize = size1 + size2;
        NP[] nationalParks  = new NP[totalSize];


        //inserting 2 list to 1 list, (big parks come first)
        for (int i = 0; i < size1; i++){
            nationalParks[i] = classified[0].get(i);
        }

        for (int i = size1; i < totalSize; i++){
            nationalParks[i] = classified[1].get(i-size1);
        }



        //STACK
        System.out.println("\n---STACK---");
        Stack stack = new Stack(totalSize);
        for (int i = 0; i < totalSize; i++){
            stack.push(nationalParks[i]);
        }

        for (int i = 0; i < totalSize; i++){
            System.out.println("Popped Item:\n" + stack.pop());
        }




        //QUEUE
        System.out.println("\n---QUEUE---");
        Queue queue = new Queue(totalSize);
        for (int i = 0; i < totalSize; i++){
            queue.insert(nationalParks[i]);
        }

        for (int i = 0; i < totalSize; i++){
            System.out.println("Removed Item:\n" + queue.remove());
        }




        //PRIORITY QUEUE
        System.out.println("---PRIORITY QUEUE---");
        PriorityQueue priorityQueue = new PriorityQueue(totalSize);
        for (int i = 0; i < totalSize; i++){
            priorityQueue.insert(nationalParks[i]);
        }

        for (int i = 0; i < totalSize; i++){
            System.out.println("Removed Item:\n" + priorityQueue.remove());
        }
    }
}