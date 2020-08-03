package br.edu.ifsp.spo.bulls.usersApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPassResetTO {
    String email;
    String url;
}