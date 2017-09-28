package tractebel.exercice.dto;

/**
 * Created by Dell on 28/09/2017.
 */
public class FavoritePizzaDTO {

    private Long id;

    private String favoritePizza;

    private String store;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFavoritePizza() {
        return favoritePizza;
    }

    public void setFavoritePizza(String favoritePizza) {
        this.favoritePizza = favoritePizza;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
