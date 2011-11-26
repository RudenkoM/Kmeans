package ua.study.rudenko.entity;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
	private int number;
	private List<Obj> objects=new ArrayList<Obj>();
	private Obj center;
	private double [][] covariationMatrix;
	
	
	
	
	public Cluster(int number, Obj objects) {
		this.number = number;
		this.objects.add(objects);
		
	}
	public double [][] getCovariationMatrix(){
		covariationMatrix = new  double[2][2];

		for (int i=0; i<objects.size(); i++){
			covariationMatrix[0][0]+=(objects.get(i).getFirstProperty()-center.getFirstProperty())*(objects.get(i).getFirstProperty()-center.getFirstProperty());	
			covariationMatrix[0][1]+=(objects.get(i).getFirstProperty()-center.getFirstProperty())*(objects.get(i).getSecondProperty()-center.getSecondProperty());
			covariationMatrix[1][0]+=(objects.get(i).getSecondProperty()-center.getSecondProperty())*(objects.get(i).getFirstProperty()-center.getFirstProperty());
			covariationMatrix[1][1]+=(objects.get(i).getSecondProperty()-center.getSecondProperty())*(objects.get(i).getSecondProperty()-center.getSecondProperty());
		}
		
		covariationMatrix[0][0]/=objects.size();
		covariationMatrix[0][1]/=objects.size();
		covariationMatrix[1][0]/=objects.size();
		covariationMatrix[1][0]/=objects.size();
		
		return covariationMatrix;	
	}
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Obj> getObjects() {
		return objects;
	}
	public void addObject(Obj object) {
		this.objects.add(object);
	}
	public Obj getCenter() {
		return center;
	}
	public void setCenter(Obj center) {
		this.center = center;
	}
	public void findCenter(){
		double sumOfFirst=0, sumOfSecond=0;
		for(int i=0;i<objects.size();i++){
			sumOfFirst+=objects.get(i).getFirstProperty();
			sumOfSecond+=objects.get(i).getSecondProperty();
		}
		center.setFirstProperty((1.0/objects.size())*sumOfFirst);
		center.setSecondProperty((1.0/objects.size())*sumOfSecond);
	
	}
	
	public boolean contains(Obj object){
		if (objects.contains(object))
			return true;
		
		return false;
	}
	@Override
	public String toString() {
		return "Cluster [number=" + number + ", objects=" + objects
				+ ", center=" + center + "]"+"\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + number;
		result = prime * result + ((objects == null) ? 0 : objects.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		Cluster other = (Cluster) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (number != other.number)
			return false;
		if (objects == null) {
			if (other.objects != null)
				return false;
		} else if (!objects.equals(other.objects))
			return false;
		return true;
	}
	
	

}
