import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

/**
 * Created by deslyxia on 6/23/15.
 */
public class Main {

    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyy");
        ExponentialMovingAverage fpEma = new ExponentialMovingAverage(.4);
        ExponentialMovingAverage tpEma = new ExponentialMovingAverage(.4);
        JsonDeserialize jsonDeserialize = new JsonDeserialize();
        TreeMap<Date, FlightData> fdMap = jsonDeserialize.getFightData();


        System.out.println("Date       tpImp   fpImp    emaTpImp  emaFpImp ");

        for(Date key : fdMap.keySet()){
            FlightData  fd = fdMap.get(key);
            fd.setEmaFirstPartyDiscrepancy(fpEma.average(fd.getFirstPartyDiscrepancy()));
            fd.setEmaThirdPartyDiscrepancy(tpEma.average(fd.getThirdPartyDiscrepancy()));
            System.out.println(sdf.format(key) + "  " + fd.getThirdPartyDiscrepancy() + "   " + fd.getFirstPartyDiscrepancy()
                    + "   " + fd.getEmaThirdPartyDiscrepancy() + "   " + fd.getEmaFirstPartyDiscrepancy());

        }
    }
}
