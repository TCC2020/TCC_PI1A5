package br.edu.ifsp.spo.bulls.users.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@ApiModel(value = "Objeto de domínio: ACOMPANHAMENTO_LEITURA ")
@Table(name = "tracking_group")
public class Tracking {
    @Id
    @ApiModelProperty(value = "Identificador")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ApiModelProperty(value = "Comentário")
    private String comentario;

    @ApiModelProperty(value = "Data inicial acompanhamento")
    private LocalDateTime creationDate;

    @ApiModelProperty(value = "Data do termino acompanhamento")
    private LocalDateTime finishedDate;

    @ApiModelProperty(value = "Cadastro do livro na estante do usuário relacionado ao acompmanhamento")
    @ManyToOne
    private UserBooks userBook;

    @ApiModelProperty(value = "Lista de atualizações")
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ReadingTracking> readingTrackings = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
    }

}
