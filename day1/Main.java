package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        solution();
    }
    public static void solution() {
        int lineNumber = 0;
        int currentTotal = 0;
        int highestTotal = 0;

        int topA = 0;
        int topB = 0;
        int topC = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader("/Users/rbrunning/advent-of-code/solutions/src/day1/day-1-data.txt"));
            String line;

            while ((line = in.readLine()) != null) {
                // Part A
                if (!line.equals("")) {
                    int i = parseInt(line);
                    currentTotal += i;
                }

                if (line.equals("")) {
                    if (currentTotal > highestTotal)
                        highestTotal = currentTotal;

                    // Part B
                    if (topA == 0 || topB == 0 || topC == 0) {
                        if (topA == 0)
                            topA = currentTotal;
                        else if (topB == 0)
                            topB = currentTotal;
                        else
                            topC = currentTotal;
                    } else {
                        if (currentTotal > topA && topA < topB && topA < topC) {
                            topA = currentTotal;
                        } else if (currentTotal > topB && topB < topA && topB < topC) {
                            topB = currentTotal;
                        } else if (currentTotal > topC && topC < topA && topC < topB)
                            topC = currentTotal;
                    }
                    currentTotal = 0;
                }
                lineNumber++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Highest calories: " + highestTotal);
        System.out.println("Sum of top three: " + (topA + topB + topC));
    }
}