package pic.pipic1.powerchat.Model;

import java.util.Date;

/**
 * Created by ppier on 02/03/2016.
 */
public abstract class Message {
    private Date sendDate;
    private boolean isMe;
    private long id;

    public Message(long id, boolean isMe, Date sendDate) {
        this.id = id;
        this.isMe = isMe;
        this.sendDate = sendDate;
    }

    public Message(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getSendDate() {
        return sendDate;
    }
}
