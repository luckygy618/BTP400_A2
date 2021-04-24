package com.covid19app.news;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


/**
 * This class is used to test the API call.
 * @author Neil An
 *
 */
@SpringBootApplication
@RestController
public class CovidnewsmavenApplication {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException, JSONException {
        JSONObject data = GetNews.getNews();
        System.out.println(data);
		SpringApplication.run(CovidnewsmavenApplication.class, args);
    }
}
