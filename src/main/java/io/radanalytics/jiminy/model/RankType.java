package io.radanalytics.jiminy.model;

import java.util.List;

/**
 * RankType<br>
 * 
 * There are 2 calls that get made to the predictor. The first call will trigger the predictor to start calculating
 * what the recommended products are. It will return a prediction id which then gets used to make a second call.
 * This class is used to map the response from the second call to a pojo.
 * 
 * @author Zak Hassan <zhassan@redhat.com>
 */
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
