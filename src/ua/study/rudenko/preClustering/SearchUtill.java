package ua.study.rudenko.preClustering;

import java.util.List;

import ua.study.rudenko.entity.Cluster;
import ua.study.rudenko.entity.Obj;
import ua.study.rudenko.enums.MetricName;

public class SearchUtill {
	
	private Metrics metric = new Metrics();;
	
	public int findNearest(Obj object,List<Cluster> clusters, MetricName metricName){
		double min=0;
		switch (metricName){
		case EVKLID:
			min = metric.evklid(object, clusters.get(0).getCenter());
			break;
		case MANHATTAN:
			min = metric.manhattan(object, clusters.get(0).getCenter());
		}
		
			
		
		int result = 0; 
		for (int i=1; i<clusters.size();i++){
			double d = 0;
			switch (metricName){
			case EVKLID:
				d = metric.evklid(object, clusters.get(i).getCenter());
				break;
			case MANHATTAN:
				d = metric.manhattan(object, clusters.get(i).getCenter());
			}
				if (d < min)	{
					min = d;
					result = i;
				}
		}
		
		return result;
	}
	
	

}
