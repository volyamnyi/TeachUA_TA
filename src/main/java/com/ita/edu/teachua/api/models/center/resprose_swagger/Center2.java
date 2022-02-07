
package com.ita.edu.teachua.api.models.center.resprose_swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
public class Center2 {
    public int id;
    public String name;
    public Object urlBackgroundPicture;
    public Object email;
    public Object phones;
    public String description;
    public Object urlWeb;
    public Object urlLogo;
    public Object socialLinks;
    public User user;
    public List<Location> locations;
    public Object contacts;
}

