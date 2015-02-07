/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author AMore
 */
@WebService(serviceName = "PriceService")
@Stateless()
public class PriceService {

    private static final List<List<String>> ROUTE_PRICES = new ArrayList<>();

    static {
        // Source, Dest, TravelDate
        ROUTE_PRICES.add(Arrays.asList("TICKET_1", "640 kr"));
        ROUTE_PRICES.add(Arrays.asList("TICKET_2", "650 kr"));
        ROUTE_PRICES.add(Arrays.asList("TICKET_3", "660 kr"));
        ROUTE_PRICES.add(Arrays.asList("TICKET_4", "670 kr"));
        ROUTE_PRICES.add(Arrays.asList("TICKET_5", "680 kr"));
        ROUTE_PRICES.add(Arrays.asList("TICKET_6", "690 kr"));
    }

    @WebMethod(operationName = "checkPrice")
    public String checkPrice(@WebParam(name = "ticketID") String ticketID) {
        String price = "";
        
         for (List<String> route : ROUTE_PRICES) {
            if (route.get(0).equalsIgnoreCase(ticketID) ) {
                return route.get(1);
            }
        }
        
        return "Price N/A";
    }
}
