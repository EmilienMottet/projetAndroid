package pic.pipic1.powerchat.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ppier on 02/03/2016.
 */
public abstract class Message implements Serializable {
    private Date sendDate;
    private String uid;
    private String author;

    public Message(){}

    public Message(Date send_date, String uid, String author) {
        this.uid = uid;
        this.author = author;
        this.sendDate = send_date;
    }

    public abstract String getMessage();

    public Date getSendDate() {
        return sendDate;
    }

    public String getUid() { return uid; }

}
