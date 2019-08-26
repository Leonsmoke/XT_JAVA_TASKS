package VeganChief.models;

import VeganChief.constants.VegetableData;

public class Potato extends Tuber {
    public Potato(int weight) {
        super(VegetableData.POTATO_FATS, VegetableData.POTATO_PROTEINS, VegetableData.POTATO_CARBS, VegetableData.POTATO_CALORIC, weight);
    }

    @Override
    public String getVegetableName() {
        return "Potato";
    }
}
