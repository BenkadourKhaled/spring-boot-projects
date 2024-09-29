package dz.todo.management.projects.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Create By ${} on 19/09/2024
 *
 * @Author : KHALED_BENKADOUR
 * @Email : BENKKADOUR.KHALED@GMAIL.COM
 * @DATE : 19/09/2024
 * @TIME : 16:51
 * @Project_Name : spring-boot-projects
 */
@Entity
@Table(name = "TODOS") @Setter  @Getter
@AllArgsConstructor @NoArgsConstructor @ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    private boolean completed;

}
