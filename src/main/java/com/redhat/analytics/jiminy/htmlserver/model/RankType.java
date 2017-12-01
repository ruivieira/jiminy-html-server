package com.redhat.analytics.jiminy.htmlserver.model;

import java.util.List;

public class RankType {

	String id;
	List<ProductType> products;
	String topk;
	String user;
	public String getTopk() {
		return topk;
	}

	public void setTopk(String topk) {
		this.topk = topk;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public RankType() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ProductType> getProducts() {
		return products;
	}

	public void setProducts(List<ProductType> products) {
		this.products = products;
	}

	public RankType(String id, List<ProductType> products) {

		this.id = id;
		this.products = products;
	}

	@Override
	public String toString() {
		return "RankType [id=" + id + ", products=" + products + ", topk=" + topk + ", user=" + user + "]";
	}

	 

}
