package run.chaos.weather.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "forecast")
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forecast_id")
    private int id;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_night_id", referencedColumnName = "forecast_period_id")
    private ForecastPeriod night;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_day_id", referencedColumnName = "forecast_period_id")
    private ForecastPeriod day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ForecastPeriod getNight() {
        return night;
    }

    public void setNight(ForecastPeriod night) {
        this.night = night;
    }

    public ForecastPeriod getDay() {
        return day;
    }

    public void setDay(ForecastPeriod day) {
        this.day = day;
    }

}
