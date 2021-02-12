package br.edu.ifsp.spo.bulls.common.api.dto;

import br.edu.ifsp.spo.bulls.common.api.bean.StringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAdTO {
    private UUID id;
    private String description;
    @Convert(converter = StringConverter.class)
    private List<String> images;
    private String isbn;
    private UUID userId;
    private String idBookGoogle;
    private int bookId;
    private AdReviewTO review;
}
