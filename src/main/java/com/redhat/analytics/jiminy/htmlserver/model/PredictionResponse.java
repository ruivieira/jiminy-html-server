package com.redhat.analytics.jiminy.htmlserver.model;

import java.util.List;
/**
 * PredictionResponse<br>
 * 
 * Encloses the predictions number of recommendations and userid. In the ui a user makes a webservice call
 * passing in a userid and this is the response that the client would recieve.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
public class PredictionResponse {
	String id;
	List<String> products;
	Integer topk;
	String user;

	public PredictionResponse() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public Integer getTopk() {
		return topk;
	}

	public void setTopk(Integer topk) {
		this.topk = topk;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PredictionResponse [id=" + id + ", products=" + products + ", topk=" + topk + ", user=" + user + "]";
	}

}
