package ua.study.rudenko.data;

import java.io.IOException;

public interface IDataStore {
	
	public double [][] load() throws IOException;
	public void save();

}
