package com.franklinconza.theocratic.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFindResponseRepository extends JpaRepository<UserFindResponse, Integer> {

    @Query(value =
            "select " +
                    "users.user_id as id, " +
                    "users.name as name " +
                    "from security.users users " +
                    "inner join security.permissions permission on (permission.user_id = users.user_id) " +
                    "inner join security.roles role on (role.role_id = permission.role_id) " +
                    "where role.role_id = :roleId " +
                    "order by users.name"
            , nativeQuery = true)
    List<UserFindResponse> findUserByRol(@Param("roleId") int roleId);
}
