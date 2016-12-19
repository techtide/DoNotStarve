package me.techtide;

public class GameManager {
    public static Integer mDayNumber = 1;
    public static Integer mCurrentCalories = 0;
    public static final Integer CALORIES_NECESSARY = 1500;
    private static Integer mSpacing = 75;

    public static void main(String[] args) {
        // Print statistics derived from other classes.
        PrintStatistics(mDayNumber, CalculateCaloriesLeft(CALORIES_NECESSARY, mCurrentCalories), mSpacing);
    }

    public static void PrintStatistics(Integer dayNumber, Integer caloriesLeft, Integer spacing) {
        System.out.print("Day: " + dayNumber);  // Print the amount of days lived to without dying of starvation.
        for(int i = 0; i <= spacing; i++) {
            System.out.print(" ");  // Add spacing depending on screen size;
                                    // method needs to be made which gets the console strech size.
        }
        System.out.println("Calories Used: " + caloriesLeft);   // Print the amount of calories used.
    }

    public static int CalculateCaloriesLeft(Integer caloriesNeeded, Integer currentCalories) {
        return caloriesNeeded - currentCalories;    // Calculate the amount of calories left.
    }
}