package prac.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import prac.app.model.Employees;
import prac.app.model.Order;
import prac.app.repository.PracRepo;

@RestController
@RequestMapping("/api")
public class RestEmployeeController {
    // requires autowiring
    @Autowired
    PracRepo pracRepo;

    @GetMapping(path="/customers")
    public ResponseEntity<String> getAllEmployees(@RequestParam(required=false) int limit, @RequestParam(required = false) int offset){
        
        List<Employees> emp = pracRepo.getEmployees(limit, offset);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for(Employees e : emp)
                arrayBuilder.add(e.toJson());

            JsonArray result = arrayBuilder.build();
        
        try {        
            System.out.println("Reading OK");
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());
        }
    }

    @GetMapping(path="/customer/{employeeId}")
    public ResponseEntity<String> getSpecificEmployee(@PathVariable int employeeId){
        Employees emp = pracRepo.pickEmployeeWithId(employeeId);
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        try{
        JsonObject result = objectBuilder.add("employees", emp.toJson()).build();
           
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body("No record found");
        }
    }

    @GetMapping(path="/customer/{employeeId}/orders")
    public ResponseEntity<String> getOrderFromSpecificEmployee(@PathVariable int employeeId){
        List<Order> ord = pracRepo.pickOrderWithEmployeeId(employeeId);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for(Order o: ord)
        arrayBuilder.add(o.toJson());
        JsonArray result = arrayBuilder.build();
        if(result.size()==0){
            System.out.println("is null");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body("No record found");
        }else

        System.out.println("is not null");
        
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());

        }
    }