package CoffeeShop;

import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Objects;

public class Drink {


    private String  name;
    private  double price;
    private  double overHead;
    private  double amountSold;
    private ArrayList<Drink>DrinkObjects=new ArrayList<>();

    Drink(String name,double price,double overHead,double amountSold){
        this.name=name;
        this.price=price;
        this.overHead=overHead;
        this.amountSold=amountSold ;
 }

    public double calculateProfit(double price,double overhead){
        return this.price-this.overHead;
    }
    public double calculateTotalDrinkProfit(double sold,double price,double overhead){
        return  (this.price-this.overHead)*this.amountSold;
    }
    public double calculateRevenue(double price,double sold){
        return this.price*this.amountSold;
    }
    public double calculateSingleDrinkSoldOverhead(double sold ,double overhead){
        return this.amountSold *this.overHead;
    }

    public ArrayList<Drink> getDrinkObjects() {
        return DrinkObjects;
    }

    public void setDrinkObjects(ArrayList<Drink> drinkObjects) {
        DrinkObjects = drinkObjects;
    }
}



