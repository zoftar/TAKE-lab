/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Zosia
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String count = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints/count")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println("Count: " + count);
        
        String all = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        System.out.println("All complaints:\n" + all);
        
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            List<Complaint> allComplaints = mapper.readValue(all,mapper.getTypeFactory()
      .constructCollectionType(List.class, Complaint.class));
            Optional<Complaint> optional = allComplaints.stream().filter(c -> {
                return "open".equals(c.getStatus());
            }).findFirst();
            
            if (optional.isPresent()) {
                Integer c = optional.get().getId();
                
                String one = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints/"+c.toString())
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
                System.out.println("One of the open complaints:\n" + one);
                
                Complaint complaint = mapper.readValue(one, Complaint.class);
                complaint.setStatus("closed");
                client.target("http://localhost:8080/Complaints/"
                + "resources/complaints/"+complaint.getId().toString())
                .request()
                .put(Entity.json(mapper.writeValueAsString(complaint)));
            } else {
                Logger.getLogger(Main.class.getName()).log(Level.WARNING, "No open complaints");
            }
            
           
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        String open = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        System.out.println("All open complaints now:\n" + open);
        

        client.close();

    }

}
