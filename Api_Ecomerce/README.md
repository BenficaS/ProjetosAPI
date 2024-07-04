# API E-commerce - Documentação

Este repositório contém uma API de e-commerce desenvolvida em Spring Boot, que oferece funcionalidades de autenticação segura usando tokens JWT e controle de acesso baseado em papéis de usuário. Abaixo está uma visão detalhada da estrutura, funcionalidades principais e como utilizar a API.

---

## Estrutura do Projeto

O projeto está estruturado nos seguintes pacotes principais:

- **`com.example.Api_Ecomerce.application`**: Contém a classe principal `ApiEcomerceApplication` que inicializa a aplicação Spring Boot.
- **`com.example.Api_Ecomerce.config`**: Configurações de segurança (`SecurityConfig`) utilizando Spring Security para definir autorizações e autenticações.
- **`com.example.Api_Ecomerce.controller`**: Controladores REST que definem os endpoints da API e integram com o serviço (`UserService`).
- **`com.example.Api_Ecomerce.model`**: Modelos de dados, como `UserEntity`, representando entidades de usuário.
- **`com.example.Api_Ecomerce.repository`**: Pacote destinado para futuras implementações de repositórios de dados.
- **`com.example.Api_Ecomerce.security`**: Utilitários de segurança, incluindo a classe `JwtUtil` para geração e validação de tokens JWT.

---

## Funcionalidades Principais

1. **Autenticação e Autorização**
   - **POST `/login`**: Endpoint para autenticar usuários. Retorna um token JWT necessário para acessar recursos protegidos.
   - **GET `/nomeusuario/{token}`**: Endpoint para extrair o nome de usuário a partir de um token JWT.

2. **Endpoints Protegidos**
   - **GET `/gerente/{token}`**: Acesso restrito a usuários com papel GERENTE.
   - **GET `/admin/{token}`**: Acesso restrito a usuários com papel ADMIN.

3. **Configuração de Segurança**
   - Utiliza Spring Security para configurar políticas de segurança baseadas em papéis de usuário.
   - Senhas são armazenadas de forma segura utilizando BCryptPasswordEncoder.

---

## Uso da API

1. **Execução**
   - Inicie a aplicação executando a classe `ApiEcomerceApplication`.

2. **Autenticação**
   - Para autenticar um usuário, envie uma requisição POST para `/login` com um corpo JSON contendo o nome de usuário e senha.

   Exemplo de Requisição:
   ```json
   POST /login
   {
       "nome": "gabriel",
       "senha": "1"
   }
Acesso a Recursos Protegidos

Utilize o token JWT recebido para acessar os endpoints protegidos, como /gerente/{token} e /admin/{token}.
Exemplo de Requisição:

http
Copiar código
GET /gerente/{token}
Authorization: Bearer <token_jwt>
Exemplo de Integração
Para integrar esta API em seu projeto, siga os passos acima para autenticar usuários e acessar os recursos protegidos conforme necessário.

Considerações Finais
Este projeto demonstra uma implementação robusta de segurança com Spring Boot e Spring Security, oferecendo autenticação via tokens JWT e controle de acesso baseado em papéis de usuário de forma eficaz.

Para mais detalhes e personalizações, consulte o código-fonte e os comentários nos arquivos relevantes.

Esta documentação fornece uma visão abrangente da API de e-commerce desenvolvida, destacando seus principais recursos, funcionalidades e instruções básicas para utilização e integração.

# Aqui veremos exemplos funcionais da aplicação utilizando o insomnia.
- Aqui temos a validação dos usuarios exemplo: Admin.
![imagem](https://github.com/BenficaS/Api_Ecomerce/assets/107698702/34ff0078-2914-484b-abd3-76cc39bb8b65)
# Aqui a geração do token JWT validado.
![imagem2](https://github.com/BenficaS/Api_Ecomerce/assets/107698702/3ea77d1e-bc4c-44e1-8525-d4e97eb810fd)


# Abaixo segue um diagrama de funcionamento.
- Ele serve para descrever a funcionalidade da api para facil entendimento.
```mermaid
graph TD;

    subgraph User_Operations
        A1[Registra Usuário] --> B1[Autentica Usuário]
        B1 --> C1[Extrai Papel de Usuário]
        style A1 fill:#CCEEFF,stroke:#336699,stroke-width:2px,stroke-dasharray: 5, 5;
        style B1 fill:#CCFFCC,stroke:#006600,stroke-width:2px,stroke-dasharray: 5, 5;
        style C1 fill:#FFFFCC,stroke:#CCCC00,stroke-width:2px,stroke-dasharray: 5, 5;
    end

    subgraph Admin_Operations
        D1[Exclui Usuário]
        style D1 fill:#FFCCCC,stroke:#990000,stroke-width:2px,stroke-dasharray: 5, 5;
    end

    subgraph Manager_Operations
        E1[Exclui Produto]
        style E1 fill:#CCCCFF,stroke:#663399,stroke-width:2px,stroke-dasharray: 5, 5;
    end

    subgraph Seller_Operations
        F1[Cria Produto]
        style F1 fill:#99CCFF,stroke:#336699,stroke-width:2px,stroke-dasharray: 5, 5;
    end

    subgraph Customer_Operations
        G1[Visualiza Produto]
        style G1 fill:#CCFF99,stroke:#669900,stroke-width:2px,stroke-dasharray: 5, 5;
    end

    A[API de Autenticação] -->|Registra/Login| User_Operations
    style A fill:#FFCC99,stroke:#FF6600,stroke-width:2px,stroke-dasharray: 5, 5;
    User_Operations -->|Token JWT| H[JWT Service]
    style H fill:#C2D1F0,stroke:#304269,stroke-width:2px,stroke-dasharray: 5, 5;
    H -->|Autorização| Admin_Operations
    H -->|Autorização| Manager_Operations
    H -->|Autorização| Seller_Operations
    H -->|Autorização| Customer_Operations
    User_Operations -->|Acesso a Dados| I[MongoDB]
    style I fill:#FFE5CC,stroke:#CC6600,stroke-width:2px,stroke-dasharray: 5, 5;
    Admin_Operations -->|Acesso a Dados| I
    Manager_Operations -->|Acesso a Dados| I
    Seller_Operations -->|Acesso a Dados| I
    Customer_Operations -->|Acesso a Dados| I
```
