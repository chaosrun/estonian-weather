package run.chaos.weather.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "forecast_period")
public class ForecastPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forecast_period_id")
    private int id;

    @NotBlank
    @Column(name = "phenomenon")
    private String phenomenon;

    @NotNull
    @Column(name = "temp_min")
    private int tempMin;

    @NotNull
    @Column(name = "temp_max")
    private int tempMax;

    @NotBlank
    @Column(name = "text")
    private String text;

    @Column(name = "sea", length = 1024)
    private String sea;

    @Column(name = "peipsi")
    private String peipsi;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_period_id")
    private List<Place> places;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_period_id")
    private List<Wind> winds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSea() {
        return sea;
    }

    public void setSea(String sea) {
        this.sea = sea;
    }

    public String getPeipsi() {
        return peipsi;
    }

    public void setPeipsi(String peipsi) {
        this.peipsi = peipsi;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Wind> getWinds() {
        return winds;
    }

    public void setWinds(List<Wind> winds) {
        this.winds = winds;
    }

}
