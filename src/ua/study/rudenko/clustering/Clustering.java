package ua.study.rudenko.clustering;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import ua.study.rudenko.DataTransferObjects.ObjectDTO;
import ua.study.rudenko.data.DataFromFile;
import ua.study.rudenko.entity.Cluster;
import ua.study.rudenko.entity.Obj;
import ua.study.rudenko.enums.MetricName;
import ua.study.rudenko.enums.PrepareName;
import ua.study.rudenko.preClustering.DataPreparator;
import ua.study.rudenko.preClustering.Metrics;
import ua.study.rudenko.preClustering.SearchUtill;
import ua.study.rudenko.utills.RandomsGenerator;

public class Clustering {

	int numberOfClusters;
	
	

	public Clustering(int numberOfClusters) {
		super();
		this.numberOfClusters = numberOfClusters;
	}
	
	

	public int getNumberOfClusters() {
		return numberOfClusters;
	}



	public void setNumberOfClusters(int numberOfClusters) {
		this.numberOfClusters = numberOfClusters;
	}



	// filling objecs
	public List<Obj> fillObjects(double[][] data, PrepareName methodName) {
		DataPreparator preparator = new DataPreparator();
		ArrayList<Obj> objects = new ArrayList<Obj>();
		switch (methodName) {

		case PREPARE_1: {
			preparator.prepare1(data);
			break;
		}
		case PREPARE_2: {
			preparator.prepare2(data);
			break;
		}
		case PREPARE_3: {
			preparator.prepare3(data);
			break;
		}
		case PREPARE_4:
			preparator.prepare4(data);
		}
		for (int i = 0; i < data.length; i++)
			objects.add(new Obj(i, data[i][0], data[i][1]));

		return objects;
	}

	// filling klasters first time with first elements
	public List<Cluster> fillClustersWithFirstElements(List<Obj> objects) {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		for (int i = 0; i < numberOfClusters; i++) {

			clusters.add(new Cluster(i, objects.get(i)));
			clusters.get(i).setCenter(objects.get(i));

		}
		return clusters;
	}
	
	public List<Cluster> fillClustersWithFarElements(List<Obj> objects) {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		Metrics metric = new Metrics();
		double max=0;
		int firstCenter=0;
		int secondCenter=0;
		for (int i=0; i<objects.size(); i++){
			for (int j=0; j<objects.size(); j++){
				if (metric.evklid(objects.get(i), objects.get(j))>max){
					max=metric.evklid(objects.get(i), objects.get(j));
					firstCenter=i;
					secondCenter=j;
				}
				
			}
		}
		clusters.add(new Cluster(0, objects.get(firstCenter)));
		clusters.get(0).setCenter(objects.get(firstCenter));
		
		clusters.add(new Cluster(1, objects.get(secondCenter)));
		clusters.get(1).setCenter(objects.get(secondCenter));
		
		double maxf=0;
		double maxs=0;

		ArrayList<Integer> list =new ArrayList<Integer>();
		for (int i=2;i<numberOfClusters;i++){
			for (int j=0;j<objects.size();j++){
			if ((!list.contains(j)) && (metric.evklid(objects.get(firstCenter),objects.get(j))>maxf) && 
					(metric.evklid(objects.get(secondCenter),objects.get(j))>maxs)){
				maxf = metric.evklid(objects.get(firstCenter),objects.get(j));
				maxs = metric.evklid(objects.get(secondCenter),objects.get(j));
				list.add(j);
				
			}
			}
			clusters.add(new Cluster(i, objects.get(list.get(i-2))));
			clusters.get(1).setCenter(objects.get(list.get(i-2)));	
		}
		
		
		return clusters;
	}

	public List<Cluster> fillClustersWithRandomElements(List<Obj> objects) {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		RandomsGenerator generator = new RandomsGenerator(objects.size(),
				numberOfClusters);
		HashSet<Integer> randoms = new HashSet<Integer>();
		randoms = generator.generateDifferentRandoms();
		Iterator<Integer> iterator = randoms.iterator();
		for (int i = 0; i < randoms.size(); i++) {
			
			int index = iterator.next();
			

			clusters.add(new Cluster(i, objects.get(index)));
			clusters.get(i).setCenter(objects.get(index));

		}
		return clusters;
	}

	// filling klasters
	public List<Cluster> fillClusters(List<Obj> objects, List<Cluster> clusters) {
		SearchUtill utill = new SearchUtill();
		for (int i = 0; i < objects.size(); i++) {
			for (int j=0; j< clusters.size(); j++){
				if (clusters.get(j).contains(objects.get(i)))
						i++;
			}
			int nearestClusterId = utill.findNearest(objects.get(i), clusters, MetricName.EVKLID);
			clusters.get(nearestClusterId).addObject(objects.get(i));
			clusters.get(nearestClusterId).findCenter();
			
		}



		return clusters;
	}

	
}
