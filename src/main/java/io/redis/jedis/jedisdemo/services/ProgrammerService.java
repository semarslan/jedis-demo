package io.redis.jedis.jedisdemo.services;

import io.redis.jedis.jedisdemo.model.Programmer;

import java.util.List;

public interface ProgrammerService {

    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String key);

    void AddToProgrammersList(Programmer programmer);

    List<Programmer> getProgrammersListMembers();

    Long getProgrammersListCount();
}
