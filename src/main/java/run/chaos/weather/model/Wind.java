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
    private Integer speedMin;

    @NotNull
    @Column(name = "speed_max")
    private Integer speedMax;

    @Column(name = "gust")
    private Integer gust;

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

    public Integer getSpeedMin() {
        return speedMin;
    }

    public void setSpeedMin(Integer speedMin) {
        this.speedMin = speedMin;
    }

    public Integer getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(Integer speedMax) {
        this.speedMax = speedMax;
    }

    public Integer getGust() {
        return gust;
    }

    public void setGust(int gust) {
        this.gust = gust;
    }

}
