package kz.bitlab.G114crm.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "application_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String commentary;
    private String phone;
    @Column(name = "handled", columnDefinition = "boolean default false")
    private boolean handled;
    @ManyToOne
    private User user;
}
