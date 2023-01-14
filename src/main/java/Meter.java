public class Meter extends BasicMetric {
    public Meter(ImperialUnits unit) {
        super(unit);
    }
    public double toConvert(double num) {
        switch (unit) {
            case feet:
                return num * 3.28;
            case inch:
                return num * 39.37;
        }
        return 0;
    }
}
