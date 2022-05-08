package com.franklinconza.theocratic.ministry.call;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CallFindResponseRepository extends JpaRepository<CallFindResponse, String> {

    @Query(value =
            "select " +
                    "call.call_id as id, " +
                    "call.conductor_id as conductor_id, " +
                    "conductor.name as conductor, " +
                    "phone.number as phone, " +
                    "phone.owner as owner, " +
                    "publisher.user_id as publisher_id, " +
                    "publisher.name as publisher, " +
                    "state.state_id as state_id, " +
                    "state.name as state, " +
                    "call.observation as observation " +
                    "from ministry.calls call " +
                    "inner join ministry.phones phone on (phone.phone_id = call.phone_id) " +
                    "inner join security.users conductor on (conductor.user_id = call.conductor_id) " +
                    "left join security.users publisher on (publisher.user_id = call.publisher_id) " +
                    "left join ministry.states state on (state.state_id = call.state_id) " +
                    "where " +
                    "call.date = :date and " +
                    "call.section = :section " +
                    //"call.state_id is null " +
                    "order by owner"
            , nativeQuery = true)
    List<CallFindResponse> findCallByDateAndSection(@Param("date") Date date, @Param("section") String section);
}
