package me.dio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import lombok.AllArgsConstructor;
import me.dio.dto.CardDetails;
import me.dio.persistence.dao.CardDAO;

@AllArgsConstructor
public class CardQueryService {

    private final Connection connection;
    
    public Optional<CardDetails> findById(final Long id) throws SQLException {
        var dao = new CardDAO(connection);
        return dao.findById(id);
    
    }
}
