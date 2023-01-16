package lt.povilas.springdemo.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "productlines")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class ProductLines {
    @Id
    @Column(name = "productline")
    private String productLine;
    @Column(name = "textdescription")
    private String textDescription;
    @Column(name = "htmldescription")
    private String htmlDescription;


}