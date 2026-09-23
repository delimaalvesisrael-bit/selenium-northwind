<div align="center">

# Selenium Northwind 🚀

[![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-green?style=for-the-badge&logo=selenium)](https://www.selenium.dev/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5-blueviolet?style=for-the-badge&logo=junit5)](https://junit.org/junit5/)
[![Maven](https://img.shields.io/badge/Maven-Surefire-C71A36?style=for-the-badge&logo=apache-maven)](https://maven.apache.org/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ-IDEA-000000?style=for-the-badge&logo=intellij-idea)](https://www.jetbrains.com/idea/)
[![Status dos Testes](https://img.shields.io/badge/Testes-Passing-success?style=for-the-badge)](https://github.com/)

*Projeto de automação de testes web focado em garantir a qualidade de uma aplicação completa de gestão de produtos.*

[Sobre o Projeto](#-sobre-o-projeto) •
[Stack Tecnológica](#-stack-tecnológica) •
[Como Executar](#-como-executar) •
[Estrutura](#-estrutura-do-projeto) •
[Evidências](#-evidências-e-relatórios)

</div>

---

## 📌 Sobre o Projeto

O **selenium-northwind** é um projeto robusto de automação de testes End-to-End (E2E) desenvolvido para validar o fluxo completo de uma aplicação real de gestão de produtos. O sistema testado possui uma arquitetura moderna, contando com frontend interativo, API em Node.js e banco de dados Supabase, estando hospedado na Vercel.

O objetivo principal deste projeto foi aplicar na prática conceitos avançados de engenharia de qualidade de software, estruturando uma suíte de testes confiável, rápida e de fácil manutenção. 

### O que a suíte cobre:
* **Autenticação:** Validação de fluxos de login com cenários positivos e negativos.
* **Gestão de Produtos:** Ciclo de vida completo incluindo cadastro, listagem e exclusão de itens.
* **Categorias:** Validação das regras e operações voltadas às categorias de produtos.
* **Resiliência e Diagnóstico:** Captura automática de screenshots em caso de falhas e geração de relatórios detalhados em HTML.

---

## 🛠️ Stack Tecnológica

Este projeto foi construído utilizando ferramentas modernas e amplamente adotadas pelo mercado de tecnologia:

* **Linguagem:** Java (JDK 25)
* **Automação Web:** Selenium 4.x com Selenium Manager (gerenciamento nativo de drivers)
* **Framework de Testes:** JUnit 5
* **Gerenciamento de Dependências & Build:** Maven + Surefire Plugin
* **Ambiente de Desenvolvimento:** IntelliJ IDEA
* **Controle de Versão:** Git e GitHub
* **Captura de Cenários:** Katalon Recorder
* **Gestão & Acompanhamento:** Azure DevOps
* **Logs do Sistema:** Logback

---

## ⚙️ Como Executar

Siga os passos abaixo para configurar o ambiente e executar a suíte de testes em sua máquina local.

### Pré-requisitos
Certifique-se de ter instalado em sua máquina:
* **JDK 25** (ou versão compatível configurada nas variáveis de ambiente)
* **Maven** 
* **IntelliJ IDEA** (ou IDE de sua preferência)

### Passo a passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/selenium-northwind.git
   ```

2. **Abra o projeto na sua IDE** (Recomendado: IntelliJ IDEA).

3. **Aguarde o Maven baixar as dependências** do arquivo `pom.xml`.

4. **Execute os testes via linha de comando:**
   Abra o terminal na raiz do projeto e execute o comando Maven para rodar os testes e gerar os relatórios do Surefire:
   ```bash
   mvn clean test
   ```

---

## 📂 Estrutura do Projeto

A organização dos diretórios foi desenhada para manter a clareza, separação de responsabilidades e facilidade de manutenção:

```text
selenium-northwind/
├── src/
    └── test/
        └── java/
            └── tests/
                ├── BaseTest.java
                ├── login/
                │   └── LoginTest.java
                ├── produtos/
                │   └── ProdutosTest.java
                └── categorias/
                    └── CategoriaTest.java
├── evidencias/          ← Screenshots automáticos gerados em caso de falha
├── target/
    └── sufire-reports/  ← Relatórios HTML gerados pelo Maven Surefire
└── pom.xml
```

* **`BaseTest.java`**: Classe base responsável pelo setup e teardown do navegador, permitindo o reuso de configurações essenciais sem a necessidade de Page Objects complexos para esta fase do projeto.

---

## 📸 Evidências e Relatórios

### Evidências
O framework foi configurado para capturar automaticamente o estado da tela sempre que um teste falhar. As imagens são armazenadas diretamente no diretório dedicado:
* **Evidências:** `/evidencias/`


### Relatórios de Execução
Após a execução da suíte via Maven, relatórios detalhados são consolidados automaticamente pelo plugin Surefire, permitindo uma análise rápida da saúde dos testes.
* **Relatório Surefire:** `/target/surefire-reports/` (ou em `/docs/report` para visualizações compartilhadas).

* **Test Cases:**  `/docs/report/teste-cases.jpg`.

---

<div align="center">
Desenvolvido com dedicação por <strong>Israel de Lima Alves</strong> 💡
</div>