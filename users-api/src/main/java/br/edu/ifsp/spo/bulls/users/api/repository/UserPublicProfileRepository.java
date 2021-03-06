package br.edu.ifsp.spo.bulls.users.api.repository;

import br.edu.ifsp.spo.bulls.users.api.domain.PublicProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserPublicProfileRepository extends CrudRepository<PublicProfile, UUID> {
    List<PublicProfile> findByNameContaining(String name);

    Optional<PublicProfile> findByUserId(UUID userId);
}
