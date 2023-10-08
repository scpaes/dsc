package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Adicione um atributo enum para representar o tipo de animal
    @Enumerated(EnumType.STRING)
    @Column (name = "ANIMAL_TYPE", nullable = false)
    private TipoAnimal tipo;
    
@OneToMany(mappedBy = "animal")
    private List<Aposta> apostas = new ArrayList<>();
    // Getters e setters

    public void setId(Long id) {
        this.id = id;
    }

   public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }

    public Long getId() {
        return id;
    }

  
    public List<Aposta> getApostas() {
        return apostas;
    }
    public enum TipoAnimal {
        GATO,
        CAVALO,
        AGUIA,
        BORBOLETA,
        CACHORRO
    }
}