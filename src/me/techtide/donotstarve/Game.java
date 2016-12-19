package me.techtide.donotstarve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Greenie on 19/12/2016.
 */

public class Game {

    public static Integer mDayNumber = 1;
    public static Integer mCurrentCalories = 0;
    public static final Integer CALORIES_NECESSARY = 1500;
    public static Integer mMoney = 100;
    private static Integer mSelectedFoodChoice;
    private static Integer mDayCourseNumber = 1;

    public static List<Food> mFoodOptions = new ArrayList<Food>();

    public static void main(String[] args) {
        // Print statistics derived from other classes.
        printStatistics(mDayNumber, calculateCaloriesLeft(CALORIES_NECESSARY, mCurrentCalories), mDayCourseNumber);

        // Add some food.
        Food bakedBeans = new Food("Baked Beans", 150, 2.50, false);
        mFoodOptions.add(0, bakedBeans);
        Food mushroomSoup = new Food("Mushroom Soup", 107, 2.50, false);
        mFoodOptions.add(1, mushroomSoup);
        Food oreos = new Food("Oreos x6", 270, 1.50, false);
        mFoodOptions.add(0, oreos);

        if (mDayCourseNumber <= 3) {
            handleFoodPrompt();
        } else {
            mDayNumber++;
            updateStatistics();
        }
    }

    public static void handleFoodPrompt() {
        // Print the food available.
        printFoodOptions();

        // Prompt the user for a choice of food.
        try {
            promptUser("Which option of food would you like to use, keeping in mind your constraints?");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mCurrentCalories = mFoodOptions.get(mSelectedFoodChoice - 1).getCalories(); // set used calories
        mFoodOptions.remove(mSelectedFoodChoice);
        mDayCourseNumber++;
        updateStatistics();
    }

    public static void updateStatistics() {
        printStatistics(mDayNumber, calculateCaloriesLeft(CALORIES_NECESSARY, mCurrentCalories), mDayCourseNumber);
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printStatistics(Integer dayNumber, Integer caloriesLeft, Integer courseNumber) {
        System.out.print("Day: " + dayNumber);  // Print the amount of days lived to without dying of starvation.
        addSpacing(25);
        System.out.print("Calories Used: " + caloriesLeft);   // Print the amount of calories used.
        addSpacing(25);
        System.out.print("Money Left: $" + mMoney);
        addSpacing(25);
        System.out.print("Meal Number: " + courseNumber);
        System.out.println("");
    }

    public static int calculateCaloriesLeft(Integer caloriesNeeded, Integer currentCalories) {
        return caloriesNeeded - currentCalories;    // Calculate the amount of calories left.
    }

    public static void printFoodOptions () {
        System.out.println("");
        for (int i = 0; i < mFoodOptions.size(); i++) {
            int option = i+1;
            System.out.print("Option: " + option);
            addSpacing(10);
            System.out.print("Name: " + mFoodOptions.get(i).getName());
            addSpacing(20);
            System.out.print("Calories: " + mFoodOptions.get(i).getCalories());
            addSpacing(30);
            System.out.print("Price: $" + mFoodOptions.get(i).getPrice());
            System.out.println("");
        }
    }

    public static void promptUser(String question) throws IOException{   // Prompt the user for an integer.
        System.out.println("\033[3mAll prompts are answered by numpad (i.e, '1,' but not 'one') inputs.\033[0m");
        System.out.println(question);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mSelectedFoodChoice = Integer.parseInt(reader.readLine()); // Perhaps add support for written numbers, but later on.
    }

    public static void addSpacing(int spacing) {
        for(int i = 0; i <= spacing; i++) {
            System.out.print(" ");  // Add spacing depending on screen size;
            // method needs to be made which gets the console strech size.
        }
    }
}