package me.techtide.donotstarve;

/**
 * Created by Greenie on 19/12/2016.
 */
public class Food {
    private String name;
    private double price;
    private int calories;
    private boolean mHiddenForRound;

    public Food(String name, int calories, double price, boolean hiddenForRound)
    {
        this.setName(name);
        this.setPrice(price);
        this.setCalories(calories);
        this.setHiddenForRound(mHiddenForRound);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Boolean getHiddenForRound() {
        return mHiddenForRound;
    }

    public void setHiddenForRound(Boolean hiddenForRound) {
        this.mHiddenForRound = hiddenForRound;
    }
}
