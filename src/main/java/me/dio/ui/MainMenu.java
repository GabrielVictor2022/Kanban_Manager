package me.dio.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import me.dio.persistence.entity.BoardColumnEntity;
import me.dio.persistence.entity.BoardColumnKindEnum;
import me.dio.persistence.entity.BoardEntity;
import me.dio.service.BoardQueryService;
import me.dio.service.BoardService; 
import static me.dio.persistence.config.ConnectionConfig.getConnection;
import static me.dio.persistence.entity.BoardColumnKindEnum.CANCEL;
import static me.dio.persistence.entity.BoardColumnKindEnum.FINAL;
import static me.dio.persistence.entity.BoardColumnKindEnum.INITIAL;
import static me.dio.persistence.entity.BoardColumnKindEnum.PENDING;


public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() throws SQLException {
        System.out.println("Bem-vindo ao sistema de gerenciamento de tarefas!");
        System.out.println("Escolha uma opção:");
        
        var option = -1;
        while (true) {
            System.out.println("1. Criar um novo quadro");
            System.out.println("2. Listar quadros existentes");
            System.out.println("3. Excluir um quadro");
            System.out.println("4. Sair");
            option = scanner.nextInt();
            if (option >= 1 && option <= 4) {
                break;
            }
            System.out.println("Opção inválida! Tente novamente.");
        }
        switch (option) {
            case 1 -> createBoard();
            case 2 -> selectBoard();
            case 3 -> deleteBoard();
            case 4 -> System.exit(0);
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }
    
    private void createBoard() throws SQLException{
        var entity = new BoardEntity();
        System.out.println("Informe o nome do quadro:");
        entity.setName(scanner.next());

        System.out.println("Seu board terá colunas além das 3 padrões? Se sim, informe quantas, senão digite 0:");
        var additionalColumns = scanner.nextInt();

        List<BoardColumnEntity> columns = new ArrayList<>();

        System.out.println("Informe o nome da coluna inicial do board:");
        var initialColumnName = scanner.next();
        var initialColumn = createColumn(initialColumnName, INITIAL, 0);
        columns.add(initialColumn);

        for (int i = 0; i < additionalColumns; i++) {
            System.out.println("Informe o nome de tarefa pendente do board:");
            var pendingColumnName = scanner.next();
            var pendingColumn = createColumn(initialColumnName, PENDING, i + 1);
            columns.add(initialColumn);
        }

        System.out.println("Informe o nome da coluna final do board:");
        var finalColumnName = scanner.next();
        var finalColumn = createColumn(finalColumnName, FINAL, additionalColumns + 1);
        columns.add(finalColumn);

        System.out.println("Informe o nome da coluna de cancelamento do board:");
        var cancelColumnName = scanner.next();
        var cancelColumn = createColumn(finalColumnName, CANCEL, additionalColumns + 2);
        columns.add(finalColumn);

        entity.setBoardColumns(columns);
        try(var connection = getConnection()){
        var service = new BoardService(connection);
        service.insert(entity);
        }

    }
    
    private void selectBoard() throws SQLException {
        System.out.println("Informe o id do board que deseja selecionar: ");
        var id = scanner.nextLong();
    
        try (var connection = getConnection()) {
            var queryService = new BoardQueryService(connection);
            var optional = queryService.findById(id);
    
            if (optional.isPresent()) {
                var boardMenu = new BoardMenu(optional.get());
                boardMenu.execute();
            } else {
                System.out.printf("Quadro %s não encontrado!\n", id);
            }
        }
    }    
    
    private void deleteBoard() throws SQLException {
        System.out.println("Informe o ID do quadro a ser excluído:");
        var id = scanner.nextLong();
        try(var connection = getConnection()){
            var service = new BoardService(connection);
            if (service.delete(id)){
                System.out.printf("Quadro %s foi excluído com sucesso!\n", id);
            } else {
                System.out.printf("Quadro %s não encontrado!\n", id);
                
            }
        }
    }

    private BoardColumnEntity createColumn(final String name, final BoardColumnKindEnum kind, final int order) {
        var boardColumn = new BoardColumnEntity();
        boardColumn.setName(name);
        boardColumn.setKind(kind);
        boardColumn.setOrder(order);
        return boardColumn;
    }
        
        
}
