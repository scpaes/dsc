package entities.people;
import entities.Aposta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_BOOKAGENTY")
@DiscriminatorValue(value = "f")
@PrimaryKeyJoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
public class BookAgenty extends Person {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADMIN_BOOKAGETY", referencedColumnName= "bookAgents", nullable = true)
    private Admin AdminBookAgent;
    
@ManyToMany(mappedBy = "MybookAgents", cascade = CascadeType.ALL)
   @Column(name = "My_Players", nullable = false, length = 50, updatable = true)
    private List<BookAgenty> MyPlayers = new ArrayList<>();

   

    public Admin getAdminBookAgent() {
        return AdminBookAgent;
    }

    public void setAdminBookAgent(Admin AdminBookAgent) {
        this.AdminBookAgent = AdminBookAgent;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }

    @ManyToMany (mappedBy = "bookAgenty", cascade = CascadeType.ALL)
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "bookAgenty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aposta> apostas = new ArrayList<>();

    // Métodos: adicionar Player, adicionar Aposta

  

    
}
