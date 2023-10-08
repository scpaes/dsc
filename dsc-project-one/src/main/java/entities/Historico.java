package entities;

import entities.people.Player;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_VEICULO")
public class Historico {
    
  
    @Column(name = "VEICULO_TXT_ANO", nullable = false, length = 4)
    private String ano;

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Player ganhador;

    private Date dataAposta;
   // Adicionar um relacionamento com Aposta
    @ManyToOne
    private Aposta aposta;

      public void setAposta(Aposta aposta) {
        this.aposta = aposta;

        // Copiar a data da aposta para a dataAposta no histórico
        this.dataAposta = aposta.getData();
    }
    public List<Player> buscarVencedorPorDia(Date data) {
        List<Player> vencedores = new ArrayList<>();
        
        if (dataAposta != null && dataAposta.equals(data)) {
            
            vencedores.add(ganhador);
        }
        return vencedores;
    }
   

}
