# NeuroPro Talent - API de Gerenciamento de Funcionários

Este é um projeto **simples** e **educacional**, criado para demonstrar conceitos fundamentais do desenvolvimento de APIs utilizando o **Spring Boot**. 

## **Funcionalidades**
- **Gerenciar Funcionários**:
    - Adicionar, listar, atualizar e remover funcionários.
- **Gerenciar Certificações**:
    - Relacionar certificações a um funcionário.
- **Gerenciar Habilidades Técnicas**:
    - Relacionar habilidades técnicas a um funcionário.

---

## **Tecnologias Utilizadas**
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de Dados (H2)

---

## **Como Executar**
1. Clone o repositório:
   ```bash
   git clone https://github.com/Jaoow/NeuroProTalent.git
   cd NeuroProTalent
   ```

2. Execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse a API pelo endereço:
   ```
   http://localhost:8080
   ```

---

## **Estrutura de Endpoints**
### **Funcionários**
- **GET** `/employee`  
  Retorna a lista de todos os funcionários.

- **GET** `/employee/{id}`  
  Retorna os detalhes de um funcionário específico.

- **POST** `/employee`  
  Adiciona um novo funcionário (detalhes abaixo).

- **PUT** `/employee/{id}`  
  Atualiza as informações de um funcionário existente.

- **DELETE** `/employee/{id}`  
  Remove um funcionário do sistema.

---

## **Estrutura do POST de um Novo Funcionário**
Para adicionar um novo funcionário, envie uma requisição `POST` para o endpoint `/employee` com o seguinte corpo (JSON):

```json
{
  "name": "João Lucas",
  "email": "joao.lucas@gmail.com",
  "phone": "81999999999",
  "experienceTime": 6,
  "linkedInUrl": "https://www.linkedin.com/in/joaolucas",
  "certifications": [
    {
    "name": "AWS Certified Solutions Architect",
    "organization": "AWS",
    "startDate": "2024-01-15",
    "endDate": "2026-01-15"
    },
    {
    "name": "PMP Certification",
    "organization": "PMI",
    "startDate": "2023-07-20",
    "endDate": "2026-07-18"
    
    }
  ],
  "technicalSkills": [
    {
    "name": "Java",
    "description": "Desenvolvimento de APIs e aplicações web.",
    "level": "Avançado"
    },
    {
    "name": "AWS",
    "description": "Configuração e manutenção de serviços na nuvem.",
    "level": "Intermediário"
    }
  ]
}
```

### **Descrição dos Campos**
- **`name`** (String): Nome do funcionário.
- **`email`** (String): Email do funcionário.
- **`phone`** (String): Telefone de contato do funcionário.
- **`experienceTime`** (Integer): Tempo de experiência profissional (em anos).
- **`linkedInUrl`** (String): URL do perfil no LinkedIn.
- **`certifications`** (Lista de objetos):
    - **`name`** (String): Nome da certificação.
    - **`organization`** (String): Organização que emitiu a certificação.
    - **`startDate`** (String): Data de obtenção da certificação (formato `yyyy-MM-dd`).
    - **`endDate`** (String): Data de expiração da certificação (formato `yyyy-MM-dd`).
- **`technicalSkills`** (Lista de objetos):
    - **`name`** (String): Nome da habilidade técnica.
    - **`description`** (String): Descrição da habilidade.
    - **`level`** (String): Nível de proficiência na habilidade.

---

## **Exemplo de Teste**
Use ferramentas como **Postman** ou **cURL** para testar os endpoints.

### Exemplo com cURL
```bash
curl -X POST http://localhost:8080/employee \
-H "Content-Type: application/json" \
-d '{
  "name": "João Lucas",
  "email": "joao.lucas@gmail.com",
  "phone": "81999999999",
  "experienceTime": 6,
  "linkedInUrl": "https://www.linkedin.com/in/joaolucas",
  "certifications": [
    {
    "name": "AWS Certified Solutions Architect",
    "organization": "AWS",
    "startDate": "2024-01-15",
    "endDate": "2026-01-15"
    },
    {
    "name": "PMP Certification",
    "organization": "PMI",
    "startDate": "2023-07-20",
    "endDate": "2026-07-18"
    
    }
  ],
  "technicalSkills": [
    {
    "name": "Java",
    "description": "Desenvolvimento de APIs e aplicações web.",
    "level": "Avançado"
    },
    {
    "name": "AWS",
    "description": "Configuração e manutenção de serviços na nuvem.",
    "level": "Intermediário"
    }
  ]
}'
```

