import java.util.Scanner;

public class Loader
{
	private static void lesson2()
	{

		/**
		 * УРОК 2 Понятие класса и объекта
		 * Создать 5­-7 кошек и повызывать у них различные методы:
		 * - посмотреть, какой у них вес
		 * - попробовать их покормить и посмотреть, что будет с весом
		 * - попробовать перекормить кошку, чтобы она взорвалась
		 * - "замяукать" кошку до смерти
		 */
		System.out.println("LESSON 2");
		//Количество котов
		Integer catsCount = 7;
		//Освободили коробки для 7 котов
		Cat[] cats = new Cat[catsCount];
		//Создали в каждой коробке по коту и посмотрели его вес
		for (Integer i = 0; i < catsCount; i++)
		{
			cats[i] = new Cat();
			System.out.println("Кот № " + (i + 1) + " имеет вес: " + cats[i].getWeight() + " гр.");
		}
		//Поим котов, проверяем вес и статус
		System.out.println("Пойка котов");
		for (Integer i = 0; i < catsCount; i++)
		{
			cats[i].drink(40 + Math.random() * 1000 );
			printCatWeightAndStatus(i, cats[i]);
		}
		/**
		 * Кормим котов до тех пор, пока кто-нибудь не взорвертся
		 */
		System.out.println("==================");
		System.out.println("Кормление котов до взрыва хотя бы одного");
		Boolean isExploded = false; //для проверки на взрыв кота
		Integer feedCount = 0;  //считаем количество кормлений
		do
		{
			//feedCount++;
			System.out.println("Экстремальное кормление котов № " + ++feedCount);
			for (Integer i = 0; i < catsCount; i++)
			{
				cats[i].feed(40 + Math.random() * 1000);
				printCatWeightAndStatus(i, cats[i]);
				if (cats[i].getStatus().equals("Exploded"))
				{
					System.out.println("АХТУНГ! Кот № " + (i + 1) + " взорвался!");
					isExploded = true;
				}
			}
		} while (!isExploded);

		/**
		 * Мяукаем котов до смерти
		 * Т.к. по крайней мере один кот взорвался, мяукать могут не все.
		 * Уже мертвых котов нельзя заставить мяукать
		 */
		System.out.println("==================");
		System.out.println("Мяукаем до смерти котов");
		Integer catsExplodedOrDeadCount; //подсчет взорвавшихся или мертвых котов
		Integer meowCount = 0; //количество мяу
		do
		{
			//meowCount++;
			System.out.println("Мяуканье котов № " + ++meowCount);
			for (Integer i = 0; i < catsCount; i++)
			{
				if (cats[i].getStatus().equals("Sleeping") || cats[i].getStatus().equals("Playing"))
				{
					System.out.print("Кот № " + (i + 1) + " ");
					cats[i].meow();
				}
				printCatWeightAndStatus(i, cats[i]);
			}

			//Подсчет оставшихся в живых котов
			catsExplodedOrDeadCount = 0;
			for (Integer i = 0; i < catsCount; i++)
			{
				if (cats[i].getStatus().equals("Exploded") || cats[i].getStatus().equals("Dead"))
					catsExplodedOrDeadCount++;
			}
			System.out.println("Мертвых или взорвавшихся котов: " + catsExplodedOrDeadCount);

		} while ((int)catsExplodedOrDeadCount != (int)catsCount);
		System.out.println("Все коты мертвы");
	}

	private static void printCatWeightAndStatus(Integer i, Cat cat)
	{
		System.out.println("Кот № " + (i + 1) + " имеет вес: " + cat.getWeight() + " гр.");
		System.out.println("Кот № " + (i + 1) + " " + cat.getStatus());
	}

