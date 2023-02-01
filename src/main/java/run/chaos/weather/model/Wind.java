package run.chaos.weather.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
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
    private Integer speedMin;

    @NotNull
    @Column(name = "speed_max")
    private Integer speedMax;

    @Column(name = "gust")
    private Integer gust;
}
