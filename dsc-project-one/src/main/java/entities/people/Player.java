package entities.people;

import entities.Aposta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
@DiscriminatorValue(value = "c")
@PrimaryKeyJoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
public class Player extends Person {
    @ManyToMany(mappedBy = "players")
    private List<BookAgenty> bookAgents = new ArrayList<>();

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Aposta> apostas = new ArrayList<>();

    // Métodos: visualizar histórico de ganhadores da aposta
}

