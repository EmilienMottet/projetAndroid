package pic.pipic1.powerchat.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emimo on 02/03/2016.
 */
public class Sujet implements Serializable{
    private String titre;
    private String description;
    private ArrayList<Message> messages;

    public Sujet(String titre, String description) {
        this.titre = titre;
        this.description = description;
        messages = new ArrayList<>();
    }

    public Sujet() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public void addMessages(List<Message> message){
        messages.addAll(message);
    }

    public ArrayList<Message> getMessages(){
        return messages;
    }
    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }
}
