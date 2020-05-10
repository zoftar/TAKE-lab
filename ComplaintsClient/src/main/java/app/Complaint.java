/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author Zosia
 */
public class Complaint implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("complaintDate")
    private String complaintDate;

    @JsonProperty("complaintText")
    private String complaintText;

    @JsonProperty("author")
    private String author;

    @JsonProperty("status")
    private String status;

    public Complaint(Integer id, String complaintDate, String complaintText, String author, String status) {
        this.id = id;
        this.complaintDate = complaintDate;
        this.complaintText = complaintText;
        this.author = author;
        this.status = status;
    }
    public Complaint() {}
    
 @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

     @JsonProperty("status")
    public String getStatus() {
        return status;
    }
@JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
        public void setId(Integer id) {
        this.id = id;
    }
 @JsonProperty("complaintDate")
    public String getComplaintDate() {
        return complaintDate;
    }
 @JsonProperty("complaintDate")
    public void setComplaintDate(String complaintDate) {
        this.complaintDate = complaintDate;
    }
 @JsonProperty("complaintText")
    public String getComplaintText() {
        return complaintText;
    }
 @JsonProperty("complaintText")
    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }
@JsonProperty("author")
    public String getAuthor() {
        return author;
    }
@JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }


    
    
    
    
    
    
}
