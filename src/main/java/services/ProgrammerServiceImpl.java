package services;

import dao.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
