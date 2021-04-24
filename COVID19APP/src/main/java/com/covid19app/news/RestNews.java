package com.covid19app.news;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class describes the whole JSON object returned from an API call. This class includes the status of
 * the call (success or fail), the total results, and a list of articles returned. 
 * There is a toString() method to return the JSON object in a string.
 * @author Neil An
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestNews {
	private String status;
	private int totalResults;
	private List<Article> articles;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "RestNews{" + "status='" + status + '\'' + ", totalResults=" + totalResults +
				 ", articles=" + articles +
				'}';
	}
}
