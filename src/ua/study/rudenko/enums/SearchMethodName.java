package ua.study.rudenko.enums;

public enum SearchMethodName {
	FIRST_ELEMENTS("Первые элементы"),
	RANDOM_ELEMENTS("Случайные элементы"),
	FAR_ELEMENTS("Дальние элементы");
	
	
	private String name;

	private SearchMethodName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	
	
	

	

}
