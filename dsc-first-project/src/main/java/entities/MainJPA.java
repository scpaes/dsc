package entities;

import java.util.Calendar;
import entities.people.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainJPA {
      public static void main(String[] args) {EntityManagerFactory emf = null;
      
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //EntityManagerFactory realiza a leitura das informações relativas à  "persistence-unit".
            emf = Persistence.createEntityManagerFactory("dsc-project-one");
            em = emf.createEntityManager(); //Criação do EntityManager.
            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
            et.begin();
        } catch (Exception ex) {
            if (et != null)
                et.rollback();
        } finally {
            if (em != null)
                em.close();       
            if (emf != null)
                emf.close();
        }
      }
      
/*   
        Veiculo veiculo1 = new Veiculo();
        preencherVeiculo1(veiculo1);
        
        Veiculo veiculo2 = new Veiculo();
        preencherVeiculo2(veiculo2);
                
        Mecanico mecanico1 = new Mecanico();
        preencherMecanico1(mecanico1);
        
        Mecanico mecanico2 = new Mecanico();
        preencherMecanico2(mecanico2);
        
        BookAgenty funcionario = new BookAgenty();
        Player cliente = new Player();
        
        Venda venda1 = new Venda();
        preencherVenda1(venda1, cliente, funcionario, veiculo1);

        Venda venda2 = new Venda();
        preencherVenda2(venda2, cliente, funcionario, veiculo2);

        
        preencherFuncionario(funcionario);       
        preencherCliente(cliente);                
        
        funcionario.add(venda1);
        funcionario.add(venda2);
        cliente.add(venda1);
        cliente.add(venda2);
        

        OrdemServico os = new OrdemServico();
        preencherOrdemServico(os, mecanico1, mecanico2, veiculo1);
        
        mecanico1.setOs(os);
        mecanico2.setOs(os);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //EntityManagerFactory realiza a leitura das informações relativas à  "persistence-unit".
            emf = Persistence.createEntityManagerFactory("dealership_db");
            em = emf.createEntityManager(); //Criação do EntityManager.
            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
            et.begin();

            em.persist(veiculo1);
            em.persist(veiculo2);
            em.persist(cliente);
            em.persist(funcionario);
            em.persist(mecanico1);
            em.persist(mecanico2);
            em.persist(os);
            em.persist(venda1);
            em.persist(venda2);

            et.commit();          

        } catch (Exception ex) {
            if (et != null)
                et.rollback();
        } finally {
            if (em != null)
                em.close();       
            if (emf != null)
                emf.close();
        }
    }
    
    private static void preencherVeiculo1(Veiculo veiculo1) {
        veiculo1.setAno("2014");
        veiculo1.setModelo("Golf");
        veiculo1.setValor(70000.0);
        veiculo1.setMarca("Volkswagen");
        veiculo1.setVendido(false);
    }
    
    private static void preencherVeiculo2(Veiculo veiculo2) {
        veiculo2.setAno("2012");
        veiculo2.setModelo("City");
        veiculo2.setValor(50000.0);
        veiculo2.setMarca("Honda");
        veiculo2.setVendido(false);
    }
    
    private static void preencherCliente(Player cliente) {
        cliente.setNome("Fábio Magalhães");
        cliente.setEndereco("Avenida Recife 105");
        cliente.setTelefone("996765432");
        cliente.setEmail("the.maga@yahoo.com");
        cliente.setRendaMensal(4500.0);
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1979);
        c.set(Calendar.MONTH, Calendar.MAY);
        c.set(Calendar.DAY_OF_MONTH, 10);
        cliente.setDataNascimento(c.getTime());
    }
    
    private static void preencherFuncionario(BookAgenty funcionario) {
        funcionario.setNome("Caio Cesar");
        funcionario.setEndereco("Avenida Rua 101");
        funcionario.setTelefone("998765432");
        funcionario.setEmail("caio.cesar@hotmail.com");
        funcionario.setCargoFuncionario(CargoFuncionario.VENDEDOR);
        funcionario.setSalarioFixo(3500.0);
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1990);
        c.set(Calendar.MONTH, Calendar.MAY);
        c.set(Calendar.DAY_OF_MONTH, 10);
        funcionario.setDataNascimento(c.getTime());
    }
    
    private static void preencherMecanico1(Mecanico mecanico1) {
        mecanico1.setNome("Paulo André");
        mecanico1.setEndereco("Rua Avenida 3467");
        mecanico1.setTelefone("996765433");
        mecanico1.setEmail("andre.paulo@yahoo.com");
        mecanico1.setFuncaoMecanico(Animal.FUNILEIRO);
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1970);
        c.set(Calendar.MONTH, Calendar.AUGUST);
        c.set(Calendar.DAY_OF_MONTH, 10);
        mecanico1.setDataNascimento(c.getTime());
    }
    
    private static void preencherMecanico2(Mecanico mecanico2) {
        mecanico2.setNome("Paulo Gonçalves");
        mecanico2.setEndereco("Avenida Mascarenhas de Moraes 467");
        mecanico2.setTelefone("996865433");
        mecanico2.setEmail("paulo.paulo@yahoo.com");
        mecanico2.setFuncaoMecanico(Animal.FUNILEIRO);
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1968);
        c.set(Calendar.MONTH, Calendar.AUGUST);
        c.set(Calendar.DAY_OF_MONTH, 22);
        mecanico2.setDataNascimento(c.getTime());
    }
    
    private static void preencherOrdemServico(OrdemServico os, Mecanico mecanico1, Mecanico mecanico2, Veiculo veiculo) {
        os.setDescricao("Pintura esportiva para Golf");
        os.setMecanico(mecanico1);
        os.setMecanico(mecanico2);
        os.setVeiculo(veiculo);
    }
    
    private static void preencherVenda1(Venda venda1, Player cliente, BookAgenty funcionario, Veiculo veiculo1) {
        venda1.setCliente(cliente);
        venda1.setFuncionario(funcionario);
        venda1.setVeiculo(veiculo1);
        venda1.setValor(veiculo1.getValor());

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2022);
        c.set(Calendar.MONTH, Calendar.NOVEMBER);
        c.set(Calendar.DAY_OF_MONTH, 02);
        venda1.setData(c.getTime());
    }
    
    private static void preencherVenda2(Venda venda2, Player cliente, BookAgenty funcionario, Veiculo veiculo2) {
        venda2.setCliente(cliente);
        venda2.setFuncionario(funcionario);
        venda2.setVeiculo(veiculo2);
        venda2.setValor(veiculo2.getValor());

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2021);
        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        c.set(Calendar.DAY_OF_MONTH, 06);
        venda2.setData(c.getTime());
    }
*/
}