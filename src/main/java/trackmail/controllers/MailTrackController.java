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
import trackmail.data.dtos.Customer;
import trackmail.services.CustomerRepository;
import trackmail.services.MailTrackService;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Date;

/**
 * Created by burak.costu on 23.01.2017.
 */

@RestController
@RequestMapping("/i")
public class MailTrackController {
    @Autowired
    ServletContext context;
    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    @Autowired
    private CustomerRepository repository;
    @Autowired private MailTrackService mailTrackService;


    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)


    public void deneme(){
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }

    public byte[] returnImage(@PathVariable String id, Model model) throws IOException {
        //find id and track values(async)
        //return default image

        //deneme();
        mailTrackService.addTrack(id,new Date());
        Resource resource = resourceLoader.getResource("classpath:empty.jpg");
        return IOUtils.toByteArray(resource.getInputStream());

    }

    @RequestMapping(path="/",method = RequestMethod.GET)
    public String hello(){
        return "default";
    }

}
