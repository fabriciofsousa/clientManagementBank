package br.com.ada.reactivejavaclientmanagement.model;
import br.com.ada.reactivejavaclientmanagement.dto.EnderecoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Juridica extends Pessoa{
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    public Juridica(String telefone, String nacionalidade, Endereco endereco, String nome, String cnpj) {
        super(telefone, nacionalidade, endereco);
        this.nome = nome;
        this.cnpj = cnpj;
    }

}
