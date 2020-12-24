package io.redis.jedis.jedisdemo.services;

import io.redis.jedis.jedisdemo.dao.ProgrammerRepository;
import io.redis.jedis.jedisdemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProgrammerServiceImpl implements ProgrammerService{

    @Autowired
    ProgrammerRepository programmerRepository;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        programmerRepository.setProgrammerAsString(idKey, programmer);
    }

    @Override
    public String getProgrammerAsString(String key) {
        return programmerRepository.getProgrammerAsString(key);
    }

    @Override
    public void AddToProgrammersList(Programmer programmer) {
        programmerRepository.AddToProgrammerList(programmer);
    }

    @Override
    public List<Programmer> getProgrammersListMembers() {
        return programmerRepository.getProgrammerListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return programmerRepository.getProgrammersListCount();
    }

    @Override
    public void AddToProgrammersSet(Programmer... programmers) {
        programmerRepository.AddToProgrammersSet(programmers);
    }

    @Override
    public Set<Programmer> getProgrammersSetMembers() {
        return programmerRepository.getProgrammersSetMembers();
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return programmerRepository.isSetMember(programmer);
    }

    @Override
    public void saveHash(Programmer programmer) {
        programmerRepository.saveHash(programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        programmerRepository.updateHash(programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllHash() {
        return programmerRepository.findAllHash();
    }

    @Override
    public Programmer findInHash(int id) {
        return programmerRepository.findInHash(id);
    }

    @Override
    public void deleteHash(int id) {
        programmerRepository.deleteHash(id);
    }
}
