package com.kim.jul82.fruit;

import java.util.List;


public interface FruitMapper {

	public abstract List<Fruit> getAllFruit();
	
	public abstract List<Fruit> searchFruit(Fruit f);
}
