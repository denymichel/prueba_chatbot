package chatbot.prueba.dao;

import chatbot.prueba.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatRepository extends JpaRepository <Chat, Integer>{

    @Query(value = "SELECT * FROM chat where  idusuario = ?1 ORDER BY idchat DESC LIMIT 1", nativeQuery = true)
    public Chat findLastChatByUserId(Integer idusuario);
}
