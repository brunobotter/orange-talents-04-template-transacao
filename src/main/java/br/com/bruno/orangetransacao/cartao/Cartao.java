package br.com.bruno.orangetransacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

    @Id
    private String id;

    @Email
    private String email;

    @Deprecated
    public Cartao() {
    }
    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
