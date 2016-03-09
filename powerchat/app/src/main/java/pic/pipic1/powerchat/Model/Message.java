package pic.pipic1.powerchat.Model;

import java.util.Date;

/**
 * Created by ppier on 02/03/2016.
 */
public abstract class Message {
    private Date sendDate;
    private User sender;

    @SuppressWarnings("unused")
    protected Message(){}


    public Message(Date send_date, User user) {
        this.sender = user;
        this.sendDate = send_date;
    }

    private Message(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public User getSender() { return sender; }

}
