public class Cat
{
/*	private static String STATUS_DEAD 		= "Dead";
	private static String STATUS_EXPLODED 	= "Exploded";
	private static String STATUS_SLEEPING 	= "Sleeping";
	private static String STATUS_PLAYING 	= "Playing";*/

	enum Status
	{
		DEAD, EXPLODED, SLEEPING, PLAYING
	}

	private Double originWeight;
	private Double weight;

	private Double minWeight;
	private Double maxWeight;

	private Double lastFoodWeight;
	private Double lastDrinkWeight;

	private Status currentStatus;

	private static Integer count = 0;

	public Cat()
	{
		this(Math.floor(1500.0 + 3000.0 * Math.random()));
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
		setStatus();		//сразу присваиваем статус
		count++;

	}

	public Cat createTwin()
	{
		Cat catTwin = new Cat(this.weight);
		catTwin.lastDrinkWeight = this.lastDrinkWeight;
		catTwin.lastFoodWeight  = this.lastFoodWeight;

		return catTwin;

	}

	/**
	 * везде поставил дополнительно setStatus, а то кот может помереть,
	 * а статус и количество котов не изменится
	 */
	public void meow()
	{
		//weight = weight - 1;
		weight = weight - 100; //изменил, а то они долго мяукуют
		System.out.println("Meow");
		setStatus();
	}

	public void feed(Double amount)
	{
		amount = Math.floor(amount);
		weight = weight + amount;
		lastFoodWeight = amount;
		setStatus();
	}

	public void drink(Double amount)
	{
		amount = Math.floor(amount);
		weight = weight + amount;
		lastDrinkWeight = amount;
		setStatus();
	}

	public void goToToilet()
	{
		Double sheet = Math.floor(50 + 150 * Math.random());
		weight = weight - sheet;
		System.out.println(" going to toilet. Sheet weight " + sheet);
		setStatus();
	}
	public void kill()
	{
		weight = minWeight - 1;
		setStatus();
	}

	private void setStatus()
	{
		if(weight < minWeight) {
			//если кот уже был мертв, количество не уменьшается
			//if (!currentStatus.equals(STATUS_DEAD))
			if(currentStatus != Status.DEAD && currentStatus != Status.EXPLODED)
				count--;
			currentStatus = Status.DEAD;
		}
		else if(weight > maxWeight) {
			//если кот уже взорвался, то количество не уменьшается
			//if (!currentStatus.equals(STATUS_EXPLODED))
			if(currentStatus != Status.EXPLODED && currentStatus != Status.DEAD)
				count--;
			currentStatus = Status.EXPLODED;
		}
		else if(weight > originWeight) {
			currentStatus = Status.SLEEPING;
		}
		else {
			currentStatus = Status.PLAYING;
		}
	}

	public Double getWeight()
	{
		return weight;
	}

	public Status getStatus()
	{
		return currentStatus;
/*		if(weight < minWeight) {
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
		}*/
	}

	public Double getLastFoodWeight()
	{
		return lastFoodWeight;
	}
	public Double getLastDrinkWeight()
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