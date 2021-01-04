package com.anastasios.spring.microservices.app.controller;

import com.anastasios.spring.microservices.app.versioning.Name;
import com.anastasios.spring.microservices.app.versioning.PersonV1;
import com.anastasios.spring.microservices.app.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    /*
        Basic versioning can be applied by mapping different URIs depending on the version needed.
        e.g. @GetMapping("v1/person") and @GetMapping("v2/person")

        Other ways of versioning:
        Request Params
        e.g. @GetMapping(value = "/person/params", params="version=1") and @GetMapping(value = "/person/params", params="version=2")

        Header Params
        e.g. @GetMapping(value = "/person/header", headers="X-API-VERSION=1") and @GetMapping(value = "/person/header", headers="X-API-VERSION=2")

        Produces
        e.g. @GetMapping(value = "/person/produces", produces="application/vnd.company.app-v1+json") and @GetMapping(value = "/person/produces", produces="application/vnd.company.app-v2+json")
     */

    //@GetMapping("v1/person") and @GetMapping("v2/person")
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //@GetMapping(value = "/person/params", params="version=1") and @GetMapping(value = "/person/params", params="version=2")
    @GetMapping(value = "/person/params", params = "version=1")
    public PersonV1 requestParamsV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/params", params = "version=2")
    public PersonV2 requestParamsV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //@GetMapping(value = "/person/header", headers="X-API-VERSION=1") and @GetMapping(value = "/person/header", headers="X-API-VERSION=2")
    @GetMapping(value = "/person/params", headers = "X-API-VERSION=1")
    public PersonV1 headerParamsV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/params", headers = "X-API-VERSION=2")
    public PersonV2 headerParamsV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //@GetMapping("/person/produces", produces="application/vnd.company.app-v1+json") and @GetMapping("/person/produces", produces="application/vnd.company.app-v1+json")
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


}
