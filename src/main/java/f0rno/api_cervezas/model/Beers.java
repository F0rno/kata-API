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
    // TODO añadir anotiacion de foreign key "JUANJU dice q no es lo mismo, haber no digo q no sea lo mismo pero q forenge key exactamento, son 3 anotaciones para una foren key"
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

    public Beers(int brewery_id, String name, int cat_id, int style_id, float abv, int ibu, float srm, int upc, String filepath, String descript, Date last_mod) {
        this.brewery_id = brewery_id;
        this.name = name;
        this.cat_id = cat_id;
        this.style_id = style_id;
        this.abv = abv;
        this.ibu = ibu;
        this.srm = srm;
        this.upc = upc;
        this.filepath = filepath;
        this.descript = descript;
        this.last_mod = last_mod;
    }
}
