package com.ita.edu.teachua.api.models.center.total;

import com.ita.edu.teachua.api.models.center.pageable_response.Sort;
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
