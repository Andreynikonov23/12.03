package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "gender")
public class Gender {
    @Id
    @NonNull
    @Column(name = "Code")
    private char code;
    @Column (name = "Name")
    private String name;

//    @OneToMany (mappedBy = "gender")
//    Set<Client> clientSet;

    @Override
    public String toString() {
        return "Gender{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
