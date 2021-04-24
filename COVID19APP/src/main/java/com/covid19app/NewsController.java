/**
 * This package contains all of the files for the application
 */
package com.covid19app;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.covid19app.news.GetNews;
import com.covid19app.news.RestNews;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The {@code NewsController} is a controller for the News page which loads when the "/news" path
 * is called in the URL and points to the news.html Thymeleaf template. The News page displays
 * recent news articles about COVID-19 collected from the News API.
 * @author Tim Lai
 * @version 1.0
 */
@Controller
public class NewsController {
	/**
	 * The {@code news()} method uses the {@code @GetMapping()} annotation to point to map
	 * the controller to the "/news" path of the URL and then takes in a {@code model}
	 * parameter which is used to model data in the Thymeleaf template. It then uses the
	 * {@code GetNews} class to get data from the News API and adds that data
	 * to the {@code model} using the {@code addAttribute()} method. Finally it returns
	 * the "news" which is the name of the Thymeleaf HTML template it loads.
	 * @param model
	 * @return "news" The name of the news.html template
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws JSONException
	 */
	@GetMapping("/news")
	public String news(Model model) throws JsonMappingException, JsonProcessingException, JSONException {
		ObjectMapper objectMapper = new ObjectMapper();
		JSONObject news = GetNews.getNews();
		RestNews restNews = objectMapper.readValue(news.toString(), RestNews.class);	
		model.addAttribute("articles", restNews.getArticles());
		return "news";
	}
}
