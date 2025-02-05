# 🏦 Desafio PicPay - Simulação de Transições

O desafio [PicPay](https://github.com/PicPay/picpay-desafio-backend) consiste em uma plataforma de pagamentos que permite o depósito e a transferência de dinheiro entre usuários. A plataforma conta com dois tipos de usuários:


### 🚀 Tecnologias Utilizadas
- Java 23 (Não LTS)
- Spring Boot
- Spring Data JPA
- H2 | Banco de Dados H2

### 👤 Cadastro de Usuários
- **Usuários comuns**: Podem enviar e receber dinheiro.
- **Lojistas**: Apenas recebem transferências.
- Nome completo, CPF, e-mail e senha são obrigatórios.
- CPF/CNPJ e e-mails devem ser únicos no sistema.
- Apenas um cadastro é permitido por CPF ou e-mail.

### 💸 🔄 Regras de Transferência
- Usuários podem transferir dinheiro entre si e para lojistas.
- Lojistas apenas recebem transferências, não podem enviar dinheiro.
- Antes da transferência, o saldo do remetente deve ser validado.
- O desafio exige um **serviço autorizador externo** via GET, não implementado e substituído por um método randômico boleano.
- A operação de transferência deve ser uma **transação atômica**.
- O desafio exige uma **notificação externa** via POST, também não implementado.

## 📌 Endpoints Principais

### **Usuários**
#### **POST /users**
##### **Request:**
```json
{
    "firstName":"Fulano",
    "lastName":"Da Silva",
    "document":"12345678911",
    "email":"fulano@gmail.com",
    "password":"321",
    "userType": "COMMUN",
    "balance": 100
}
```

### **Transações**
#### **POST /transactions**
##### **Request:**
```json
{
    "senderId": 1,
    "receiverId": 2,
    "value": 10
}
```

## Como Rodar o Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/lopezzd/desafio-picpay
   ```
2. Instale as dependências:
   ```sh
   mvn install  # Para projetos Maven
   ```
3. Configure as variáveis de ambiente (`.env`).
4. Execute o projeto:
   ```sh
   mvn spring-boot:run
   ```

### 🐝 Licença
Este projeto está sob a licença MIT.
