package com.spring.guide.guide.config.security.UserDetails;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    Users getByUid(String uid);
}
