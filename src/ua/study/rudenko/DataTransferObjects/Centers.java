package ua.study.rudenko.DataTransferObjects;

public class Centers extends ObjectDTO {
	private int clusterId;
	private double firstProperty;
	private double secondProperty;
	
	
	
	public int getClusterId() {
		return clusterId;
	}
	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}
	public double getFirstProperty() {
		return firstProperty;
	}
	public void setFirstProperty(double firstProperty) {
		this.firstProperty = firstProperty;
	}
	public double getSecondProperty() {
		return secondProperty;
	}
	public void setSecondProperty(double secondProperty) {
		this.secondProperty = secondProperty;
	}
	
	
	

}
