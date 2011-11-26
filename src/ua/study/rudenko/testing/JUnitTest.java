package ua.study.rudenko.testing;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.study.rudenko.clustering.Clustering;
import ua.study.rudenko.data.DataFromFile;
import ua.study.rudenko.entity.Cluster;
import ua.study.rudenko.entity.Obj;
import ua.study.rudenko.enums.PrepareName;
import ua.study.rudenko.preClustering.DataPreparator;
import ua.study.rudenko.preClustering.Metrics;
import ua.study.rudenko.utills.RandomsGenerator;

public class JUnitTest {
	private double [][] x ={ {227.5921  ,   111.0161},
            {247.7641   ,   59.4956},
            {73.4457  ,    -1.5353},
            {227.6755  ,   111.2483},
            {257.4967  ,    79.7010},
            {278.8218   ,   92.5088}};
private	DataPreparator preparator= new DataPreparator();
private DataFromFile loader = new DataFromFile();
private double[][] data ;
private Metrics metric = new Metrics();


	@Before
	public void createData() throws IOException{
		loader.setFileName("E:/Downloads/data/lab1,2 (clustering)/1.txt");
		data=loader.load();
	}
	@Test
	public void testLoad() throws IOException{
	data=loader.load();
	}
	
	@Test
	public void testPreparations() throws IOException {
		preparator.prepare4(data);
		assertNotNull(data);
		for (int i=0;i<data.length;i++){
			for (int j=0;j<2;j++){
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	@Test
	public void testMetrics() {
		preparator.prepare4(data);
		Obj object1 = new Obj(1,data[0][0],data[0][1]);
		Obj object2 = new Obj(1,data[1][0],data[1][1]);
		
		assertNotNull(metric.evklid(object1,object2));
		System.out.println(metric.evklid(object1,object2));
		
	}
	
	@Test
	public void testRandomsGenerator(){
	RandomsGenerator randoms = new RandomsGenerator(10,3);
	assertNotNull(randoms.generateDifferentRandoms());
	System.out.println(randoms.generateDifferentRandoms());
	}
	
	@Test
	public void testFillClustersWithRandoms(){
	Clustering clustering = new Clustering(3);
	List<Obj> objects = clustering.fillObjects(data,PrepareName.PREPARE_4);
	List<Cluster> clusters = clustering.fillClustersWithRandomElements(objects);
	assertNotNull(clusters);
	assertTrue(clusters.size()==3);
	assertFalse(clusters.get(1).getObjects().equals(clusters.get(2).getObjects()));
	System.out.println(clusters);

	}
	
	@Test
	public void testFillClustersWithFarest(){
		Clustering clustering = new Clustering(4);
		List<Obj> objects = clustering.fillObjects(data,PrepareName.PREPARE_4);
		List<Cluster> clusters = clustering.fillClustersWithRandomElements(objects);
		assertNotNull(clusters);
		assertTrue(clusters.size()==4);
		assertFalse(clusters.get(1).getObjects().equals(clusters.get(2).getObjects()));
		System.out.println(clusters);
		
		
	}

}
