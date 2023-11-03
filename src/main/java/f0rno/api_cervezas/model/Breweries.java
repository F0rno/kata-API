package f0rno.api_cervezas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@Data
@Table(name = "Breweries", schema = "breweries")
@NoArgsConstructor
@AllArgsConstructor
public class Breweries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String code;
    private String country;
    private String phone;
    private String website;
    private String filepath;
    private String descript;
    private int add_user;
    private Date last_mod;

    public Breweries(String name, String address1, String address2, String city, String state, String code, String country, String phone, String website, String filepath, String descript, int add_user, Date last_mod) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
        this.phone = phone;
        this.website = website;
        this.filepath = filepath;
        this.descript = descript;
        this.add_user = add_user;
        this.last_mod = last_mod;
    }
}
