package app;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class App {
    public static void main(String[] args) {
        System.out.println("Calculating Total Fuel Needed.....");
        List<Integer> masses = getMassesFromFile();
        Integer totalFuelNeeded = masses.stream()
            .mapToInt(x->calculateFuelNeeded(x))
            .sum();
        System.out.println("Answer: " + totalFuelNeeded);
    }

    private static List<Integer> getMassesFromFile() {
        File f = new File("src/inputs.txt");
        if (f.canRead()) {
            List<String> lines;
			try {
				lines = FileUtils.readLines(f, "UTF-8");
			} catch (IOException e) {
                return Collections.emptyList();
			}
            return lines.stream().map(s->Integer.parseInt(s)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private static int calculateFuelNeeded(int mass) {
        return mass / 3 - 2;
    }
}