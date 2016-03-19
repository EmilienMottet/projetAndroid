package pic.pipic1.powerchat.Model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by emimo on 17/03/2016.
 */
public class MessageTextSimple {
    private String name;
    private String text;
    private String uid;
    private Date date;

    public MessageTextSimple() {
    }

    public MessageTextSimple(String name, String uid, String message) {
        this.name = name;
        this.text = message;
        this.uid = uid;
        this.date = Calendar.getInstance().getTime();
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}