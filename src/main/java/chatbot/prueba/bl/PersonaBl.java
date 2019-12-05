package chatbot.prueba.bl;

<<<<<<< HEAD
import chatbot.prueba.AsisMedBot;
import chatbot.prueba.dao.PersonRepository;
import chatbot.prueba.domain.Persona;
import chatbot.prueba.dto.Estatus;
import chatbot.prueba.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaBl {

    PersonRepository personRepository;

    @Autowired
=======

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
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
    public PersonaBl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

<<<<<<< HEAD
    public Persona findPersonaById(Integer pk){
        Optional<Persona> optional = this.personRepository.findById(pk);
        if (optional.isPresent()) {
            return optional.get();
        }else {
            throw new RuntimeException("No se pudo encontrar la Persona con el Id:" + pk);
        }
    }

    ///devolvemos PersonaDto
    //codigo de PersonController
    public List<PersonaDto> findAllPeople(){
        List<PersonaDto> personaDtoList =new ArrayList<>();
        for(Persona persona:personRepository.findByStatus(Estatus.ACTIVE.getEstatus())){
            personaDtoList.add(new PersonaDto(persona));
        }
        return personaDtoList;
    }


    // FALTA  anadimos metodo para personas con usuarios
    /**anadimos metodo para personas con usuarios
    public List<PersonaDto> findAllPeopleWithUsuarios(){
        List<PersonaDto> personaDtoList =new ArrayList<>();
        for(Persona persona:personRepository.findAllByEstatus(Estatus.ACTIVE.getEstatus())){
            PersonaDto personaDto = new PersonaDto(persona);

            List<UsuariosDto> usuariosDtoList = new ArrayList<>();
      //      List<Usuarios> usuariosList = persona.getApellidos();
            for( ){

            }
            personaDto.setUsuariosList();
            personaDtoList.add(personaDto);
        }
        return personaDtoList;
    }

     // FALTA  anadimos metodo para personas con usuarios
     public Persona findUsuarioById(Integer id){
     return personRepository.findById(id).get();
     }

*/
////
//codigo para el registro
    public PersonaBl(){
        personRepository = null;
    }


    public List<Persona> all(){
        List<Persona> personaList = new ArrayList<Persona>();
        List<Persona> all = personRepository.findAll();
        for(Persona persona:all){
            if(persona.getStatus() == 1){
                personaList.add(persona);
            }
        }
        return personaList;
    }


    public int personaRegistro(String message_text, long chad_id, int step, PersonaDto personaDto, AsisMedBot asisMedBot){
        String text;
        switch (step){
            case 0:
                asisMedBot.sendMessage(chad_id, "Si es la Primera vez que quiere realizar su reserva medica debe registrarse");
                text = "Cual es su nombre?";
                step = 1;
                asisMedBot.sendMessage(chad_id,text);
                break;
            case 1:
                AsisMedBot.personaDto.setNombre(message_text);
                text = "Cual es su apellido?";
                step = 2;
                asisMedBot.sendMessage(chad_id, text); // Sending our message object to user
            case 2:
                AsisMedBot.personaDto.setApellido(message_text);
                text = "cual es su numero de telefono?";
                step =3 ;
                asisMedBot.sendMessage(chad_id, text); // Sending our message object to user
                break;
            case 3:
                AsisMedBot.personaDto.setTelefono(Integer.parseInt(message_text));
                String val = "Nombre = " + personaDto.getNombre() + "\nApellido = " + personaDto.getApellido() + "\nTelefono = " + personaDto.getTelefono();
                step =0 ;
                text = "Su registro ha sido exitoso:";
                asisMedBot.sendMessage(chad_id, text); // Sending our message object to user
                break;

        }

        return step;
    }

 }

=======
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
>>>>>>> 060885ac40bae611f39cd8437e2c57db2341dc7a
