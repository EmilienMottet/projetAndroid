package pic.pipic1.powerchat.Model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ppier on 02/03/2016.
 */
public class MessageText extends Message {
    private String message;

    public MessageText(String message, Date sendDate) {
        super(Calendar.getInstance().getTime());
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}