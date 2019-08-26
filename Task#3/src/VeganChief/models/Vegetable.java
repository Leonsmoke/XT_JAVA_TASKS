package VeganChief.models;

import java.util.Comparator;

public abstract class Vegetable implements Cloneable{
    private double fats;
    private double protein;
    private double carbs;
    private double caloric;
    private int weight;
    public Vegetable(double fats, double protein, double carbs, double caloric, int weight) {
        this.fats = fats;
        this.protein = protein;
        this.carbs = carbs;
        this.caloric = caloric;
        this.weight = weight;
    }

    public double getFats() {
        return fats;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getCaloric() {
        return caloric;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void addToSalad(Salad salad, int weight, String className){
        try{
            Vegetable productToAdd = this.clone();
            productToAdd.setWeight(weight);
            salad.addProduct(productToAdd);
        } catch (Exception e){
            System.err.println(e);
        }
    }

    public abstract String getVegetableName();

    public final String toString(){
        return getVegetableName() + ". in 100 grams: Fats="+ getFats() +
                " Protein=" + getProtein() + " Carbs=" + getCarbs() +
                " Caloric=" + getCaloric();
    }

    public static Comparator<Vegetable> fatsComporator = new Comparator<Vegetable>() {
        @Override
        public int compare(Vegetable veg1, Vegetable veg2) {
            return (int)((veg1.getFats()*1000)-(veg2.getFats()*1000));
        }
    };

    public static Comparator<Vegetable> proteinComporator = new Comparator<Vegetable>() {
        @Override
        public int compare(Vegetable veg1, Vegetable veg2) {
            return (int)((veg1.getProtein()*1000)-(veg2.getProtein()*1000));
        }
    };

    public static Comparator<Vegetable> carbsComporator = new Comparator<Vegetable>() {
        @Override
        public int compare(Vegetable veg1, Vegetable veg2) {
            return (int)((veg1.getCarbs()*1000)-(veg2.getCarbs()*1000));
        }
    };

    public static Comparator<Vegetable> caloricComporator = new Comparator<Vegetable>() {
        @Override
        public int compare(Vegetable veg1, Vegetable veg2) {
            return (int)((veg1.getCaloric()*1000)-(veg2.getCaloric()*1000));
        }
    };

    public Vegetable clone() throws CloneNotSupportedException{
        return (Vegetable)super.clone();
    }

}
