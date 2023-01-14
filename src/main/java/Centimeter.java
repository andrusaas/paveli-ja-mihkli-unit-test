public class Centimeter extends BasicMetric{
    public Centimeter(ImperialUnits unit) {
        super(unit);
    }
    public double toConvert(double num) {
        switch(unit){
            case feet:
                return num * 0.032;
            case inch:
                return num * 0.39;
        }
        return 0;
    }
}
