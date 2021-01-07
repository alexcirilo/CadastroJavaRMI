
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

public interface Interfacer extends Remote {

    public boolean Adicionar(String nome, String sobrenome, String email, String residencia, String formacao, String habilidades, String experiencia) throws IOException;
    public String Listar() throws FileNotFoundException, IOException, RemoteException;
    public boolean Editar(String email, String nome_novo) throws FileNotFoundException, IOException, RemoteException;
    /*public boolean Excluir(String email) throws FileNotFoundException, IOException, RemoteException;*/
    public String buscaHabilidadeCidade (String cidade)throws FileNotFoundException, IOException,RemoteException;
    public String buscaFormacaoCurso(String formacao)throws FileNotFoundException, IOException,RemoteException;
    public String buscaExperienciaEmail (String email) throws FileNotFoundException, IOException, RemoteException;
}
