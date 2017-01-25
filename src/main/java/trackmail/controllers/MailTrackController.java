package trackmail.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import trackmail.services.MailTrackService;
import java.io.IOException;
import java.util.Date;

/**
 * Created by burak.costu on 23.01.2017.
 */

@RestController
@RequestMapping("/i")
public class MailTrackController {
    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    @Autowired private MailTrackService mailTrackService;


    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] returnImage(@PathVariable String id, Model model) throws IOException {
        mailTrackService.addTrack(id,new Date());
        Resource resource = resourceLoader.getResource("classpath:empty.jpg");
        return IOUtils.toByteArray(resource.getInputStream());
    }

    @RequestMapping(path="/",method = RequestMethod.GET)
    public String hello(){
        return "default";
    }

}
