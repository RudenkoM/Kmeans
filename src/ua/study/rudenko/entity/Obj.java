package ua.study.rudenko.entity;

public class Obj {
	
	private int id;
	private double firstProperty;
	private double secondProperty;
	
	
	
	
	
	public Obj(int id,double firstProperty, double secondProperty) {
		this.id = id;
		this.firstProperty = firstProperty;
		this.secondProperty = secondProperty;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getFirstProperty() {
		return firstProperty;
	}
	public void setFirstProperty(double firstProperty) {
		this.firstProperty = firstProperty;
	}
	public double getSecondProperty() {
		return secondProperty;
	}
	public void setSecondProperty(double secondProperty) {
		this.secondProperty = secondProperty;
	}



	@Override
	public String toString() {
		return "Obj [id=" + id + ", firstProperty=" + firstProperty
				+ ", secondProperty=" + secondProperty + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(firstProperty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(secondProperty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Obj other = (Obj) obj;
		if (Double.doubleToLongBits(firstProperty) != Double
				.doubleToLongBits(other.firstProperty))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(secondProperty) != Double
				.doubleToLongBits(other.secondProperty))
			return false;
		return true;
	}
	
	
	
	

}
