package ua.study.rudenko.preClustering;

import ua.study.rudenko.entity.Obj;

public class Metrics {
	public double evklid(Obj firstObject,Obj secondObject){
		double result;
		result=Math.sqrt(Math.pow((firstObject.getFirstProperty()-secondObject.getFirstProperty()),2)+
				Math.pow((firstObject.getSecondProperty()-secondObject.getSecondProperty()),2));
		return result;
	};

	public double manhattan(Obj firstObject,Obj secondObject){
		double result;
		result=(Math.abs(firstObject.getFirstProperty()-secondObject.getFirstProperty())+
				Math.abs(firstObject.getSecondProperty()-secondObject.getSecondProperty()));
		return result;
	};
}
