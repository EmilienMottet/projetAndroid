package pic.pipic1.powerchat.Model;

import java.util.Date;

/**
 * Created by ppier on 02/03/2016.
 */
public abstract class Message {
    private Date sendDate;
    private User sender;
    private long id;

    public Message(long id, Date sendDate) {
        this.id = id;
        this.sendDate = sendDate;
    }

    public Message(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public boolean isMe(){
        //Obtenir l'utilisateur connécté
        return false;
    }
}
