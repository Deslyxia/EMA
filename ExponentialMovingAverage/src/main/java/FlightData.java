import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by deslyxia on 6/23/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightData {
    private Date dateFact;
    private Integer firstPartyDiscrepancy;
    private Integer thirdPartyDiscrepancy;
    private Double emaFirstPartyDiscrepancy;
    private Double emaThirdPartyDiscrepancy;
    private Float thirdPartyFlightDiscrepancy;
    private Float emaThirdPartyFlightDiscrepancy;

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyy");

    @JsonProperty("date")
    public Date getDateFact() {
        return dateFact;
    }
    @JsonProperty("date")
    public void setDateFact(String date) {
        try {
            this.dateFact = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @JsonProperty("impFirst")
    public Integer getFirstPartyDiscrepancy() {
        return firstPartyDiscrepancy;
    }
    @JsonProperty("impFirst")
    public void setFirstPartyDiscrepancy(Integer firstPartyDiscrepancy) {
        this.firstPartyDiscrepancy = firstPartyDiscrepancy;
    }
    @JsonProperty("impThird")
    public Integer getThirdPartyDiscrepancy() {
        return thirdPartyDiscrepancy;
    }
    @JsonProperty("impThird")
    public void setThirdPartyDiscrepancy(Integer thirdPartyDIscrepancy) {
        this.thirdPartyDiscrepancy = thirdPartyDIscrepancy;
    }

    public Double getEmaFirstPartyDiscrepancy() {
        return emaFirstPartyDiscrepancy;
    }

    public void setEmaFirstPartyDiscrepancy(Double emaFirstPartyDiscrepancy) {
        this.emaFirstPartyDiscrepancy = emaFirstPartyDiscrepancy;
    }

    public Double getEmaThirdPartyDiscrepancy() {
        return emaThirdPartyDiscrepancy;
    }

    public void setEmaThirdPartyDiscrepancy(Double emaThirdPartyDiscrepancy) {
        this.emaThirdPartyDiscrepancy = emaThirdPartyDiscrepancy;
    }

    public Float getThirdPartyFlightDiscrepancy() {
        return thirdPartyFlightDiscrepancy;
    }

    public void setThirdPartyFlightDiscrepancy(Float thirdPartyFlightDiscrepancy) {
        this.thirdPartyFlightDiscrepancy = thirdPartyFlightDiscrepancy;
    }

    public Float getEmaThirdPartyFlightDiscrepancy() {
        return emaThirdPartyFlightDiscrepancy;
    }

    public void setEmaThirdPartyFlightDiscrepancy(Float emaThirdPartyFlightDiscrepancy) {
        this.emaThirdPartyFlightDiscrepancy = emaThirdPartyFlightDiscrepancy;
    }
}
