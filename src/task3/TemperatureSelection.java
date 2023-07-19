package task3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TemperatureSelection {
    public static void main(String[] args) {
        int[] dailyTemperatures = {8, 12, 15, 9, 11, 10, 13};
        int minTemperature = 10;
        int maxTemperature = 13;
        int[] selectedTemperatures = filterTemperaturesByRange(dailyTemperatures, minTemperature, maxTemperature);
        printSelectedTemperatures(selectedTemperatures);
    }

    private static int[] filterTemperaturesByRange(int[] temperatures, int minTemperature, int maxTemperature) {
        return IntStream.of(temperatures)
                .filter(temperature -> temperature >= minTemperature && temperature <= maxTemperature)
                .toArray();
    }

    private static void printSelectedTemperatures(int[] temperatures) {
        AtomicInteger counter = new AtomicInteger(1);
        IntStream.of(temperatures)
                .forEach(temperature -> System.out.println(counter.getAndIncrement() + ") " + temperature));
    }
}
