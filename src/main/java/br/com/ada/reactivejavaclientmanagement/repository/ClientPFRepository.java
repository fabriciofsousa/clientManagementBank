package br.com.ada.reactivejavaclientmanagement.repository;

import br.com.ada.reactivejavaclientmanagement.model.Fisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientPFRepository extends JpaRepository<Fisica, String> {

    Optional<Fisica> findById(String id);

    Optional<Fisica> findByCpf(String cpf);

    void deleteById(String id);
}
