package cz.etn.etnshop.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;


@Entity
@Indexed//Added for fulltext search capability
@Table(name="product")
public class Product implements Serializable {
	
 	private static final long serialVersionUID = -2739622030641073946L; 	

	private int id;
 
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)//Added for fulltext search capability
	private String name;
    
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)//Added for fulltext search capability
	private String sn; //Serial number may consist from numbers or characters

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    @Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	@Column(name = "sn", nullable = false) // getter for Serial number, column name in database is sn and null value is prohibited 
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) { // Setter for Serial number
		this.sn = sn;
	} 
    
}
