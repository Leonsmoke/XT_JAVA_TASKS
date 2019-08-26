package VeganChief.models;

import VeganChief.constants.VegetableData;

public class Carrot extends Root {

    public Carrot(int weight) {
        super(VegetableData.CARROT_FATS, VegetableData.CARROT_PROTEINS, VegetableData.CARROT_CARBS, VegetableData.CARROT_CALORIC, weight);
    }

    @Override
    public String getVegetableName() {
        return "Carrot";
    }
}
