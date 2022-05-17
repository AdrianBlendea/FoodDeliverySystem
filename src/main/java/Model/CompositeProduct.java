package Model;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    private ArrayList<BaseProduct> products;
    private float averageRating;
    private int totalCalories;
    private int totalProteins;
    private int totalFats;
    private int totalSodium;
    private int totalPrice;

    public CompositeProduct(String name)
    {
        super(name);
        this.products=new ArrayList<BaseProduct>();
    }


    public int computeAverageRating() {
            int ratingSum = 0;
            int nr=0;
            for (BaseProduct b:products)
            {
                nr++;
                ratingSum+=b.getRating();
            }
            return ratingSum/nr;
    }


    public int computePrice() {
        int price = 0;

        for (BaseProduct b:products)
        {
            price+=b.computePrice();
        }
        return price;
    }

    public int computeCalories() {
        int calories = 0;

        for (BaseProduct b:products)
        {
            calories+=b.getCalories();
        }
        return calories;
    }


    public int computeProteins() {
        int proteins = 0;

        for (BaseProduct b:products)
        {
            proteins+=b.getProteins();
        }
        return proteins;
    }

    public int computeFats() {
        int fats = 0;

        for (BaseProduct b:products)
        {
           fats+=b.getFats();
        }
        return fats;
    }

    public int computeSodium() {
        int sodium = 0;

        for (BaseProduct b:products)
        {
            sodium+=b.getFats();
        }
        return sodium;
    }

    public ArrayList<BaseProduct> getProducts() {
        return products;
    }

    @Override
    public String toString() {
      String s="";

      s+=super.toString()+ " " ;
      for(BaseProduct b:products)
      {
          s+=b.toString();
      }
      s+="Pret total " + this.computePrice() + " ";
        s+=" Medie Rating " + this.computeAverageRating() + " ";
        s+=" Calorii totale " + this.computeCalories() + " ";
        s+=" Proteine totale " + this.computeProteins() + " ";
        s+=" Grasimi Totale " + this.computeFats() + " ";
        s+=" Sodiu total " + this.computeSodium() + " ";


      return s;
    }
}
