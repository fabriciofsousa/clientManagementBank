package br.com.ada.reactivejavaclientmanagement.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@MappedSuperclass
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificacao;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "nacionalidade")
    private String nacionalidade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Pessoa(String telefone, String nacionalidade, Endereco endereco) {
        this.telefone = telefone;
        this.nacionalidade = nacionalidade;
        this.endereco = endereco;
    }
}
