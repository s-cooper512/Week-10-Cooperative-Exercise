package org.example.leaguemanagercoopwork.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ITournamentRepository extends JpaRepository<Tournament, Long> {
}
