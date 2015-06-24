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


        System.out.println("Date       tpImp   fpImp emaTpImp  emaFpImp     emaDiscrep ");

        for(Date key : fdMap.keySet()){
            FlightData  fd = fdMap.get(key);
            Double emaFp = fpEma.average(fd.getFirstPartyDiscrepancy());
            Double emaTp = tpEma.average(fd.getThirdPartyDiscrepancy());
            fd.setEmaFirstPartyDiscrepancy(emaFp);
            fd.setEmaThirdPartyDiscrepancy(emaTp);
            fd.setEmaThirdPartyFlightDiscrepancy((emaTp/emaFp)-1);
            System.out.println(sdf.format(key) + "  " + fd.getThirdPartyDiscrepancy() + "   " + fd.getFirstPartyDiscrepancy()
                    + "   " + fd.getEmaThirdPartyDiscrepancy() + "   " + fd.getEmaFirstPartyDiscrepancy() + " " + fd.getEmaThirdPartyFlightDiscrepancy());

        }
    }
}
