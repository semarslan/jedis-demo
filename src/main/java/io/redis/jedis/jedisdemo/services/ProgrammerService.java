package io.redis.jedis.jedisdemo.services;

import io.redis.jedis.jedisdemo.model.Programmer;

import java.util.List;
import java.util.Set;

public interface ProgrammerService {

    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String key);

    void AddToProgrammersList(Programmer programmer);

    List<Programmer> getProgrammersListMembers();

    Long getProgrammersListCount();

    void AddToProgrammersSet(Programmer ... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);
}
