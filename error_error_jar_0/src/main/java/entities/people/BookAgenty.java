package entities.people;
import entities.Aposta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
    
    @Enumerated(EnumType.STRING)
    @Column(name = "FUNCIONARIO_ENUM_CARGO", nullable = false, updatable = true)
    private CargoFuncionario cargoFuncionario;
     
    
    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Admin admin;

    @ManyToMany (mappedBy = "bookAgenty", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "bookAgenty", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aposta> apostas = new ArrayList<>();

    // Métodos: adicionar Player, adicionar Aposta

    void setAdmin(Admin aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
