package vesit.ajayk57.mc.practical2;

public class Distance {
    double value;
    UnitType unitType;
    enum UnitType{
        MM,
        CM,
        M,
        KM;
        public static UnitType create(int id) {
            switch (id){
                case 0:
                    return MM;
                case 1:
                    return CM;
                case 2:
                    return M;
                default:
                    return KM;
            }
        }
    }
    private double toM(double distance){
        switch (unitType){
            case MM:
                return distance*0.001;
            case CM:
                return distance*0.01;
            case KM:
                return distance*1000;
            default:
                return distance;
        }
    }
    public Distance(double value, UnitType unitType){
        this.value=value;
        this.unitType=unitType;
    }
    public Distance to(UnitType type){
        double inM= toM(value);
        double inType=inM;
        switch (type){
            case MM:
                inType=inM*1000;
                break;
            case CM:
                inType=inM*100;
                break;
            case KM:
                inType=inM/1000;
                break;
        }
        return new Distance(inType,type);
    }
    public double getValue(){
        return value;
    }
}
