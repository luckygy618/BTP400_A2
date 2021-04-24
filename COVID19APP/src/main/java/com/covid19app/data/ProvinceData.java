package com.covid19app.data;

/**
 * This is the class of ProvinceData, it has the attributes to show the cases, cumulative_cases, date_report, and province. 
 * @author GuoYu Cao
 * @version 1.0
 */
public class ProvinceData {

	private String cases;
	private String cumulative_cases;
	private String date_report;
	private String province;
	
	/**
	 * This is the get method of cases.
	 * @return cases The cases number.
	 */
	 public String getCases() {  
	        return this.cases;  
	    }  
	 
	 /**
	  * This is the set method of cases.
	  * @param cases The cases number.
	  */
	 public void setCases(String cases) {  
	        this.cases = cases;  
	    }  
	
	 /**
	  *  This is the get method of cumulative_cases.
	  * @return cumulative_cases The cumulative_cases number.
	  */
	 public String getCumulative_cases() {  
	        return this.cumulative_cases;  
	    }  
	 
	 /**
	  * This is the set method of cumulative_cases.
	  * @param cumulative_cases The cumulative_cases number.
	  */
	 public void setCumulative_cases(String cases) {  
	        this.cumulative_cases = cases;  
	    }  
	
	 /**
	  *  This is the get method of date_report.
	  * @return date_report The date_report.
	  */ 
	 public String getDate_report() {  
	        return this.date_report;  
	    }  
	 
	 /**
	  *  This is the set method of date_report.
	  * @param date The date_report.
	  */
	 public void setDate_report(String date) {  
	        this.date_report = date;  
	    }  
	
	 /**
	  *   This is the get method of province.
	  * @return province The province.
	  */
	 public String getProvince() {  
	        return this.province;  
	    }  
	 
	 /**
	  * This is the set method of province.
	  * @param prov   The province.
	  */
	 public void setProvince(String prov) {  
	        this.province = prov;  
	    }  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
