public class Millimeter extends BasicMetric {
    public Millimeter(ImperialUnits unit) {
        super(unit);
    }
    public double toConvert(double num) {
        switch(unit){
            case feet:
                return num * 0.0032;
            case inch:
                return num * 0.039;
        }
        return 0;
    }
}
