package br.edu.ifsp.spo.bulls.feed.api.repository;

import br.edu.ifsp.spo.bulls.feed.api.domain.Survey;
import br.edu.ifsp.spo.bulls.feed.api.domain.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VoteRepository extends CrudRepository<Vote, UUID> {
    Optional<Vote> findByProfileIdAndSurvey(int profileId, Survey survey);
}
