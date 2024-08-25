# Protótipo de Loja Virtual

Este é um protótipo de loja virtual desenvolvido como parte do meu projeto acadêmico em Análise e Desenvolvimento de Sistemas (ADS). O objetivo deste projeto é criar uma aplicação funcional que permita a compra de produtos, gerencie os dados dos clientes e administre as operações de uma loja virtual.

## Funcionalidades

- **Cadastro e Login de Usuário**: Os usuários podem se cadastrar e fazer login usando CPF e senha.
- **Tela Principal**: Exibe os produtos disponíveis para compra, filtrando apenas aqueles com quantidade maior que zero.
- **Sistema de Compra**: Permite que os usuários comprem produtos, selecionando a quantidade e a forma de pagamento.
- **Gerenciamento de Produtos**: O administrador pode visualizar e gerenciar os produtos na loja, incluindo a adição, remoção e atualização de itens.
- **Histórico de Compras**: Registra as compras realizadas, permitindo a geração de relatórios futuros.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **NetBeans**: IDE utilizada para desenvolvimento.
- **MySQL**: Banco de dados para armazenamento das informações da loja e dos usuários.
- **JDBC**: Para conexão com o banco de dados.
- **Swing**: Para a interface gráfica da aplicação.

## Estrutura do Banco de Dados

- **Tabela `produtos`**: Armazena as informações dos produtos, incluindo nome, preço, quantidade e descrição.
- **Tabela `compras`**: Registra as compras realizadas pelos usuários.
- **Tabela `clientes`**: Armazena as informações dos clientes, incluindo CPF e senha.

