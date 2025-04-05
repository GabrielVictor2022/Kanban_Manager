package me.dio.dto;

import me.dio.persistence.entity.BoardColumnKindEnum;

public record BoardColumnDTO(long id,
                            String name, 
                            int order, 
                            BoardColumnKindEnum kind,
                            int cardsAmount) {
    
}
