package g145.g145market.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "CONTENT")
    private byte[] content;
}
