/**
 * This package contains all of the files for the application
 */
package com.covid19app;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.covid19app.data.RetrieveData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * The {@code IndexController} is a controller for the Home page which loads when the root path
 * is called in the URL and points to the index.html Thymeleaf template. The Home page displays
 * summary data and includes a dropdown for filtering COVID 19 data by province and a dropdown
 * for filtering COVID 19 data by health region.
 * @author Tim Lai
 * @version 1.0
 */
@Controller
public class IndexController {
	/**
	 * The {@code index()} method uses the {@code @GetMapping()} annotation to point to map
	 * the controller to the root path of the URL and then takes in a {@code model}
	 * parameter which is used to model data in the Thymeleaf template. It then uses the
	 * {@code RetrieveData} class to get data from the Open COVID API and adds that data
	 * to the {@code model} using the {@code addAttribute()} method. Finally it returns
	 * the "index" which is the name of the Thymeleaf HTML template it loads.
	 * @param model
	 * @return "index" The name of the index.html template
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws JSONException
	 */
	@GetMapping("/")
	public String index(Model model) throws JsonMappingException, JsonProcessingException, JSONException {
		RetrieveData retrieveData = new RetrieveData();
		
		model.addAttribute("date", retrieveData.getSummaryData().get(0).getDate());
		model.addAttribute("cumulativeCases", retrieveData.getSummaryData().get(0).getCumulative_cases());
		model.addAttribute("activeCases", retrieveData.getSummaryData().get(0).getActive_cases());
		model.addAttribute("deaths", retrieveData.getSummaryData().get(0).getDeaths());
		model.addAttribute("cumulativeDeaths", retrieveData.getSummaryData().get(0).getCumulative_deaths());
		
		return "index";
	}
}
