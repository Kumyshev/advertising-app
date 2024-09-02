package com.akhmed.demo_advertising.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.akhmed.demo_advertising.model.User;

public class UserSpecifications {

    public static Specification<User> hasName(String name) {
        return (root, query, cb) -> cb.equal(
                root.get("name"),
                StringUtils.isBlank(name) ? "" : name);
    }
}
