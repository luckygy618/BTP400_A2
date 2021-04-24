/**
 * This package contains all of the files for the application
 */
package com.covid19app;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.covid19app.data.HealthRegionData;
import com.covid19app.data.RetrieveData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * The {@code RegionController} is a controller for the News page which loads when the "/region" path
 * is called in the URL and points to the region.html Thymeleaf template. The Region page displays
 * the latest COVID-19 data from a given health region.
 * @author Tim Lai
 * @version 1.0
 */
@Controller
public class RegionController {
	/**
	 * The {@code region()} method uses the {@code @GetMapping()} annotation to point to
	 * map the controller to the "/region" path of the URL and then takes in a {@code model}
	 * parameter which is used to model data in the Thymeleaf template. It then uses the
	 * {@code RetrieveData} class to get data from the Open COVID API and adds that data
	 * to the {@code model} using the {@code addAttribute()} method. Finally it returns
	 * the "region" which is the name of the Thymeleaf HTML template it loads.
	 * @param region
	 * @param model
	 * @return "region" The name of the region.html template
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws JSONException
	 */
	@GetMapping("/region")
	public String region(@RequestParam(name="region", required=true, defaultValue="Toronto") Integer region, Model model) throws JsonMappingException, JsonProcessingException, JSONException {
		RetrieveData retrieveData = new RetrieveData();
		HealthRegionData healthRegionData = retrieveData.getHealthRegionData(region).get(0);
		
		model.addAttribute("healthRegion", healthRegionData.getHealth_region());
		model.addAttribute("province", healthRegionData.getProvince());
		model.addAttribute("date", healthRegionData.getDate());
		model.addAttribute("cases", healthRegionData.getCases());
		model.addAttribute("cumulativeCases", healthRegionData.getCumulative_cases());
		model.addAttribute("deaths", healthRegionData.getDeaths());
		model.addAttribute("cumulativeDeaths", healthRegionData.getCumulative_deaths());
		
		return "region";
	}
}
