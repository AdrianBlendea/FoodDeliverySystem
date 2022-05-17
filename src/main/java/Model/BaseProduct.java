package Model;

public class BaseProduct  extends MenuItem{
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;
    public BaseProduct(String title,float rating,int calories,int proteins,int fats,int sodium,int price) {

        super(title);
        this.rating=rating;
        this.calories=calories;
        this.proteins=proteins;
        this.fats=fats;
        this.sodium=sodium;
        this.price=price;
    }

    @Override
    public int computePrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + " ,pret: "+this.price+" , rating: " + this.rating + " ,calorii " + this.calories+" ,proteine: "+this.proteins + " ,grasimi: "+this.fats + " ,sodiu: " +this.sodium+"\n";
    }

    public float getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getSodium() {
        return sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
