package pic.pipic1.powerchat.Model;

import java.io.Serializable;

/**
 * Created by emimo on 02/03/2016.
 */
public class Sujet implements Serializable{
    private String titre;
    private String description;

    public Sujet(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Sujet() {
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }
}
