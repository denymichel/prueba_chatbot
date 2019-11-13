package chatbot.prueba.api;

import chatbot.prueba.dao.PersonRepository;
import chatbot.prueba.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/persona")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @RequestMapping(value = "/",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)

    List<PersonaDto> all() {
        List<PersonaDto> personaDtoList =new ArrayList<>();
        for(Persona persona:personRepository.findAll()){
               personaDtoList.add(new PersonaDto(persona));
        }
        return personaDtoList;
    }




}
