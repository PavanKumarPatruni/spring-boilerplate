package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Slf4j
public class Pagination {

    private static final String ASC = "asc";
    private static final String DESC = "desc";

    public static Sort getSort(String sortBy, String orderBy) {
        log.info("sortBy: {}, orderBy: {}", sortBy, orderBy);
        Sort sort = Sort.by(sortBy).descending();

        if (orderBy.equals(ASC)) {
            sort = sort.ascending();
        }

        return sort;
    }

    public static Pageable getPageable(Integer pageNo, Integer pageSize, String sortBy) {
        log.info("pageNo: {}, pageSize: {}", pageNo, pageSize);

        return PageRequest.of(pageNo, pageSize, getSort(sortBy, DESC));
    }

    public static Pageable getPageable(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        log.info("pageNo: {}, pageSize: {}", pageNo, pageSize);

        return PageRequest.of(pageNo, pageSize, getSort(sortBy, orderBy));
    }

}
