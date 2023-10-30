package f0rno.api_cervezas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Beer {
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

    public Beer(int brewery_id, String name, int cat_id, int style_id, float abv, int ibu, float srm, int upc, String filepath, String descript, Date last_mod) {
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
