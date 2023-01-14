import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //first comment
        Scanner scn = new Scanner(System.in);
        System.out.print("Please choose the system to operate(imperial or metric): ");
        String result = scn.nextLine().toLowerCase();

        if (result.equals(Measuring.imperial.name())) {
            System.out.println("Imperial system activated!");
            System.out.println("\nChoose unit from the list below to use:");

            for (ImperialUnits unitI : ImperialUnits.values()) {
                System.out.println(unitI);
            }
            System.out.print("Type here: ");
            String optionI = scn.nextLine().toLowerCase();
            ImperialUnits iUnit = ImperialUnits.valueOf(optionI);
            MetricUnits mUnit = convertMetric(scn);

            switch (iUnit) {
                case feet:
                    Feet feet = new Feet(mUnit);
                    performOperation(mUnit, iUnit, scn, feet);
                    break;
                case inch:
                    Inch inch = new Inch(mUnit);
                    performOperation(mUnit, iUnit, scn, inch);
                    break;
            }
        } else if (result.equals(Measuring.metric.name())) {
            System.out.println("Metric system activated!");
            System.out.println("\nChoose unit from the list below to use:");

            for (MetricUnits unitM : MetricUnits.values()) {
                System.out.println(unitM);
            }
            System.out.print("Type here: ");
            String optionM = scn.nextLine().toLowerCase();
            MetricUnits mUnit = MetricUnits.valueOf(optionM);
            ImperialUnits iUnit = convertImperial(scn);

            switch (mUnit) {
                case cm:
                    Centimeter centimeter = new Centimeter(iUnit);
                    performOperation(mUnit, iUnit, scn, centimeter);
                    break;
                case m:
                    Meter meter = new Meter(iUnit);
                    performOperation(mUnit, iUnit, scn, meter);
                    break;
                case mm:
                    Millimeter millimeter = new Millimeter(iUnit);
                    performOperation(mUnit, iUnit, scn, millimeter);
                    break;
            }
        } else {
            System.out.println("Not a valid definition!");
        }
    }

    private static ImperialUnits convertImperial(Scanner scn) {
        System.out.println("\nChoose unit from the list below to convert:");
        for (ImperialUnits unitI : ImperialUnits.values()) {
            System.out.println(unitI);
        }
        System.out.print("Type here: ");
        String optionI = scn.nextLine().toLowerCase();
        ImperialUnits iUnit = ImperialUnits.valueOf(optionI);
        return iUnit;
    }

    public static MetricUnits convertMetric(Scanner scn) {
        System.out.println("\nChoose unit from the list below to convert:");
        for (MetricUnits unitM : MetricUnits.values()) {
            System.out.println(unitM);
        }
        System.out.print("Type here: ");
        String optionM = scn.nextLine().toLowerCase();
        MetricUnits mUnit = MetricUnits.valueOf(optionM);
        return mUnit;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void performOperation(MetricUnits mUnit, ImperialUnits iUnit, Scanner scn, BasicImperial basic) {
        System.out.print("Enter the value to convert from " + iUnit + " to " + mUnit + ": ");
        String value = scn.nextLine();
        if (isNumeric(value)) {
            double input = Double.parseDouble(value);
            DecimalFormat df = new DecimalFormat("0.00");
            if (basic instanceof Feet) {
                Feet feet = (Feet) basic;
                double reply = feet.toConvert(input);
                System.out.printf(value + " " + iUnit + " equals " + df.format(reply) + mUnit);
            }
            if (basic instanceof Inch) {
                Inch inch = (Inch) basic;
                double reply = inch.toConvert(input);
                System.out.printf(value + " " + iUnit + " equals " + df.format(reply) + mUnit);
            }
        } else {
            System.out.println("Entered value is not a number!");
        }
    }

    public static void performOperation(MetricUnits mUnit, ImperialUnits iUnit, Scanner scn, BasicMetric basic) {
        System.out.print("Enter the value to convert from " + mUnit + " to " + iUnit + ": ");
        String value = scn.nextLine();
        if (isNumeric(value)) {
            double input = Double.parseDouble(value);
            DecimalFormat df = new DecimalFormat("0.00");
            if (basic instanceof Centimeter) {
                Centimeter centimeter = (Centimeter) basic;
                double reply = centimeter.toConvert(input);
                System.out.printf(value + " " + mUnit + " equals " + df.format(reply) + iUnit);
            }
            if (basic instanceof Millimeter) {
                Millimeter millimeter = (Millimeter) basic;
                double reply = millimeter.toConvert(input);
                System.out.printf(value + " " + mUnit + " equals " + df.format(reply) + iUnit);
            }
            if (basic instanceof Meter) {
                Meter meter = (Meter) basic;
                double reply = meter.toConvert(input);
                System.out.printf(value + " " + mUnit + " equals " + df.format(reply) + iUnit);
            }
        } else {
            System.out.println("Entered value is not a number!");
        }
    }
}