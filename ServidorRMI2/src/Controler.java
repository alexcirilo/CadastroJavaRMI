
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Controler {


    public static void main(String[] args) {
        try {
        	int botao = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Deseja Ligar o servidor? ", "Start Server", botao);
            if(result == 0) {
            	 //cria um registro no no serviço de nome na porta 1234
                Registry registro = LocateRegistry.createRegistry(1234);
                
                //atualiza o registro criado na porta 1245 passando o nome e o objeto 
                //como parametros novos a  associação
                registro.rebind("rmiRemoto", new Metodos());
                System.out.println("Servidor aberto " + registro.toString());
            }else {
            	System.exit(0);
            }
           

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o servidor");
            System.out.println(ex.getMessage());
        }
    }
}
