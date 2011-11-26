package ua.study.rudenko.DataTransferObjects;

import java.util.List;

import ua.study.rudenko.entity.Cluster;
import ua.study.rudenko.entity.Obj;
import ua.study.rudenko.quality.Quality;



public class Assemblers {
	
	public ObjectDTO objectAssembler(Obj object, List<Cluster> clusters) {
		ObjectDTO result = new ObjectDTO();
		int clusterId = 0;
		for (int i = 0; i < clusters.size(); i++) {
			if (clusters.get(i).contains(object))
				clusterId = i;

		}
		
		result.setClusterId(clusterId);
		result.setId(object.getId());
		result.setFirstProperty(object.getFirstProperty());
		result.setSecondProperty(object.getSecondProperty());
		
		return result;
	};
	
	public QualityDTO qualityAssembler(List<Cluster> clusters, Quality quality) {
		QualityDTO result = new QualityDTO();
		
		
		result.setClustersNumber(clusters.size());
		result.setQuality(quality.getQuality());
		return result; 
	}
	
	public Centers centersAssembler(Cluster cluster){
		Centers result = new Centers();
		
		result.setClusterId(cluster.getNumber());
		result.setFirstProperty(cluster.getCenter().getFirstProperty());
		result.setSecondProperty(cluster.getCenter().getSecondProperty());
		
		return result;
	}

}
