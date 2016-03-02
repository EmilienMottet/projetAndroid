package pic.pipic1.powerchat.Model;

/**
 * Created by emimo on 02/03/2016.
 */
public class Sujet {
    private String titre;
    private String description;

    public Sujet(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }
}
