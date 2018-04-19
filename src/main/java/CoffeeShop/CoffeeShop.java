package CoffeeShop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CoffeeShop {
    public static void main(String[] args) {
        report();
    }

    String priceFile = "Coffe_price.txt";
    String salesFile = "Coffee_sales.txt";

    public static void report() {

    }

    ArrayList readFils = ReadCoffeeFiles(priceFile, salesFile);
    ArrayList DrinkObjects =convert_to_list(readFils);








        public ArrayList ReadCoffeeFiles(String priceFile,String salesFile){
            ArrayList<String>readFils=new ArrayList<>();
            try{ BufferedReader reader = new BufferedReader(new FileReader(priceFile));
                 BufferedReader reader2 = new BufferedReader(new FileReader(priceFile));

                String line = reader.readLine();
                String line2 = reader.readLine();
                String lines=line+line2;

                while (line != null) {
                    readFils.add(lines);
                    System.out.println(lines);
                    line = reader.readLine();
                    line2 = reader.readLine();
                }
                reader.close();
                reader2.close();
                return readFils;

            }
        catch(IOException ioe){
            System.err.print(ioe);

        }return null;
    }
        public ArrayList convert_to_list(ArrayList   readFils){



        return DrinkObjects;}



}

