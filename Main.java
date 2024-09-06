package gb.core.homework;

import java.util.Arrays;

/**
 * 1. Построить три класса (базовый и 2 потомка),
 * описывающих некоторых работников с почасовой оплатой (один из потомков) и фиксированной оплатой (второй потомок).
 * <p>
 * а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
 * Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
 * для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
 * <p>
 * б) Создать на базе абстрактного класса массив сотрудников и заполнить его.
 * <p>
 * в) ** Реализовать интерфейсы для возможности сортировки массива
 * (обратите ваше внимание на интерфейсы Comparator, Comparable)
 * <p>
 * г) ** Создать класс, содержащий массив сотрудников, и реализовать возможность вывода данных с использованием foreach.
 */

public class Main {
    public static void main(String[] args) {
        Worker[] workers = getWorkers();
        Arrays.sort(workers);
        print(workers);
    }

    public static Worker[] getWorkers() {
        return new Worker[]{
                new FixedWorker("Jonny", 60_000),
                new FixedWorker("Sofia", 50_000),
                new HourlyWorker("Arthur", 2000, 40),
                new HourlyWorker("David", 3000, 35),
        };
    }

    public static void print(Worker[] workers) {
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
