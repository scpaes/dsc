package entities.people;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ADMIN")
@PrimaryKeyJoinColumn(name = "ID_PERSON", referencedColumnName = "ID")
public class Admin extends Person {
    @Column(name = "ADMIN_USER_NAME", nullable = false, length = 50, updatable = true)
    private String username;
    @Column(name = "ADMIN_PASSWORD", nullable = false, length = 50, updatable = true)
    private String password;

   @OneToMany(mappedBy = "AdminBookAgent", cascade = CascadeType.ALL,  orphanRemoval = true)
   @Column(name = "BOOKAGENTS", nullable = false, length = 50, updatable = true)
    private List<BookAgenty> bookAgents = new ArrayList<>();

   public void adicionarNovoBookAgent(BookAgenty bookAgent) {
        bookAgent.setAdminBookAgent(this);
        bookAgents.add(bookAgent);
    }
    // Métodos: adicionar, remover BookAgent, realizar sorteio
}