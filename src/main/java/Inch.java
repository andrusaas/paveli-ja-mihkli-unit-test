public class Inch extends BasicImperial{
    public Inch(MetricUnits unit) {
        super(unit);
    }
    public double toConvert(double num) {
        switch(unit){
            case cm:
                return num * 2.54;
            case mm:
                return num * 25.4;
            case m:
                return num * 0.0254;
        }
        return 0;
    }
}
