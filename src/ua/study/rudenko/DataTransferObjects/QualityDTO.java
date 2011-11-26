package ua.study.rudenko.DataTransferObjects;

public class QualityDTO {
	
	private int testId;
	private int clustersNumber;
	private double quality;
	
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getClustersNumber() {
		return clustersNumber;
	}
	public void setClustersNumber(int clustersNumber) {
		this.clustersNumber = clustersNumber;
	}
	public double getQuality() {
		return quality;
	}
	public void setQuality(double quality) {
		this.quality = quality;
	}
	
	

}
