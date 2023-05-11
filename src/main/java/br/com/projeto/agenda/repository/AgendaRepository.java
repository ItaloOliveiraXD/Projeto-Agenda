package br.com.projeto.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.agenda.models.Contato;

@Repository
public interface AgendaRepository extends JpaRepository<Contato, Long> {

	boolean existsByTelefone(String telefone);

}
