package ua.study.rudenko.preClustering;
/**
 * 
 * @author Masha
 * ������ ����� �������� ��������� ������ ��� �������������� ������, ����� ����������� �������������
 * � ���� ��������� ������������� �� ���� ���������, ������� ��������� �� ���������� �������. 
 */
public class DataPreparator {

	
	public void prepare1(double[][] data){
		double	newX = 0;
		double newY = 0;
		double q1 = 0;
		double q2 = 0;
		for (int i=0;i<data.length;i++){
			newX +=data[i][0];
			newY +=data[i][1];
		}
		newX=newX/data.length;
		newY=newY/data.length;
		
		for (int i=0;i<data.length;i++){
			q1+=(data[i][0]+newX)*(data[i][0]+newX);
			q1+=(data[i][0]+newY)*(data[i][0]+newY);
		}
		q1 = Math.sqrt(q1*1/(data.length-1));
		q2 = Math.sqrt(q2*1/(data.length-1));
		for (int i=0;i<data.length;i++){
			data[i][0]=(data[i][0]-newX)/q1;
			data[i][1]=(data[i][1]-newY)/q2;		
		}
		
	}
	
	public void prepare2(double[][] data){
		for (int i=0;i<data.length;i++)
		{
		double	newX=(data[i][0]+data[i][1])/2;
		
		data[i][0]=data[i][0]/newX;
		data[i][1]=data[i][1]/newX;
		}
		
	}
	
	public void prepare3(double[][] data){
		for (int i=0;i<data.length;i++)
		{
		double max=data[i][0];
			if (data[i][1]>data[i][0]){
			 max=data[i][1];
			}
		
		data[i][0]=data[i][0]/max;
		data[i][1]=data[i][1]/max;
		}
		
	}
	
	public void prepare4(double[][] data){
		for (int i=0;i<data.length;i++)
		{
		double max=data[i][0];
		double min=data[i][1];
			if (data[i][1]>data[i][0]){
			 max=data[i][1];
			 min=data[i][0];
			}
		
		data[i][0]=data[i][0]/(max-min);
		data[i][1]=data[i][1]/(max-min);
		}
		
	}
	

}
