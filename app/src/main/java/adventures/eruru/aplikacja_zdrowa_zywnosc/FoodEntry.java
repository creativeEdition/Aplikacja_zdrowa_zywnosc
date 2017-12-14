package adventures.eruru.aplikacja_zdrowa_zywnosc;


public class FoodEntry {


    Double[] ingredients;
    Boolean eatable;

    public FoodEntry(Double[] ingredients, Boolean eatable) {

        this.ingredients = ingredients;
        this.eatable = eatable;

    }

    public Double[] getIngredients() {

        return ingredients;
    }

    public void setIngredients(Double[] ingredients) {

        this.ingredients = ingredients;
    }

    public Boolean getEatable() {

        return eatable;
    }

    public void setEatable(Boolean eatable) {

        this.eatable = eatable;
    }
}
