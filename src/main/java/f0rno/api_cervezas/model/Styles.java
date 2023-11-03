package f0rno.api_cervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@Data
@Table(name = "Styles", schema = "styles")
@NoArgsConstructor
@AllArgsConstructor
public class Styles {
    @Id
    private int id;
    private int cat_id;
    private String style_name;
    private Date last_mod;

    public Styles(int cat_id, String style_name, Date last_mod) {
        this.cat_id = cat_id;
        this.style_name = style_name;
        this.last_mod = last_mod;
    }
}
