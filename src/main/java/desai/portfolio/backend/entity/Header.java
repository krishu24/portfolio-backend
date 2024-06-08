package desai.portfolio.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "header")
public class Header {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long h_id;

    @Column(nullable = false)
    private String logo;

    @Column(nullable = false)
    private Date h_date;
}
