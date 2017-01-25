package trackmail.data.dtos;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by burak.costu on 24.01.2017.
 */
public class Mail {
    @Id
    String id;

    String mailId;
    Date time;

    public Mail(String mailId, Date time){
        this.mailId = mailId;
        this.time = time;
    }
    @Override
    public String toString() {
        return String.format(
                "Mail[id=%s, time='%s']",
                mailId, time);
    }

}
