package gb.core.homework;

import java.util.Objects;

public abstract class Worker implements Comparable<Worker> {
    protected String name;
    protected int flatRate;

    public Worker(String name, int flatRate) {
        this.name = name;
        this.flatRate = flatRate;
    }

    public double calculateOfAverageMonthlySalary() {
        return flatRate;
    }

    @Override
    public int compareTo(Worker worker) {
        return Integer.compare(worker.flatRate, this.flatRate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name + " " + flatRate + " monthly salary";
    }
}
