package com.anastasios.spring.microservices.app.controller;

import com.anastasios.spring.microservices.app.beans.FilteredUser;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    /*
       Filter out the password field of FilteredUser dynamically.
    */
    @GetMapping("/filtering-no-password")
    public MappingJacksonValue getFilteredUser() {
        FilteredUser filteredUser = new FilteredUser("name", 35, "12345678");

        return addDynamicFiltering(filteredUser, "age");
    }

    /*
      Filter out the age field of FilteredUser dynamically.
   */
    @GetMapping("/filtering-no-age")
    public MappingJacksonValue getDynamicFilteredUser() {
        FilteredUser filteredUser = new FilteredUser("name", 35, "12345678");

        //Filter out all fields in the response except the ones needed.
        return addDynamicFiltering(filteredUser, "password");
    }

    // add filtering and reduce code duplication
    private MappingJacksonValue addDynamicFiltering(FilteredUser filteredUser, String age) {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", age);

        FilterProvider filters = new SimpleFilterProvider().addFilter("FilteredUserFilter", simpleBeanPropertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(filteredUser);
        mapping.setFilters(filters);

        return mapping;
    }
}
