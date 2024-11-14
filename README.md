# Sistema de Gestão de Eventos

Este projeto é um sistema simples para gerenciamento de eventos, incluindo o cadastro de organizadores, participantes, criação de eventos e compra de ingressos. O sistema permite que os usuários gerem relatórios sobre eventos, incluindo informações sobre os tipos de ingressos vendidos e o lucro total.

## Sumário

- [Funcionalidades](#funcionalidades)
- [Como usar](#como-usar)
  - [Menu de Opções](#menu-de-opções)
- [Estrutura do Código](#estrutura-do-código)
  - [Classes e Interfaces](#classes-e-interfaces)
  - [Métodos Principais](#métodos-principais)

## Funcionalidades

- Cadastrar organizadores e participantes.
- Criar eventos com base nos organizadores cadastrados.
- Comprar ingressos para eventos usando métodos de pagamento (débito e crédito).
- Geração de relatórios com informações detalhadas sobre cada evento.

## Como usar

Clone este repositório e compile o código com seu compilador Java preferido. Em seguida, execute o arquivo `Main.java` para iniciar o programa.

### Menu de Opções

O sistema apresenta as seguintes opções no menu principal:

1. **Cadastrar Organizador**: Permite cadastrar um novo organizador informando o nome.
2. **Cadastrar Participante**: Permite cadastrar um novo participante com nome e saldo na conta.
3. **Cadastrar Evento**: Cria um novo evento vinculado a um organizador selecionado, com capacidade máxima e preço.
4. **Comprar Ingresso**: Compra um ingresso para um participante em um evento selecionado, utilizando débito ou crédito.
5. **Relatório do Evento**: Gera um relatório detalhado sobre os eventos cadastrados.
0. **Encerrar**: Encerra o programa.

## Estrutura do Código

### Classes e Interfaces

- **Classes Importadas**: 
  - `Debito` e `Credito`: Representam métodos de pagamento.
  - `Participante`, `Organizador` e `Evento`: Representam as principais entidades do sistema.
  - `Relatorio`: Contém métodos para gerar informações sobre eventos.
- **Interfaces**:
  - `IPessoa`: Interface genérica para implementação de características comuns a pessoas (caso existente).

### Métodos Principais

- `menu()`: Exibe o menu principal e retorna a opção escolhida pelo usuário.
- `criarOrganizador()`: Cria e retorna um novo `Organizador`.
- `criarParticipante()`: Cria e retorna um novo `Participante` com informações fornecidas pelo usuário.
- `criarEvento(ArrayList<Organizador> organizadores)`: Cria um novo `Evento` vinculado a um `Organizador`.
- `comprarIngresso(ArrayList<Participante> participantes, ArrayList<Evento> eventos, Debito debito, Credito credito)`: Gerencia o processo de compra de ingressos para eventos.
- `gerarRelatorios(ArrayList<Evento> eventos)`: Gera e exibe relatórios com informações sobre os eventos cadastrados.
