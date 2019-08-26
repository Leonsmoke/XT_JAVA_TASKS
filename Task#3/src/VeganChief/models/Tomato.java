package VeganChief.models;

import VeganChief.constants.VegetableData;

public class Tomato extends Tomatos {
    public Tomato(int weight) {
        super(VegetableData.TOMATO_FATS, VegetableData.TOMATO_PROTEINS, VegetableData.TOMATO_CARBS, VegetableData.TOMATO_CALORIC, weight);
    }

    @Override
    public String getVegetableName() {
        return "Tomato";
    }
}
