# 🚧 Branch Develop – Em Desenvolvimento

Esta é a branch `develop` do projeto **Desafio PicPay – Simulação de Transações**, utilizada para desenvolvimento contínuo, testes e implementação de novas funcionalidades antes de serem promovidas para `main`.

> ⚠️ Esta branch pode conter código instável ou recursos em construção.

---

## 🔨 Funcionalidades em Desenvolvimento

### ✅ Refatoração de Código
- Separação de responsabilidades nas camadas `Controller`, `Service` e `Repository`.
- Uso de exceções customizadas com `@ControllerAdvice` para mensagens mais claras de erro.

### ✅ Melhorias no Processo de Transferência
- Garantia de transações mais seguras e atômicas com rollback em caso de falha.
- Implementação mais robusta do serviço de autorização (mock).

### ✅ Novas Funcionalidades
- Endpoint de **consulta de transações por usuário** (`GET /users/{id}/transactions`).
- Preparação para envio real de **notificações externas** (POST).
- Estruturação inicial de testes de integração (JUnit + Testcontainers).

---

## 🧪 Testes e Validações

Estamos aplicando testes manuais e automatizados para garantir a integridade de funcionalidades novas e modificadas. Algumas abordagens:

- Testes unitários para validação de regras de negócio.
- Testes de integração para fluxos de transferência e cadastro.
- Logs mais claros para debug durante o desenvolvimento.

---

## 💡 Tecnologias e Versões Utilizadas

Mesmas da branch `main`, com possíveis atualizações em versões e bibliotecas durante o desenvolvimento:

- Java 23 (não LTS)
- Spring Boot
- Spring Data JPA
- Banco de dados em memória (H2)
- JUnit 5
- Lombok
- Swagger (planejado)

---

## 🧭 Rodando o Projeto (Modo Desenvolvedor)

1. Clone o repositório e mude para a branch:
   ```bash
   git clone https://github.com/lopezzd/desafio-picpay
   cd desafio-picpay
   git checkout develop
