package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.ProgrammerService;

@RestController
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    @RequestMapping(method= RequestMethod.POST, value = "/programmer-string")
    public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), mapper.writeValueAsString(programmer));
    }

    @RequestMapping("/programmer-string/{id}")
    public String readString(@PathVariable String id ){
        return programmerService.getProgrammerAsString(id);
    }
}
