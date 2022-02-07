package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.Date;

@Data
public class Feedback {
    public int id;
    public int rate;
    public Date date;
    public String text;
    public User user;
    public String club;
}
