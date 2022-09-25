package run.chaos.weather.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "wind")
public class Wind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wind_id")
    private int id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "direction")
    private String direction;

    @NotNull
    @Column(name = "speed_min")
    private int speedMin;

    @NotNull
    @Column(name = "speed_max")
    private int speedMax;

    @Column(name = "gust")
    private int gust;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_period_id", referencedColumnName = "forecast_period_id")
    private ForecastPeriod forecastPeriod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpeedMin() {
        return speedMin;
    }

    public void setSpeedMin(int speedMin) {
        this.speedMin = speedMin;
    }

    public int getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(int speedMax) {
        this.speedMax = speedMax;
    }

    public int getGust() {
        return gust;
    }

    public void setGust(int gust) {
        this.gust = gust;
    }

    public ForecastPeriod getForecastPeriod() {
        return forecastPeriod;
    }

    public void setForecastPeriod(ForecastPeriod forecastPeriod) {
        this.forecastPeriod = forecastPeriod;
    }

}
