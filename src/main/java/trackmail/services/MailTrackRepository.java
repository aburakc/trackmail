package trackmail.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import trackmail.data.dtos.Mail;

import java.util.List;

/**
 * Created by burak.costu on 25.01.2017.
 */
public interface MailTrackRepository extends MongoRepository<Mail, String>{
    public List<Mail> findByIdFirstName(String id);
}
