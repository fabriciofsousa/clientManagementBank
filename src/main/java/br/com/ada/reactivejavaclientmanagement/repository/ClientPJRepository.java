package br.com.ada.reactivejavaclientmanagement.repository;

import br.com.ada.reactivejavaclientmanagement.model.Fisica;
import br.com.ada.reactivejavaclientmanagement.model.Juridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientPJRepository extends JpaRepository<Juridica, String> {

    Optional<Juridica> findById(String id);

    void deleteById(String id);
}
