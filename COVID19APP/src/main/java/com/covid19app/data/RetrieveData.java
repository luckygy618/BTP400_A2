package com.covid19app.data;

import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import  org.json.JSONArray;
import  org.json.JSONException;
import org.json.JSONObject;

/**
 * This is the RetrieveData class, it has the methods that call the COVID19 API and return the data.
 * @author GuoYu Cao
 *@version 1.0
 */
public class RetrieveData {
	String date="";
	 ArrayList<ProvinceData> provData;
	 ArrayList<SummaryData>  sumData;

	 /**
	  * This is the constructor
	  * @throws JsonMappingException The exception of JsonMappingException
	  * @throws JsonProcessingException The exception of JsonProcessingException
	  * @throws JSONException The exception of JSONException
	  */
	 public RetrieveData() throws JsonMappingException, JsonProcessingException, JSONException{	 
		 sumData = setSummaryData() ;
		date=sumData.get(0).getDate();
		 provData = setAllProvinceDataByDate(date);
	 }
	 
	 /**
	  * The get method
	  * @return provData The province data 
	  */
	 public  ArrayList<ProvinceData>   getAllProvinceDataByDate (){
		 return this.provData;	 
	 }
	 
	 /**
	  * The get method 
	  * @return sumData the sumData of Canada
	  */
	 public  ArrayList<SummaryData>   getSummaryData (){
		 return this.sumData;
	 }
	 
	 /**
	  * The get method 
	  * @return date The most recent date that the data
	  */
	 public String   getDate (){
		 return this.date;
	 }
	
	 
	 /**
	  * The method that calls the API and returns the ArrayList of ProvinceData object with all the data based on Province
	  * @param date The date of the API data
	  * @return allProvinceData The ArrayList that has all the data based on Province
	  * @throws JSONException The exception of JSONException
	  * @throws JsonMappingException The exception of JsonMappingException
	  * @throws JsonProcessingException The exception of JsonProcessingException
	  */
	 public     ArrayList<ProvinceData>   setAllProvinceDataByDate(String date) throws JSONException, JsonMappingException, JsonProcessingException {
		   ArrayList<ProvinceData> allProvinceData = new  ArrayList<ProvinceData>();
		 WebClient webClient = WebClient.create();
		 String url = "https://api.opencovid.ca/timeseries?stat=cases&loc=prov&date=" + date;
		 String responseJson = webClient.get()
		                                .uri(url)
		                                .retrieve()
		                                .bodyToMono(String.class)
		                                .block();
		 
		 
		 JSONObject jsonObj=new JSONObject(responseJson);
		 JSONArray jsonArray = jsonObj.getJSONArray("cases");
	        for (int i =0;i<jsonArray.length();i++) {  	 
	   		 String jsonString = jsonArray.get(i).toString();
	   		    ObjectMapper mapper = new ObjectMapper();  
	   		    ProvinceData provinData = mapper.readValue(jsonString, ProvinceData.class); 
	   		 allProvinceData.add(provinData);
	        }

	       return allProvinceData;
	    }
	
	 /**
	  * The method that calls API and returns the SummaryData objects ArrayList with all the summary data of Canada
	  * @return summaryData the SummaryData objects ArrayList with all the summary data of Canada
	  * @throws JSONException The exception of JSONException
	  * @throws JsonMappingException The exception of JsonMappingException
	  * @throws JsonProcessingException The exception of JsonProcessingException
	  */
	 public     ArrayList<SummaryData>   setSummaryData() throws JSONException, JsonMappingException, JsonProcessingException {
		    ArrayList<SummaryData> summaryData = new  ArrayList<SummaryData>();
		 WebClient webClient = WebClient.create();
		 String url = "https://api.opencovid.ca/";
		 String responseJson = webClient.get()
		                                .uri(url)
		                                .retrieve()
		                                .bodyToMono(String.class)
		                                .block();
		 
		 JSONObject jsonObj=new JSONObject(responseJson);
		 
		 JSONArray jsonArray = jsonObj.getJSONArray("summary");
		 
		 
		 System.out.println(jsonObj);
		   for (int i =0;i<jsonArray.length();i++) {  	 
		   		 String jsonString = jsonArray.get(i).toString();
		   		    ObjectMapper mapper = new ObjectMapper();  
		   		 SummaryData sum = mapper.readValue(jsonString, SummaryData.class); 

		   		summaryData.add(sum);
		        }
	
	       return summaryData;
	    }
	 
	 /**
	  * The method that calls the API and returns the ArrayList of HealthRegionData with all the data of HealthRegions
	  * @param HealthRegionCode The HealthRegion
	  * @return allHRData The ArrayList of HealthRegionData with all the data of HealthRegions
	  * @throws JSONException The exception of JSONException
	  * @throws JsonMappingException The exception of JsonMappingException
	  * @throws JsonProcessingException The exception of JsonProcessingException
	  */
	 public     ArrayList<HealthRegionData>   getHealthRegionData(int HealthRegionCode ) throws JSONException, JsonMappingException, JsonProcessingException {
		   ArrayList<HealthRegionData> allHRData = new  ArrayList<HealthRegionData>();
		 WebClient webClient = WebClient.create();
		 String url = "https://api.opencovid.ca/summary?loc=" + HealthRegionCode + "&date="  + this.date;
		 String responseJson = webClient.get()
		                                .uri(url)
		                                .retrieve()
		                                .bodyToMono(String.class)
		                                .block();
		 
		 
		 JSONObject jsonObj=new JSONObject(responseJson);
		 JSONArray jsonArray = jsonObj.getJSONArray("summary");
	        for (int i =0;i<jsonArray.length();i++) {  	 
	   		 String jsonString = jsonArray.get(i).toString();
	   		    ObjectMapper mapper = new ObjectMapper();  
	   		 HealthRegionData hrData = mapper.readValue(jsonString, HealthRegionData.class); 
	   		allHRData.add(hrData);
	        }

	       return allHRData;
	    }
	 
	 

}