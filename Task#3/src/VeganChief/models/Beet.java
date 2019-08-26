package VeganChief.models;

import VeganChief.constants.VegetableData;

public class Beet extends Root {
    public Beet(int weight) {
        super(VegetableData.BEET_FATS, VegetableData.BEET_PROTEINS, VegetableData.BEET_CARBS, VegetableData.BEET_CALORIC, weight);
    }

    @Override
    public String getVegetableName() {
        return "Beet";
    }
}
