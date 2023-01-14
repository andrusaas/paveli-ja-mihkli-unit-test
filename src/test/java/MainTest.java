import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    ByteArrayOutputStream outputStreamListener = null;

    @BeforeEach
    void setupOutputListener() {
        outputStreamListener = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamListener));
    }

    @Test
    void testPerformOperationConvertsRejectsInvalidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("not a number".getBytes());
        Scanner scanner = new Scanner(in);

        Feet feet = new Feet(MetricUnits.m);

        Main.performOperation(MetricUnits.m, ImperialUnits.feet, scanner, feet);

        String output = outputStreamListener.toString();

        String expectedErrorMessasge = "Expected output with error message ";

        assertTrue(output.endsWith(
                "Entered value is not a number!\n"),
                "Expected output with error message " +
                        "'" + expectedErrorMessasge +
                        "', actual output:" + output
        );
    }

    @Test
    void testPerformOperationConvertsFeetToMeters() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        Scanner scanner = new Scanner(in);

        Feet feet = new Feet(MetricUnits.m);

        Main.performOperation(MetricUnits.m, ImperialUnits.feet, scanner, feet);

        String expectedOutput = "Enter the value to convert from feet to m: 2 feet equals 0.61m";
        String actualOutput = outputStreamListener.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPerformOperationConvertsFeetToCentimeters() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        Scanner scanner = new Scanner(in);

        Feet feet = new Feet(MetricUnits.cm);

        Main.performOperation(MetricUnits.cm, ImperialUnits.feet, scanner, feet);

        String expectedOutput = "Enter the value to convert from feet to cm: 2 feet equals 60.96cm";
        String actualOutput = outputStreamListener.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPerformOperationConvertsFeetToMillimeters() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        Scanner scanner = new Scanner(in);

        Feet feet = new Feet(MetricUnits.mm);

        Main.performOperation(MetricUnits.mm, ImperialUnits.feet, scanner, feet);

        String expectedOutput = "Enter the value to convert from feet to mm: 2 feet equals 600.96mm";
        String actualOutput = outputStreamListener.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPerformOperationConvertInchesToMillimeters() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        Scanner scanner = new Scanner(in);

        Inch feet = new Inch(MetricUnits.mm);

        Main.performOperation(MetricUnits.mm, ImperialUnits.inch, scanner, feet);

        String expectedOutput = "Enter the value to convert from inch to mm: 2 inch equals 50.80mm";
        String actualOutput = outputStreamListener.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testPerformOperationConvertInchesToCentimeters() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        Scanner scanner = new Scanner(in);

        Inch feet = new Inch(MetricUnits.mm);

        Main.performOperation(MetricUnits.mm, ImperialUnits.inch, scanner, feet);

        String expectedOutput = "Enter the value to convert from inch to mm: 2 inch equals 50.80mm";
        String actualOutput = outputStreamListener.toString();

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void testPerformOperationConvertInchesToMeters() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        Scanner scanner = new Scanner(in);

        Inch feet = new Inch(MetricUnits.m);

        Main.performOperation(MetricUnits.m, ImperialUnits.inch, scanner, feet);

        String expectedOutput = "Enter the value to convert from inch to m: 2 inch equals 0.05m";
        String actualOutput = outputStreamListener.toString();

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void testPerformOperationConvertMetersToInches() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        Scanner scanner = new Scanner(in);

        Meter meters = new Meter(ImperialUnits.inch);

        Main.performOperation(MetricUnits.m, ImperialUnits.inch, scanner, meters);

        String expectedOutput = "Enter the value to convert from m to inch: 2 m equals 78.74inch";
        String actualOutput = outputStreamListener.toString();

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}