package com.covid19app.data;

/**
 * This is the class of HealthRegionData. It has the attributes to store the cases, cumulative_cases, cumulative_deaths, etc.
 * @author GuoYu Cao
 * @version 1.0
 */
public class HealthRegionData {
	private String cases;
	private String cumulative_cases;
	private String cumulative_deaths;
	private String date;
	private String deaths;
	private String health_region;
	private String province;
	
	
	/**
	 * This is the get method of cases. 
	 * @return cases The cases number. 
	 */
	public String getCases() {
		return cases;
	}
	
	/**
	 * This is the set method of cases.
	 * @param cases The cases number.
	 */
	public void setCases(String cases) {
		this.cases = cases;
	}

	/**
	 * This is the get method of cumulative_cases. 
	 * @return cumulative_cases The cumulative_cases number.
	 */
	public String getCumulative_cases() {
		return cumulative_cases;
	}
	
	/**
	 *  This is the set method of cumulative_cases. 
	 * @param cumulative_cases
	 */
	public void setCumulative_cases(String cumulative_cases) {
		this.cumulative_cases = cumulative_cases;
	}

	/**
	 *  This is the get method of cumulative_deaths. 
	 * @return cumulative_deaths The cumulative_deaths number.
	 */
	public String getCumulative_deaths() {
		return cumulative_deaths;
	}
	
	/**
	 *   This is the set method of cumulative_deaths.
	 * @param cumulative_deaths The cumulative_deaths numbers.
	 */
	public void setCumulative_deaths(String cumulative_deaths) {
		this.cumulative_deaths = cumulative_deaths;
	}
	
	/**
	 *   This is the get method of date.
	 * @return date The date.
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 *   This is the set method of date.
	 * @param date The date.
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * This is the get method of deaths.
	 * @return deaths The deaths number.
	 */
	public String getDeaths() {
		return deaths;
	}
	
	/**
	 * The deaths number.
	 * @param deaths The deaths number.
	 */
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	
	/**
	 *  This is the get method of health_region.
	 * @return health_region The health_region number.
	 */
	public String getHealth_region() {
		return health_region;
	}
	
	/**
	 * This is the set method of health_region.
	 * @param health_region The health_region number.
	 */
	public void setHealth_region(String health_region) {
		this.health_region = health_region;
	}

	/**
	 * This is the get method of province.
	 * @return province The province.
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * This is the set method of province.
	 * @param province province The province.
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	
	
	
}
