package com.bajajtest.store.controller;

import com.bajajtest.store.model.RequestModel;
import com.bajajtest.store.model.ResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @GetMapping
    public Map<String, Object> checkApi() {
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return response;
    }

    @PostMapping
    public ResponseModel processData(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialChars = new ArrayList<>();

        int sum = 0;

        for (String item : request.getData()) {
            if (item.matches("^-?\\d+$")) {
                int num = Integer.parseInt(item);
                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
                sum += num;
            } else if (item.matches("^[a-zA-Z]+$")) {
                alphabets.add(item.toUpperCase());
            } else {
                specialChars.add(item);
            }
        }

        StringBuilder concatBuilder = new StringBuilder();
        String joinedAlphabets = String.join("", alphabets);
        char[] reversed = new StringBuilder(joinedAlphabets).reverse().toString().toCharArray();

        for (int i = 0; i < reversed.length; i++) {
            concatBuilder.append(i % 2 == 0 ? Character.toUpperCase(reversed[i]) : Character.toLowerCase(reversed[i]));
        }

        response.setIs_success(true);
        response.setUser_id("ridhiman_sabharwal_21082004");
        response.setEmail("ridhiman2184@gmail.com");
        response.setRoll_number("22BCE3082");
        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialChars);
        response.setSum(String.valueOf(sum));
        response.setConcat_string(concatBuilder.toString());

        return response;
    }
}
