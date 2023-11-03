package f0rno.api_cervezas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@Data
@Table(name = "Categories", schema = "categories")
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    private int id;
    private String cat_name;
    private Date last_mod;

    public Categories(String cat_name, Date last_mod) {
        this.cat_name = cat_name;
        this.last_mod = last_mod;
    }
}
