package pic.pipic1.powerchat.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ppier on 02/03/2016.
 */
public abstract class Message implements Serializable {
    private Date sendDate;
    private User sender;

    @SuppressWarnings("unused")
    public Message(){}


    public Message(Date send_date, User user) {
        this.sender = user;
        this.sendDate = send_date;
    }

    public abstract String getMessage();

    public Date getSendDate() {
        return sendDate;
    }

    public User getSender() { return sender; }

}
