package chatbot.prueba.api;

import chatbot.prueba.bl.PersonaBl;
import chatbot.prueba.dao.PersonRepository;

import chatbot.prueba.domain.Persona;
import chatbot.prueba.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("persona")
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
        List<PersonaDto> personDtoList =new ArrayList<>();
        for(Persona persona : personRepository.findAll()){
               personDtoList.add(new PersonaDto(persona));
        }
        return personDtoList;
    }




}
