package io.redis.jedis.jedisdemo.dao;

import io.redis.jedis.jedisdemo.model.Programmer;

import java.util.List;
import java.util.Set;

public interface ProgrammerRepository {

//    Strnig
    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String idKey);


//    list
    void AddToProgrammerList(Programmer programmer);

    List<Programmer> getProgrammerListMembers();

    Long getProgrammersListCount();

//    SET
    void AddToProgrammersSet(Programmer ... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);
}
