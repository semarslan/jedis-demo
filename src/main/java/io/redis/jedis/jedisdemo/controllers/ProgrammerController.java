package io.redis.jedis.jedisdemo.controllers;

import io.redis.jedis.jedisdemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.redis.jedis.jedisdemo.services.ProgrammerService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    @RequestMapping(method = RequestMethod.POST, value = "/programmer-string")
    public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
                mapper.writeValueAsString(programmer));

    }

    @RequestMapping("/programmer-string/{id}")
    public String readString(@PathVariable String id) {
        return programmerService.getProgrammerAsString(id);

    }

    /**
     * listeye programmer ekler
     * @param programmer
     */
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-list")
    public void addToProgrammerList(@RequestBody Programmer programmer) {
        programmerService.AddToProgrammersList(programmer);
    }

    /**
     * listedeki tüm programmerları getirir
     * @return
     */
    @RequestMapping("/programmers-list")
    public List<Programmer> getProgrammerListMembers()  {
        return programmerService.getProgrammersListMembers();
    }

    /**
     * listedeki tüm programmer verilerinin sayısını verir.
     * @return
     */
    @RequestMapping("/programmers-list/count")
    public Long getProgrammerListCount() {
        return programmerService.getProgrammersListCount();
    }

    /**
     * programmer set
     * @param programmer
     */
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-set")
    public void addToProgrammersSet(@RequestBody Programmer ... programmer) {
        programmerService.AddToProgrammersSet(programmer);
    }

    /**
     * listedeki tüm programmerları getirir
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/programmers-set")
    public Set<Programmer> getProgrammerSetMembers()  {
        return programmerService.getProgrammersSetMembers();
    }

    /**
     * set'te programmer var mı kontrol eder.
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value ="/programmers-set/member")
    public boolean isSetMember(@RequestBody Programmer programmer)  {
        return programmerService.isSetMember(programmer);
    }

    /**
     * Hash'e programmer ekler
     * @param programmer
     */
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-hash")
    public void  saveHash(@RequestBody Programmer programmer) {
        programmerService.saveHash(programmer);
    }

    /**
     * Hash'teki programmerı günceller
     * @param programmer
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/programmers-hash")
    public void updateHash(@RequestBody Programmer programmer){
        programmerService.updateHash(programmer);
    }

    /**
     * Hash listeler
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/programmers-hash")
    public Map<Integer, Programmer> findAllHash() {
        return programmerService.findAllHash();
    }

    /**
     * istenen Hash elemanını getirir
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/programmers-hash/{id}")
    public Programmer findInHash(@PathVariable int id) {
        return programmerService.findInHash(id);
    }

    /**
     * id'ye karşılık gelen hash elemanını siler
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/programmers-hash/{id}")
    public void deleteHash(@PathVariable int id) {
        programmerService.deleteHash(id);
    }


}
