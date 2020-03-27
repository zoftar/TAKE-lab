/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

/**
 *
 * @author Zosia
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {
    
    @Inject
    private RequestFacadeLocal requestFacade;
    
    private String newRequest;
    
    private HtmlDataTable requestsDataTable;

    /**
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
        
    }
    
    public List<Request> getAllRequests() {
        return this.requestFacade.findAll();
    }
    
    public String addRequest() {
        Request request = new Request();
        request.setRequestDate(LocalDate.now());
        request.setRequestText(this.newRequest);
        this.requestFacade.create(request);
        return null;
    }
    
    public String deleteRequest() {
 Request req = (Request) getRequestsDataTable().getRowData();
 this.requestFacade.remove(req);
 return null;
 }
    


    /**
     * Get the value of requestsDataTable
     *
     * @return the value of requestsDataTable
     */
    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    /**
     * Set the value of requestsDataTable
     *
     * @param requestsDataTable new value of requestsDataTable
     */
    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    

    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    
}
