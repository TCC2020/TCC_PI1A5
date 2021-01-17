package br.edu.ifsp.spo.bulls.feed.api.service;

import br.edu.ifsp.spo.bulls.common.api.enums.CodeException;
import br.edu.ifsp.spo.bulls.common.api.exception.ResourceNotFoundException;
import br.edu.ifsp.spo.bulls.feed.api.domain.Post;
import br.edu.ifsp.spo.bulls.feed.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post create(Post post) {
        return repository.save(post);
    }

    public Post update(Post post, UUID idPost) {
        return repository.findById(idPost).map( post1 -> {
                    post1 = post;
                    post1.setId(idPost);
                    return repository.save(post1);
                })
                .orElseThrow( () -> new ResourceNotFoundException(CodeException.PT001.getText(), CodeException.PT001));
    }

    public Post get(UUID idPost) {
        return repository.findById(idPost)
                .orElseThrow( () -> new ResourceNotFoundException(CodeException.PT001.getText(), CodeException.PT001));
    }

    public List<Post> getByProfile(int profileId) {
        return repository.findByProfileId(profileId);
    }

    public void delete(UUID idPost) {

        repository.deleteById(idPost);
    }
}