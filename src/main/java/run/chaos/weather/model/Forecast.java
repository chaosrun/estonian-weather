package run.chaos.weather.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_night_id", referencedColumnName = "forecast_period_id")
    private ForecastPeriod night;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_day_id", referencedColumnName = "forecast_period_id")
    private ForecastPeriod day;
}
