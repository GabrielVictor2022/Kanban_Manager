package me.dio.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class BoardColumnEntity {

        private Long id;
        private String name;
        private int order;
        private BoardColumnKindEnum kind;
        private BoardEntity board = new BoardEntity();
        @ToStringExclude
        @EqualsAndHashCode.Exclude
        private List<CardEntity> cards = new ArrayList<>();
}
