package com.ita.edu.teachua.api.models.category.search_response;

import lombok.Data;

import java.util.List;

@Data
public class CategoryRoot2 {
    public List<Content> content;
    public Pageable pageable;
    public boolean last;
    public int totalElements;
    public int totalPages;
    public int number;
    public Sort sort;
    public int size;
    public boolean first;
    public int numberOfElements;
    public boolean empty;
}
