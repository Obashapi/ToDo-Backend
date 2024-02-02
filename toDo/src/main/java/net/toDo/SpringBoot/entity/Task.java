package net.toDo.SpringBoot.entity;

import jakarta.persistence.*;
import lombok.*;
import net.toDo.SpringBoot.enumeration.Priority;
import net.toDo.SpringBoot.enumeration.Status;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tasks")

public class
Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    private Date dueDate;
    private Status status;
    private Priority priority;

}
