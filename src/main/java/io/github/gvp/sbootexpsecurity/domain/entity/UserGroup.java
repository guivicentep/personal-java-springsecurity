package io.github.gvp.sbootexpsecurity.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
