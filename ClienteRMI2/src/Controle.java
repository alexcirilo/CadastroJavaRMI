import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;


public class Controle {

    //construtor para iniciar a visao 
    public Controle() throws IOException {
        System.out.println("construtor controle");
        view_aluno visao = new view_aluno(this);
    }

    //metodo de conexao remota
    public Interface conecta () throws RemoteException, NotBoundException{
        
            System.out.println("conectando no servidor...");
            
            //registra
            
            Registry registro = LocateRegistry.getRegistry("192.168.0.108", 1234);
            Interface interface_remota = (Interface) registro.lookup("rmiRemoto");
            return interface_remota;
    }
    
    
    public boolean Adicionar(String nome, String sobrenome, String email,String residencia,String formacao, String habilidades, String experiencia) {

        try {
            Interface interface_remota = conecta();
            if (interface_remota.Adicionar(nome, sobrenome, email, residencia, formacao, habilidades, experiencia));
            {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public String Listar (){

        try {
            Interface interface_remota = conecta();
            return interface_remota.Listar();
            
        } catch (Exception ex) {
            System.out.println("erro 03: "+ex.getMessage());
        }
        return "null";
    }
    
    public String buscaFormacaoCurso(String formacao) {
    	String curso =" ";
    	try {
    		Interface interface_remota = conecta();
    		curso = interface_remota.buscaFormacaoCurso(formacao);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return curso.toString();
    }
    
    public String buscaHabilidadeCidade (String cidade) {
    	String habilidade = " ";
    	try {
    		Interface interface_remota = conecta();
    		habilidade = interface_remota.buscaHabilidadeCidade(cidade);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return habilidade.toString();
    }
    
    public String buscaExperienciaEmail (String email) {
    	String experiencia = " ";
    	try {
    		Interface interface_remota = conecta();
    		experiencia = interface_remota.buscaExperienciaEmail(email);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return experiencia.toString();
    }
    
    public boolean Editar(String email, String nome_novo) {
        boolean status = false;
        try {
            Interface interface_remota = conecta();
            status = interface_remota.Editar(email, nome_novo);            
        } catch (NotBoundException | IOException ex) {
            System.out.println("Erro 06: "+ ex.getMessage());
        }
        return status;
    }
    
    
    /*public boolean Excluir(String email) {
        boolean status = false;
        try {
            Interface interface_remota = conecta();
            if (status = interface_remota.Excluir(email)){
                return true;
            }
            
        } catch (NotBoundException | IOException ex) {
            System.out.println("Erro 07: " + ex.getMessage());
        }
        return false;
    }*/

}
