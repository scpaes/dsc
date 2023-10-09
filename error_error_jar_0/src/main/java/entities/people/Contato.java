package entities.people;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_FUNCIONARIO")
@DiscriminatorValue(value = "f")
@PrimaryKeyJoinColumn(name = "PERSON_CONTACT", referencedColumnName = "ID")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ElementCollection
    @CollectionTable(name = "CONTACTS", joinColumns = @JoinColumn (name = "PERSON_CONTACT", nullable = false) )
    @Column (name = "PHONE_NUMBERS", nullable = false, columnDefinition = "INT(9)")
    private List<String> numerosDeTelefone = new ArrayList<>();

    // Getters e setters
}