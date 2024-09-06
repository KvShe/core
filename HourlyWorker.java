package gb.core.homework;

public class HourlyWorker extends Worker {
    private int amountHours;

    public HourlyWorker(String name, int flatRate, int amountHours) {
        super(name, flatRate);
        this.amountHours = amountHours;
    }

    @Override
    public double calculateOfAverageMonthlySalary() {
        return 20.8 * 8 * flatRate;
    }

    @Override
    public String toString() {
        return name + ": " + flatRate + " flat rate, " + amountHours + " hours";
    }
}
