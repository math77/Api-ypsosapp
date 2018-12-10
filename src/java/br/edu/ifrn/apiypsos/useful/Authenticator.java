package br.edu.ifrn.apiypsos.useful;

import br.edu.ifrn.apiypsos.data.AlunoDAO;
import br.edu.ifrn.apiypsos.domain.Aluno;
import java.util.UUID;
import javax.security.auth.login.LoginException;

/**
 *
 * @author matheus
 */
public class Authenticator {

    /*
    * Recebe um objeto do tipo Aluno ou Professor com o email e senha
    * preenchidos e caso esse usuário exista o método retorna um token para
    * ser usado nas requisições.
     */
    public String login(Object usuario) throws LoginException {
        //Verifica se é um aluno que está tentando logar.
        if (usuario.getClass().isInstance(new Aluno())) {
            Aluno aluno = (Aluno) usuario;
            if (aluno.login()) {
                String token = generateToken();
                if(Aluno.saveToken(token, aluno.getEmail())){
                    return token;
                }
            }

        } else {
            //logar como professor
        }
        throw new LoginException("Ooops, erro ao logar");

    }

    /*
    * Recebe o token do usuário logado e realiza o processo de 
    * apagar o token e deslogara o usuário.
     */
    public void logout() {

    }

    /*
    * Gera um token para ser usado nas requisições realizadas depois do login.
     */
    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    /*
    * Verifica se o token enviado no Header da requisição é válido.
    * O token está salvo no banco de dados e deve ser validado a cada requisição.
     */
    public boolean isTokenValid(String token) {
        return AlunoDAO.verificaToken(token);
    }

}
