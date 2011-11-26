package ua.study.rudenko.enums;

public enum PrepareName {
	PREPARE_1("Стандартизация 1"), PREPARE_2("Стандартизация 2"), PREPARE_3(
			"Стандартизация 3"), PREPARE_4("Стандартизация 4"), NO_PREPARE(
			"Не стандартизировать");

	private String name;

	private PrepareName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
