package VeganChief.models;

import VeganChief.constants.VegetableData;

public class Celery extends Root {
    public Celery(Integer weight) {
        super(VegetableData.SELERY_FATS, VegetableData.SELERY_PROTEINS, VegetableData.SELERY_CARBS, VegetableData.SELERY_CALORIC, weight);
    }

    @Override
    public String getVegetableName() {
        return "Selery";
    }
}
