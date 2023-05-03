package br.com.projeto.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.agenda.models.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

	boolean existsByTelefone(String telefone);

}
