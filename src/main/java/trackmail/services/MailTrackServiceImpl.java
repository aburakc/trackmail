package trackmail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trackmail.data.Mail;

import java.util.Date;

/**
 * Created by burak.costu on 24.01.2017.
 */
@Service
public class MailTrackServiceImpl implements MailTrackService{
    @Autowired
    MailTrackRepository mailTrackRepository;

    @Override
    public void addTrack(String id, Date currentDate) {
        //find mail
        Mail inserted = mailTrackRepository.save(new Mail(id, currentDate));
    }
}
