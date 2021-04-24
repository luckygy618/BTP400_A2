package com.covid19app.news;

import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class contains the getNews() method which calls the news API to get news articles
 * related to Covid-19 in Canada.
 * @author Neil An
 *
 */
public class GetNews {
	public static JSONObject getNews() throws JsonMappingException, JsonProcessingException, JSONException {
		WebClient webClient = WebClient.create();
		String news = webClient.get()
				.uri("https://newsapi.org/v2/top-headlines?country=ca&q=covid&apiKey=7b147cda7eb0468b932b39eba6d3d406")
				.retrieve().bodyToMono(String.class).block();
		JSONObject newsObject = new JSONObject(news);
		return newsObject;
	}
}
