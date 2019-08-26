package VeganChief.models;

public abstract class Root extends Vegetable implements Friedable, Cookable {
    private boolean isCooked=false;
    private boolean isFried=false;

    public Root(double fats, double protein, double carbs, double caloric, int weight) {
        super(fats, protein, carbs, caloric, weight);
    }

    public void roast(){
        isFried=true;
    }
    public void cook(){
        isCooked=true;
    }

    public boolean isCooked() {
        return isCooked;
    }

    public boolean isFried() {
        return isFried;
    }

}
