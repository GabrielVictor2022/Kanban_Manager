# 🗂️ Kanban Manager

Sistema de gerenciamento de quadros e cartões inspirado no método Kanban. Desenvolvido em Java, o projeto permite criar, mover, bloquear, desbloquear e cancelar cards de forma estruturada, persistente e com regras de negócio bem definidas.

---

## 🚀 Funcionalidades

- ✅ Criar cartões em colunas iniciais do quadro
- 🔁 Mover cartões para colunas seguintes
- 🔒 Bloquear cartões com motivo
- 🔓 Desbloquear cartões com motivo
- ❌ Cancelar cartões e mover para coluna de cancelamento
- 📋 Visualizar quadro completo, colunas específicas e detalhes de cards

---

## 🧱 Estrutura do Projeto

- `entity/` - Entidades persistentes do banco de dados (JPA style)
- `dto/` - Objetos de transferência de dados entre camadas
- `service/` - Regras de negócio e lógica de aplicação
- `persistence/dao/` - Acesso direto ao banco de dados (JDBC)
- `ui/` - Camada de interface em console (menus e interação com o usuário)

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **JDBC (Java Database Connectivity)**
- **Lombok** (anotações para reduzir boilerplate)
- **PostgreSQL** (ou outro banco relacional, configurável)
- **Maven/Gradle** (dependências e build, se aplicável)

---

## 🧪 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/kanban-manager.git
cd kanban-manager
