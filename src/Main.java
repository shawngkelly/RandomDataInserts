/**
 * Created by Shawn on 2/23/2017.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.time.*;


public class Main {

    //Create scanner object to select parameters for input;



    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int userID;
        int habitID;
        int numRecords;
        int days;
        double packsDay;

        Random rnd = new Random();

        System.out.println("Enter userID");
        userID = keyboard.nextInt();
        System.out.println("Enter habitID");
        habitID = keyboard.nextInt();
        if (habitID == 1) {
            System.out.println("Enter number of packs a  day ?");
            packsDay = keyboard.nextDouble();
            System.out.println("Enter how many days to create records for?");
            days = keyboard.nextInt();
            numRecords = (int)((packsDay*20) * days);
        }
        else if (habitID == 2) {
            System.out.println("Enter number of dip cans a day");
            double cans = keyboard.nextDouble();
            System.out.println("How many days of records?");
            days = keyboard.nextInt();
            numRecords = (int)((cans*5)* days);
        }
        else if (habitID == 3) {
            System.out.println("How many drinks per sitting?");
            int drinks = keyboard.nextInt();
            System.out.println("How many nights do you drink");
            days = keyboard.nextInt();
            numRecords = (drinks * days);
        }
        else if (habitID == 4) {
            System.out.println("How many drinks per day?");
            int drinks = keyboard.nextInt();
            System.out.println("how many days do you drink?");
            days = keyboard.nextInt();
            numRecords = (drinks * days);
        }
        else {
            return;
        }

        System.out.println("Generating " + numRecords + " records of user " + userID + " with habit of " + habitID + ".");
        FileWriter outPutFile = new FileWriter("trial.txt", true);

        for( int i = 0; i < numRecords; i++){
                int hours = rnd.nextInt(18)+ 12;
                int daysBack = rnd.nextInt((days)+1);
                int minsBack = rnd.nextInt((60)+1);
                int secondsBack = rnd.nextInt((60)+1);
                outPutFile.append("INSERT INTO track_habits\n");
                outPutFile.append("VALUES (" + userID + ", " + habitID + ", '" +
                LocalDateTime.now().minusDays(daysBack).plusHours(hours).minusMinutes(minsBack).minusSeconds(secondsBack) + "');\n" );
            }
        outPutFile.close();


        }
    }


