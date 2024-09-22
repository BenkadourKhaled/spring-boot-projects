package dz.todo.management.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
/**
 * Create By ${} on 19/09/2024
 *
 * @Author : KHALED_BENKADOUR
 * @Email : BENKKADOUR.KHALED@GMAIL.COM
 * @DATE : 19/09/2024
 * @TIME : 16:51
 * @Project_Name : spring-boot-projects
 */

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class TodoDto implements Serializable {

    private int id;
    private String title;
    private String description;
    private boolean completed;

}