	private static void lesson3()
	{
		/**
		 * УРОК 3 Метод, параметры, return
		 * - Создать в классе Cat метод, который будет возвращать массу съеденной еды
		 * - Создать в классе Cat метод “сходить в туалет”, который будет уменьшать вес кошки и что-­нибудь печатать.
		 */
		System.out.println("LESSON 3");
		/**
		 * Все наши прошлы коты умерли
		 * Создаем новых котов
		 */
		System.out.println("Берем новых котов");
		Integer catsCount = 3;
		Cat[] catsNew = new Cat[catsCount];
		for (Integer i = 0; i < catsCount; i++)
		{
			catsNew[i] = new Cat();
			System.out.println("Новый кот № " + (i + 1) + " имеет вес: " + catsNew[i].getWeight() + " гр.");
		}
		/**
		 * Кормим и поим новых котов
		 */
		for (Integer i = 0; i < catsCount; i++)
		{
			catsNew[i].feed(  50  + 50 * Math.random() );
			catsNew[i].drink( 100 + 10 * Math.random() );

		}
		System.out.println("Новые коты поели и попили");
		/**
		 * Вспоминаем массу последней еды и питья
		 */
		for (Integer i = 0; i < catsCount; i++)
		{
			System.out.println("Новый кот № " + (i + 1) + ": Последняя еда " + catsNew[i].getLastFoodWeight() + " гр. " +
					"Последнее питье " + catsNew[i].getLastDrinkWeight() + " гр. ");
			System.out.println("Новый кот № " + (i + 1) + " имеет вес: " + catsNew[i].getWeight() + " гр.");
		}

		/**
		 * Кошаки пошли в туалет, но не все захотели
		 * те кто не захотел помяукали
		 */
		for (Integer i = 0; i < catsCount; i++)
		{
			if (Math.random() > 0.5)
			{
				System.out.print("Новый кот № " + (i + 1));
				catsNew[i].goToToilet();
			} else
			{
				System.out.print("Новый кот № " + (i + 1) + " ");
				catsNew[i].meow();
			}
			System.out.println("Новый кот № " + (i + 1) + " " + catsNew[i].getStatus());
		}

		//это вообще крутая штука!!!
		//подглядел в примере с машинами)))
		for (Cat cat : catsNew)
		{
			cat.kill();
			System.out.println(cat.getStatus());
		}
	}
	private static void lesson4()
	{
		/**
		 * УРОК 4 Статические методы и переменные
		 *
		 * - Создать у класса Cat статическую переменную count, которая будет увеличиваться, если кошку создали,
		 *  и убывать, если кошка взорвалась или умерла, и статический метод getCount(),
		 *  который будет возвращать количество кошек.
		 */
		System.out.println("LESSON 4");
		//создаем котов не в коробках
		Cat manya = new Cat();
		Cat vasya = new Cat();

		System.out.println("Weight manya: " + manya.getWeight());
		System.out.println("Weight vasya: " + vasya.getWeight());
		System.out.println("Difference weight manya and vasya: " + Cat.getWeightDifference(manya, vasya));

		System.out.println("Cats count: " + Cat.getCount()); // 2
		System.out.println();
		//взрываем кота manya
		manya.feed(9000.0);
		System.out.println("manya: " + manya.getStatus());
		System.out.println("Cats count: " + Cat.getCount()); // 1
		//еще раз взрываем взовранного кота
		manya.feed(9000.0);
		System.out.println("manya: " + manya.getStatus());
		System.out.println("Cats count: " + Cat.getCount()); // 1
		//количество не уменьшилось
		//создаем кота без коробки с нормальным именем
		Cat barsik = new Cat();
		System.out.println("Create cat barsik");
		System.out.println("Cats count: " + Cat.getCount()); // 2
	}

	private static void lesson5()
	{
		/**
		 * УРОК 5 Создание объектов и конструктор
		 *
		 * - Создать в классе Cat ещё один конструктор так, чтобы массу кошки можно было задавать при создании кошки,
		 * и создать в главном классе метод генерации кошки, как описано в видеоуроке.
		 */
		System.out.println("LESSON 5");

		System.out.println("Создаем кота весом 5000");
		Cat cat5000 = new Cat(5000.0);
		System.out.println("Вес кота5000 = " + cat5000.getWeight());

		System.out.println("Создаем котенка");
		Cat kitten = getKitten();
		System.out.println("Вес котенка = " + kitten.getWeight());
	}

	private static void lesson6()
	{
		/**
		 * УРОК 6 Копирование объектов
		 *
		 * - Создать у кошки метод создания её “глубокой” копии.
		 */
		System.out.println("LESSON 6");
		System.out.println("Create Shiro");
		Cat shiro = new Cat();
		System.out.println("Shiro weight "	+ shiro.getWeight());

		System.out.println("Shiro eating and drinking...");
		shiro.feed(  50.0);
		shiro.drink(10.0);

		System.out.println("Shiro weight "	+ shiro.getWeight());
		System.out.println("Shiro last feed " + shiro.getLastFoodWeight() +
				" last drink " + shiro.getLastDrinkWeight() );

		System.out.println("Создаем  kuro как близнеца shiro");
		Cat kuro = shiro.createTwin();

		System.out.println("Shiro weight "	+ shiro.getWeight());
		System.out.println("Shiro last feed " + shiro.getLastFoodWeight() +
				" last drink " + shiro.getLastDrinkWeight() );

		System.out.println("Kuro weight "  	+ kuro.getWeight());
		System.out.println("Kuro last feed " + kuro.getLastFoodWeight() +
				" kuro drink " + kuro.getLastDrinkWeight() );
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Integer commandNum;
		do
		{
			System.out.println("=====================================");
			System.out.println("Введите число. Доступные команды:");
			System.out.println("0 - узнать количество котов");
			System.out.println("10 - выйти из программы");
			System.out.println("Или введите номер урока [2-6]");
			System.out.println("Ваша команда?");
			commandNum = in.nextInt();
			switch (commandNum)
			{
				case 0:
					System.out.println();
					System.out.println("Количество котов: " + Cat.getCount());
					System.out.println();
					break;
				case 2:
					lesson2();
					break;
				case 3:
					lesson3();
					break;
				case 4:
					lesson4();
					break;
				case 5:
					lesson5();
					break;
				case 6:
					lesson6();
					break;
				case 10:
					System.out.println("Выход из программы...");
					break;
			}
		} while (commandNum != 10);
	}

	private static Cat getKitten()
	{
		Cat kitten = new Cat(Math.floor(100 + 50 * Math.random()));
		return kitten;
	}
}
