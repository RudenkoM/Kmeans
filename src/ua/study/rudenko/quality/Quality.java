package ua.study.rudenko.quality;

import java.util.List;

import Jama.Matrix;


import ua.study.rudenko.entity.Cluster;

public class Quality{
	
 private double	quality;
 private  static int id=0;
 
public Quality(){
	id++;
	
}
 
 
public double getQuality() {
	
	return quality;
}

public void setQuality(double quality) {
	this.quality = quality;
}
	
public void countQuality(List<Cluster> clusters){
	Matrix matrix = new Matrix(clusters.get(0).getCovariationMatrix());
	matrix = matrix.times(clusters.size());
	for (int i = 1; i<clusters.size(); i++){
		
		matrix =matrix.plus( new Matrix(clusters.get(i).getCovariationMatrix()).times(clusters.size()));
		
	}
quality = matrix.det();
	
}
 
 
	
	

}
