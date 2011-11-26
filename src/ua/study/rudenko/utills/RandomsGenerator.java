package ua.study.rudenko.utills;

import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @author Masha
 * ����� �������� ����� ��� ��������� ������������������ ���������, ���������� �����
 *
 */
public class RandomsGenerator {
	int edge;
	int length;
	
	/**
	 * @param  edge ������� ������������ �����
	 * @param  length ����� ������������ ������������������
 	 * @return HashSet<Integer> ������������������ 
	 */	
	public RandomsGenerator(int edge, int length) {
		super();
		this.edge = edge;
		this.length = length;
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	
	/**
	 * ����� ��� ��������� ������������������ ���������, ���������� ����� �� ���� (inclusive) �� edge(exclusive), ������ length 
	 */	
	public HashSet<Integer> generateDifferentRandoms(){
	Random random = new Random();
	HashSet<Integer> randomValues = new HashSet<Integer>();
		
		while(randomValues.size() != length){
		randomValues.add(random.nextInt(edge));
		}
	return	randomValues;
	}

}
