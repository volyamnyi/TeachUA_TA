package com.ita.edu.teachua.api.models.category.search_response;

import lombok.Data;

@Data
public class Pageable {
    public Sort sort;
    public int offset;
    public int pageNumber;
    public int pageSize;
    public boolean paged;
    public boolean unpaged;
}
