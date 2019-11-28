package chatbot.prueba.bl;


        import chatbot.prueba.dao.PersonRepository;
        import chatbot.prueba.domain.Persona;
        import chatbot.prueba.domain.Usuarios;
        import chatbot.prueba.dto.Estatus;
        import chatbot.prueba.dto.PersonaDto;
        import chatbot.prueba.dto.UsuariosDto;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@Service
public class PersonaBl {
    PersonRepository personRepository;
   // @@ -12,6 +22,40 @@
    public PersonaBl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Persona findPersonById(Integer pk) {
        Optional<Persona> optional = this.personRepository.findById(pk);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            // Otra alternativa podría ser: crear una nueva persona con valores por defecto y retornar este nuevo objeto
            throw new RuntimeException("Record cannot found for CpPerson with ID: " + pk);
        }
    }

    public List<PersonaDto> findAllPeople() {
        List<PersonaDto> personDtoList = new ArrayList<>();
        for (Persona persona:personRepository.findAllByEstatus(Estatus.ACTIVE.getEstatus())) {
            personDtoList.add(new PersonaDto(persona));
        }
        return personDtoList;
    }

   /* public List<PersonaDto> findAllPeopleWithAddress() {
        List<PersonaDto> personDtoList = new ArrayList<>();
        for (Persona persona:personRepository.findAllByEstatus(Estatus.ACTIVE.getEstatus())) {
            PersonaDto personaDto = new PersonaDto(persona);
            List<UsuariosDto> addressDtoList = new ArrayList<>();
            //List<Usuarios> usuarios = persona.getUsuariosList();
          //  for(CpPersonAddress cpa : cpAddressList) {
           //     CpAddress address = cpa.getAddressId();
           //     addressDtoList.add(new AddressDto(address));
           // }
         //   personaDto.setAddressList(addressDtoList);
            personDtoList.add(personaDto);
        }
        return personDtoList;
    }
    /*
    public void saveOrder(UserTelegram user,  List<BookDto> books) {
        // mi logica de negocio
        // books -> CpBooks(Etities)
    }
     */
}