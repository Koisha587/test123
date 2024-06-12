package Weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Headline",
        "DailyForecasts"
})
public class Weather {

    @JsonProperty("Headline")
    private HeadLine headline;
    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts;

    @JsonProperty("Headline")
    public HeadLine getHeadline() {
        return headline;
    }

    @JsonProperty("Headline")
    public void setHeadline(HeadLine headline) {
        this.headline = headline;
    }

    @JsonProperty("DailyForecasts")
    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    @JsonProperty("DailyForecasts")
    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

}
