
# Secure User Validation

## Descrição
Este projeto implementa um sistema simples de validação de usuários, com conexão a um banco de dados MySQL.

## Erros Encontrados e Corrigidos

1. **SQL Injection**  
   - O código original usava concatenação de strings para montar queries SQL, o que deixava o sistema vulnerável a ataques de *SQL Injection*.
   - **Correção**: Substituímos a concatenação por **Prepared Statements**.

2. **Tratamento de Exceções Genéricas**  
   - O código capturava exceções genéricas (`catch (Exception e)`), o que dificultava a depuração e o entendimento dos problemas.
   - **Correção**: Usamos exceções específicas, como `SQLException` e `ClassNotFoundException`.

3. **Encerramento de Recursos**  
   - O código não fechava conexões, *Statements* e *ResultSets*, o que poderia causar vazamento de memória.
   - **Correção**: Incluímos o uso do bloco `try-with-resources` para garantir que todos os recursos sejam fechados automaticamente.

4. **Boas Práticas de Nomenclatura**  
   - A classe foi renomeada para seguir convenções de nomenclatura em Java (CamelCase, etc.).

## Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/matheuspaes375/secure-user-validation.git
