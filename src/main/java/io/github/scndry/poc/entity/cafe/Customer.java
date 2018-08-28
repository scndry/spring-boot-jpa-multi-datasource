package io.github.scndry.poc.entity.cafe;

import io.github.scndry.poc.code.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)

    public long id;
    private String username;
    private Gender gender;

}
