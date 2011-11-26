package ua.study.rudenko.enums;

public enum MetricName {
	EVKLID("Евклид"), MANHATTAN("Манхеттен");

	private String name;

	private MetricName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

