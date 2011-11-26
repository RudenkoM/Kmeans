package ua.study.rudenko.DataTransferObjects;

public class ObjectDTO {
	private int id;
	private double firstProperty;
	private double secondProperty;
	private int clusterId;
	
	
	public ObjectDTO() {

	}


	public void setId(int id) {
		this.id = id;
	}


	public void setFirstProperty(double firstProperty) {
		this.firstProperty = firstProperty;
	}


	public void setSecondProperty(double secondProperty) {
		this.secondProperty = secondProperty;
	}


	public void setClusterId(int numberOfCluster) {
		this.clusterId = numberOfCluster;
	}


	public int getId() {
		return id;
	}


	public double getFirstProperty() {
		return firstProperty;
	}


	public double getSecondProperty() {
		return secondProperty;
	}


	public int getNumberOfCluster() {
		return clusterId;
	}
	
	
	
	

}
