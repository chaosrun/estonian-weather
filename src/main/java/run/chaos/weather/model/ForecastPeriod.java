package run.chaos.weather.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "forecast_period")
public class ForecastPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "forecast_period_id")
    private int id;

    @NotBlank
    @Column(name = "phenomenon", length = 4096)
    private String phenomenon;

    @NotNull
    @Column(name = "temp_min")
    private Integer tempMin;

    @NotNull
    @Column(name = "temp_max")
    private Integer tempMax;

    @NotBlank
    @Column(name = "text", length = 4096)
    private String text;

    @Column(name = "sea", length = 4096)
    private String sea;

    @Column(name = "peipsi", length = 4096)
    private String peipsi;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_period_id")
    private List<Place> places;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_period_id")
    private List<Wind> winds;
}
