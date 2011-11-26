package ua.study.rudenko.clustering;

import java.io.IOException;
import java.util.List;

import ua.study.rudenko.data.DataFromFile;
import ua.study.rudenko.entity.Cluster;
import ua.study.rudenko.entity.Obj;
import ua.study.rudenko.enums.PrepareName;
import ua.study.rudenko.quality.Quality;

public class Main {
	public static void main(String[] args) throws IOException {
		int numberOfClusters = 3;
		DataFromFile loader = new DataFromFile();
		Clustering clustering = new Clustering(numberOfClusters); 
		loader.setFileName("E:/Downloads/data/lab1,2 (clustering)/1.txt");

		double[][] data = loader.load();
		
		List<Obj> objects = clustering.fillObjects(data,PrepareName.NO_PREPARE);
		List<Cluster> clusters = clustering.fillClustersWithRandomElements(objects);
		clusters = clustering.fillClusters(objects, clusters);
		Quality quality = new Quality();
		quality.countQuality(clusters);
		
		System.out.println(clusters);
		System.out.println(quality.getQuality());
		
	}

}
