public class Cat
{
	private Double originWeight;
	private Double weight;

	private Double minWeight;
	private Double maxWeight;

	private Double lastFoodWeight;
	private Double lastDrinkWeight;

	private String currentStatus;

	private static Integer count = 0;

	public Cat()
	{
		weight = Math.floor(1500.0 + 3000.0 * Math.random());
		originWeight = weight;
		minWeight = 100.0;
		maxWeight = 9000.0;

		//Созданные коты еще не ели и не пили
		lastFoodWeight  = 0.0;
		lastDrinkWeight = 0.0;
		currentStatus   = getStatus(); //сразу присваиваем статус
		count++;
	}

	public Cat(Double weight)
	{
		this.weight = weight;
		originWeight = weight;
		minWeight = 100.0;
		maxWeight = 9000.0;

		//Созданные коты еще не ели и не пили
		lastFoodWeight  = 0.0;
		lastDrinkWeight = 0.0;
		currentStatus   = getStatus(); //сразу присваиваем статус
		count++;

	}

	public void createTwin(Cat cat)
	{
		weight 			= cat.weight;
		originWeight 	= cat.originWeight;
		minWeight 		= cat.minWeight;
		maxWeight		= cat.maxWeight;
		lastDrinkWeight	= cat.lastDrinkWeight;
		lastFoodWeight	= cat.lastFoodWeight;
		currentStatus	= cat.currentStatus;
	}

	/**
	 * везде поставил дополнительно getStatus, а то кот может помереть,
	 * а статус и количество котов не изменится
	 */
	public void meow()
	{
		//weight = weight - 1;
		weight = weight - 100; //изменил, а то они долго мяукуют
		System.out.println("Meow");
		getStatus();
	}

	public void feed(Double amount)
	{
		amount = Math.floor(amount);
		weight = weight + amount;
		lastFoodWeight = amount;
		getStatus();
	}

	public void drink(Double amount)
	{
		amount = Math.floor(amount);
		weight = weight + amount;
		lastDrinkWeight = amount;
		getStatus();
	}

	public void goToToilet()
	{
		Double sheet = Math.floor(50 + 150 * Math.random());
		weight = weight - sheet;
		System.out.println(" going to toilet. Sheet weight " + sheet);
		getStatus();
	}
	public void kill()
	{
		weight = minWeight - 1;
		getStatus();
	}

	public Double getWeight()
	{
		return weight;
	}

	public String getStatus()
	{
		if(weight < minWeight) {
			//если кот уже был мертв, количество не уменьшается
			if (!currentStatus.equals("Dead"))
				count--;
			currentStatus = "Dead";
			return "Dead";
		}
		else if(weight > maxWeight) {
			//если кот уже взорвался, то количество не уменьшается
			if (!currentStatus.equals("Exploded"))
				count--;
			currentStatus = "Exploded";
			return "Exploded";
		}
		else if(weight > originWeight) {
			currentStatus = "Sleeping";
			return "Sleeping";
		}
		else {
			currentStatus = "Playing";
			return "Playing";
		}
	}

	public Double getLastFoodWeight()
	{
		return lastFoodWeight;
	}
	public  Double getLastDrinkWeight()
	{
		return lastDrinkWeight;
	}

	public static Double getWeightDifference(Cat cat1, Cat cat2)
	{
		return Math.abs(cat1.getWeight() - cat2.getWeight());
	}

	public static Integer getCount()
	{
		return count;
	}

}