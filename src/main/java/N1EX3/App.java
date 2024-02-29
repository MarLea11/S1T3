package N1EX3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class App {

    private App() {}

    public static void runProgram() {

        // 1. Creating a HashMap and a new file name to work with later

        HashMap<String, String> mapCountry = new HashMap<>();
        String fileRanking = "src/main/java/N1EX3/txt/Ranking.txt";

        // Reading the file and adding information to the HashMap calling a method
        readFile(mapCountry);

        // 2. Ask the user data calling a method
        System.out.println("Hello, in this game you will have to guess the capital of the country that pops up");
        String userName = askString("Please, write your name: ");

        String randomCountry;
        String actualCapital;
        String userCapital;
        int userScore = 0;

        for(int i = 0; i < 10; i++) {
            randomCountry = getRandomCountry(mapCountry);
            actualCapital = mapCountry.get(randomCountry);
            userCapital = askString("Now, write the capital of: " + randomCountry);
            if (actualCapital.equalsIgnoreCase(userCapital)) {
                System.out.println("Congratulations, you have 1 point");
                userScore++;
            } else {
                System.out.println("Incorrect, " + userName + ". The correct capital of " + randomCountry +
                                        " is " + actualCapital);
            }
        }

        System.out.println("End of the game " + userName + ". Your score is " + userScore);

        writeFile(fileRanking, userName, userScore);

    }

    public static String getRandomCountry(HashMap<String, String> mapCountry){
        Random random = new Random();
        int randomIndex = random.nextInt(mapCountry.size());
        return (String) mapCountry.keySet().toArray()[randomIndex];
    }

    public static void readFile(HashMap<String, String> mapCountry) {

        try (FileReader file = new FileReader("src/main/java/N1EX3/txt/countries.txt")) {
            BufferedReader reader = new BufferedReader(file);
            String chain;
            while ((chain = reader.readLine()) != null) {
                String[] parts = chain.split(" "); // Split of chain using a space
                if (parts.length == 2) {
                    mapCountry.put(parts[0].trim(), parts[1].trim()); // Add key value
                } else {
                    System.out.println("Invalid line format: " + chain);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void writeFile(String fileRanking, String userName, int userScore) {

        try(FileWriter writer = new FileWriter(fileRanking, true)) {
            writer.write(userName + ", " + userScore + "\n");
            System.out.println("Your ranking has been saved");
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static String askString(String message) {

        Scanner input = new Scanner(System.in);
        System.out.println(message);

        String userValue = input.nextLine();

        return userValue;
    }

}
