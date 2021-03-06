package br.edu.ifsp.spo.bulls.users.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@ApiModel(value = "Objeto de domínio: Resenhas ")
public class Review {

    @Id
    @ApiModelProperty(value = "Identificador")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    public UUID id;
    public String title;
    @Column(columnDefinition="TEXT", length = 1000)
    public String body;
    public String idGoogleBook;
    public LocalDateTime creationDate;
    @ManyToOne
    public Profile profile;
    @ManyToOne
    public Book book;

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
    }

}
