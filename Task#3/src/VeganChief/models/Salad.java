package VeganChief.models;

public class Salad {

    private Vegetable[] composition;
    private double fats;
    private double protein;
    private double carbs;
    private double caloric;
    private String name="Salad";

    public void addProduct(Vegetable product){
        if (composition==null){
            composition=new Vegetable[1];
            composition[0]=product;
            return;
        }
        Vegetable[] tempComposition = new Vegetable[composition.length+1];
        tempComposition[0]=product;
        System.arraycopy(composition,0,tempComposition,1,composition.length);
        composition=tempComposition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getWeight(){
        int weight = 0;
        if (composition!=null){
            for (Vegetable product:composition
                 ) {
                weight+=product.getWeight();
            }
        }
        System.out.println("Weight of this salad: "+weight +" grams.");
    }

    public Vegetable[] getComposArray(){
        if (composition==null) return null;
        Vegetable[] copyOfCompos = composition.clone();
        return copyOfCompos;
    }

    public void removeProduct(int removeIndex){
        if (composition!=null && composition.length!=0){
            int newArrayIndex=0;
            Vegetable[] tempComposition = new Vegetable[composition.length-1];

            for(int index=0;index<composition.length;index++){
                if (index!=removeIndex){
                    tempComposition[newArrayIndex]=composition[index];
                    newArrayIndex++;
                }
            }
            composition=tempComposition;
        }
    }


}
