# 🐾 Sistema Veterinário

Este é um projeto em desenvolvimento criado durante meus estudos de Spring Boot. 
O objetivo é criar um sistema veterinário real com evolução a partir do conteúdo aprendido no curso.

## 🚀 Tecnologias Utilizadas

- Java
- Spring Boot
- Lombok
- MapStruct
- MySQL
- Maven

## 📌 Funcionalidades Atuais

- Cadastro de animais
- Cadastro de médicos veterinários
- Registro de consultas veterinárias
- Relacionamento entre entidades
- Estruturação com DTOs e mapeamento via MapStruct

## 📚 O que ainda será implementado

À medida que avanço no curso, o sistema será expandido com novas funcionalidades e melhorias, como:

- 🔐 **Autenticação e Autorização**
  - Implementação de login com JWT
  - Controle de acesso por perfis (admin, usuário, etc.)

- ✅ **Testes**
  - Testes unitários com JUnit e Mockito
  - Testes de integração

- 🛠 **Tratamento de erros e validações**
  - Validações de campos 
  - Respostas padronizadas com mensagens de erro

- 📈 **Monitoramento e Logs**
  - Integração com ferramentas de monitoramento

- 💡 **Melhorias gerais**
  - Refatorações e organização de pacotes
  - Documentação com Swagger/OpenAPI
  - Deploy da aplicação

## 🧪 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/pedrofelipeot/Sistema-Veterinario.git
   ```
2. Configure o banco de dados MySQL no `application.yml`
3. Execute o projeto com sua IDE ou via terminal:
   ```bash
   ./mvnw spring-boot:run
   ```
## Importando as requisições no Insomnia

Você pode importar as requisições usadas neste projeto direto no Insomnia:

1. Baixe o arquivo de exportação: [insomnia-export.json](./insomnia-export.json)  
2. No Insomnia, vá em `Import/Export` > `Import Data` > `From File`  
3. Selecione o arquivo baixado para carregar todas as requisições.

## 📌 Status

📍 Projeto em andamento — novas funcionalidades serão adicionadas conforme avanço nos estudos.

---

Desenvolvido por [Pedro Felipe]
