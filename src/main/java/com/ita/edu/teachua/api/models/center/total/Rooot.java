package com.ita.edu.teachua.api.models.center.total;

import lombok.Data;

import java.util.List;

@Data
public class Rooot {
    public int totalElements;
    public int totalPages;
    public int number;
    public Sort sort;
    public int size;
    public List<Content> content;
    public boolean first;
    public boolean last;
    public int numberOfElements;
    public Pageable pageable;
    public boolean empty;
}
