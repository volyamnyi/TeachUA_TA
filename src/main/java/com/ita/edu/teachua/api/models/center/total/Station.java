package com.ita.edu.teachua.api.models.center.total;

import com.ita.edu.teachua.api.models.center.total.Distict;
import lombok.Data;

@Data
public class Station {
    public int id;
    public String name;
    public City city;
    public Distict district;
}
