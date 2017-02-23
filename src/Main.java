/**
 * Created by Shawn on 2/23/2017.
 */
import java.util.Random;
import java.util.Scanner;
import java.sql.Date;
import java.time.*;


public class Main {

    //Create scanner object to select parameters for input;
    Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int userID;
        int habitID;
        Date date;
        int numRecords;
        int days;
        double packsDay;

        Random rnd = new Random();

        System.out.println("Enter userID");
        userID = keyboard.nextInt();
        System.out.println("Enter habitID");
        habitID = keyboard.nextInt();
        System.out.println("Enter number of packs a  day ?");
        packsDay = keyboard.nextDouble();
        System.out.println("Enter how many days to create records for?");
        days = keyboard.nextInt();

        numRecords = (int)((packsDay*20) * days);

        System.out.println("Generating " + numRecords + " records of user " + userID + " with habit of " + habitID + ".");



        if (habitID == 1) {
            for( int i = 0; i < numRecords; i++){
                int hours = rnd.nextInt(17)+ 8;
                int daysBack = rnd.nextInt((days)+1);
                int minsBack = rnd.nextInt((60)+1);
                int secondsBack = rnd.nextInt((60)+1);
                System.out.println("INSERT INTO track_habits");
                System.out.println("VALUES (" + userID + ", " + habitID + ", '" +
                LocalDateTime.now().minusDays(daysBack).minusHours(hours).minusMinutes(minsBack).minusSeconds(secondsBack) + "');" );
            }
        }
    }

}
