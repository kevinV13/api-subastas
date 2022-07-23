package com.example.apisubastas.Infraestructure.Imp;

import com.example.apisubastas.Domain.entities.Chatarra;
import com.example.apisubastas.Domain.repositoryContracts.ChatarraRepository;
import com.example.apisubastas.Infraestructure.repositories.ChatarraRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatarraRepositoryImp implements ChatarraRepository {

    @Autowired
    ChatarraRepositoryJPA db;


    @Override
    public Chatarra guardar(Chatarra chatarra) {
        return db.save(chatarra);
    }
}
