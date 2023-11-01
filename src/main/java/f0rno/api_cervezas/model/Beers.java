package f0rno.api_cervezas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Builder
@Getter
@Setter
@Entity
@Data
@Table(name = "Beers", schema = "beers")
@NoArgsConstructor
@AllArgsConstructor
public class Beers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int brewery_id;
    private String name;
    private int cat_id;
    private int style_id;
    private float abv;
    private int ibu;
    private float srm;
    private int upc;
    private String filepath;
    private String descript;
    private Date last_mod;
}
