package app.vercel.northwind.utils;

public class TestData {
    //EMAIL
    public static final String EMAIL_VALIDO = "admin@qatest.com";
    public static final String EMAIL_INVALIDO = "Admin.123";
    public static final String EMAIL_INEXISTENTE = "Admin007@gmail.com";
    public static final String EMAIL_VAZIO = "";

    //SENHA
    public static final String SENHA_VAZIA = "";
    public static final String SENHA_INVALIDA = "123456";
    public static final String SENHA_CURTA = "teste";
    public static final String SENHA_VALIDA = "Teste@123";

    //MENSAGENS
    public static final String MSG_CAMPOS_OBRIGATORIOS = "Email e senha são obrigatórios";
    public static final String MSG_EMAIL_INVALIDO = "Formato de email inválido. Use: nome@dominio.com";
    public static final String MSG_USER_NOTFOUND = "Usuário não encontrado. Verifique o email ou cadastre-se.";
    public static final String MSG_SENHA_INVALIDA = "Email ou senha inválidos" ;
    public static final String MSG_SENHA_CURTA = "Senha deve ter pelo menos 6 caracteres";

    //TELA INCIAL
    public static final String TITULO_HOME_PAGE = "QA Automation Shop";
}
