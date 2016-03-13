package pic.pipic1.powerchat.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ppier on 02/03/2016.
 */
public abstract class Message implements Serializable {
    private Date sendDate;
    private String uid;

    @SuppressWarnings("unused")
    public Message(){}


    public Message(Date send_date) {
        this.uid = "";
        this.sendDate = send_date;
    }

    public abstract String getMessage();

    public Date getSendDate() {
        return sendDate;
    }

    public String getUid() { return uid; }

}
