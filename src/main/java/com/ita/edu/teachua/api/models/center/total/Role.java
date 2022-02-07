package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    public int id;
    public String name;
    public List<String> users;
}
