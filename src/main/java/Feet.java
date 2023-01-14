public class Feet extends BasicImperial{
    public Feet(MetricUnits unit) {
        super(unit);
    }
    public double toConvert(double num) {
        switch(unit){
            case cm:
                return num * 30.48;
            case mm:
                return num * 300.48;
            case m:
                return num * 0.3048;
        }
        return 0;
    }
}
