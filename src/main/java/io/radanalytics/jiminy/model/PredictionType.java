package io.radanalytics.jiminy.model;

/**
 * PredictionType<br>
 * This is a wrapper for the prediction response. See PredictionResponse java docs for how what this class 
 * is used for.
 * @author Zak Hassan <zhassan@redhat.com>
 */
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
