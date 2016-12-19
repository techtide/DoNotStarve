package me.techtide.donotstarve;

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
    public static List<Food> mFoodOptions = new ArrayList<Food>();

    public static void main(String[] args) {
        // Print statistics derived from other classes.
        PrintStatistics(mDayNumber, CalculateCaloriesLeft(CALORIES_NECESSARY, mCurrentCalories));

        // Add some food.
        Food bakedBeans = new Food("Baked Beans", 150, 2.50);
        mFoodOptions.add(0, bakedBeans);
        Food mushroomSoup = new Food("Mushroom Soup", 107, 2.50);
        mFoodOptions.add(1, mushroomSoup);
        Food oreos = new Food("Oreos x6", 270, 1.50);
        mFoodOptions.add(0, oreos);

        PrintFoodOptions();
    }

    public static void PrintStatistics(Integer dayNumber, Integer caloriesLeft) {
        System.out.print("Day: " + dayNumber);  // Print the amount of days lived to without dying of starvation.
        AddSpacing(50);
        System.out.print("Calories Used: " + caloriesLeft);   // Print the amount of calories used.
        AddSpacing(50);
        System.out.print("Money Left: $" + mMoney);
        System.out.println("");
    }

    public static int CalculateCaloriesLeft(Integer caloriesNeeded, Integer currentCalories) {
        return caloriesNeeded - currentCalories;    // Calculate the amount of calories left.
    }

    public static void PrintFoodOptions () {
        System.out.println("");
        for (int i = 0; i < mFoodOptions.size(); i++) {
            int option = i+1;
            System.out.print("Option: " + option);
            AddSpacing(10);
            System.out.print("Name: " + mFoodOptions.get(i).getName());
            AddSpacing(20);
            System.out.print("Calories: " + mFoodOptions.get(i).getCalories());
            AddSpacing(30);
            System.out.print("Price: $" + mFoodOptions.get(i).getPrice());
            System.out.println("");
        }
    }

    public static void AddSpacing(int spacing) {
        for(int i = 0; i <= spacing; i++) {
            System.out.print(" ");  // Add spacing depending on screen size;
            // method needs to be made which gets the console strech size.
        }
    }
}