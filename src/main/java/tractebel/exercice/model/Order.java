package tractebel.exercice.model;

import javax.persistence.*;

/**
 * Created by Dell on 28/09/2017.
 */
@Table(name ="team1_order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="favorite_pizza")
    private String favorite;

    @Column(name="favorite_store")
    private String store;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
