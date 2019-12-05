package chatbot.prueba.api;

import chatbot.prueba.bl.PersonaBl;
<<<<<<< HEAD
=======
import chatbot.prueba.dao.PersonRepository;
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a

import chatbot.prueba.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonController {

    private PersonaBl personaBl;
    @Autowired
    public PersonController(PersonaBl personaBl){
        this.personaBl = personaBl;
    }
/**
    private PersonRepository personRepository;
    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
*/

    @RequestMapping(value = "/",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)

    List<PersonaDto> all() {
<<<<<<< HEAD



        return personaBl.findAllPeople();
=======
        List<PersonaDto> personDtoList =new ArrayList<>();
        for(Persona persona : personRepository.findAll()){
               personDtoList.add(new PersonaDto(persona));
        }
        return personDtoList;
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
    }




}
