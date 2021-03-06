package br.edu.ifsp.spo.bulls.competition.api.repository;

import br.edu.ifsp.spo.bulls.competition.api.domain.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, UUID> {

    Page<Competition> findByTitleOrRulesContaining(String title, String rules,  Pageable pageable);

    @Query(
            "SELECT m " +
                    "FROM Competition m " +
                    "WHERE m.winnerProfile IS NULL "
    )
    List<Competition> findCompetitionOpen();
}
