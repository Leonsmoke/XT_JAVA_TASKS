package VeganChief.constants;

/**
 * An interface that contains all the text of the application.
 * In this way, it is convenient to edit the text and create localization.
 */
public interface Labels {
    static final String GREETINGS = "Welcome to the Vegan Chief App!";

    static final String MAINMENU_LABEL ="Choose a number of menu:\n" +
            "1. Make a new salad\n" +
            "2. Change salad\n" +
            "0. Exit\n";

    static final String CREATEMENU_LABEL = "Salad has been created!\n";

    static final String RENAME_SALAD = "Enter new name for this salad:\n";

    static final String SALAD_IS_EMPTY = "Salad is empty";

    static final String CHANGEMENU_LABEL ="Change salad:\n" +
            "1. Change salad name\n" +
            "2. Add ingredients\n" +
            "3. Remove ingredients\n" +
            "4. Print composition\n" +
            "5. Print energy value\n" +
            "6. Print current weight\n" +
            "7. Find ingredients by filter\n" +
            "0. Back\n";

    static final String ADDINGRIDIENT_MENU_LABEL =
            "1. Show all ingredients\n" +
            "2. Show ingredients sorted by...\n" +
            "0. Back\n";

    static final String ATTENTION_WEIGHT = "Enter ingredient weight in grams (more than 10, less than 2000)";

    static final String ATTENTION_WRONG_NUMBER = "Please enter a correct number";

    static final String ADDED_SUCCESSFULLY = "Ingredient added successfully!";

    static final String SORTBY_MENU_LABEL = "Sort by.. \n" +
            "1. Fats\n" +
            "2. Protein\n" +
            "3. Carbs\n" +
            "4. Caloric\n" +
            "0. Back\n";

    static final String REMOVE_LABEL = "Enter the index of the item to be removed.";

    static final String SEARCH_FILTER_MENU = "Select filter attribute:\n" +
            "1. Fats\n" +
            "2. Protein\n" +
            "3. Carbs\n" +
            "4. Caloric\n" +
            "5. Weight\n" +
            "9. Clear filter\n" +
            "0. Cancel\n";
}
