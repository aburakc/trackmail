package trackmail.services;

import java.util.Date;

/**
 * Created by burak.costu on 24.01.2017.
 */
public interface MailTrackService {
    void addTrack(String id, Date currentDate);
}
