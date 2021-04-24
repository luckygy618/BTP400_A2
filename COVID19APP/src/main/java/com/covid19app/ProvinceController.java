/**
 * This package contains all of the files for the application
 */
package com.covid19app;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.covid19app.data.ProvinceData;
import com.covid19app.data.RetrieveData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * The {@code ProvinceController} is a controller for the News page which loads when the "/province" path
 * is called in the URL and points to the province.html Thymeleaf template. The Province page displays
 * the latest COVID-19 data from a given province.
 * @author Tim Lai
 * @version 1.0
 */
@Controller
public class ProvinceController {
	/**
	 * The {@code province()} method uses the {@code @GetMapping()} annotation to point to
	 * map the controller to the "/province" path of the URL and then takes in a {@code model}
	 * parameter which is used to model data in the Thymeleaf template. It then uses the
	 * {@code RetrieveData} class to get data from the Open COVID API and adds that data
	 * to the {@code model} using the {@code addAttribute()} method. Finally it returns
	 * the "province" which is the name of the Thymeleaf HTML template it loads.
	 * @param province
	 * @param model
	 * @return "province" The name of the province.html template
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws JSONException
	 */
	@GetMapping("/province")
	public String province(@RequestParam(name="province", required=true, defaultValue="Alberta") String province, Model model) throws JsonMappingException, JsonProcessingException, JSONException {
		model.addAttribute("province", province);
		
		try {
			try {
				RetrieveData retrieveData = new RetrieveData();
				String provinceName = "";
				String cases = "";
				String cumulativeCases = "";
				String dateReport = "";
				
				for (int i = 0; i < retrieveData.getAllProvinceDataByDate().size(); i++) {
					
					ProvinceData provinceData = retrieveData.getAllProvinceDataByDate().get(i);
					
					if (province.equals(provinceData.getProvince())) {
						provinceName = provinceData.getProvince();
						cases = provinceData.getCases();
						cumulativeCases = provinceData.getCumulative_cases();
						dateReport = provinceData.getDate_report();
					}
				}
				
				model.addAttribute("provinceName", provinceName);
				model.addAttribute("cases", cases);
				model.addAttribute("cumulativeCases", cumulativeCases);
				model.addAttribute("dateReport", dateReport);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "province";
	}
}
