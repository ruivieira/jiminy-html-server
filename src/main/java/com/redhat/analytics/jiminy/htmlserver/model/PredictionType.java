package com.redhat.analytics.jiminy.htmlserver.model;

import java.util.List;

public class PredictionType {
	
	PredictionResponse prediction;

	public PredictionType() {
		
	}
	public PredictionType(PredictionResponse prediction) {
		this.prediction = prediction;
	}

	public PredictionResponse getPrediction() {
		return prediction;
	}

	public void setPrediction(PredictionResponse prediction) {
		this.prediction = prediction;
	}
	@Override
	public String toString() {
		return "PredictionType [prediction=" + prediction + "]";
	}
	
	
	
}
