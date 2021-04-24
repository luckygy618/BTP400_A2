package com.covid19app.data;

import org.json.JSONException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class testMain {
	public static void main(String[] args)    {
		// TODO Auto-generated method stub
	  	//RetrieveData.getAllProvinceDataByDate();

		try {
			try { 

				RetrieveData tmp = new RetrieveData();
				System.out.println(tmp.getDate());
				System.out.println(tmp.getAllProvinceDataByDate().get(0).getCases());
				System.out.println(tmp.getSummaryData().get(0).getCumulative_cases());
				System.out.println(tmp.getHealthRegionData(3595).get(0).getProvince());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
