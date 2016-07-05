package cybage.spring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="beer")
public class DomesticBeer implements Beer {

	 @Id 
	 @GeneratedValue
	private long id;
	
	@NotNull  
	@NotEmpty
	@NotBlank
	@Size(max = 20)  
	private String brand;
	
	
	
	private BigDecimal price=BigDecimal.ZERO;

	 /**
     * Gets id (primary key).
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return this.id;
	}

	

    @Column(name="brand",nullable=false,unique=true)
	public String getBrand() {
		return this.brand;
	}


    @Column(name="price",nullable=false)
	public BigDecimal getPrice() {
		return this.price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = (PRIME * result)
				+ ((this.brand == null) ? 0 : this.brand.hashCode());
		result = (PRIME * result) + (int) (this.id ^ (this.id >>> 32));
		result = (PRIME * result)
				+ ((this.price == null) ? 0 : this.price.hashCode());
		return result;
	}

	public void setBrand(final String brand) {
		this.brand = brand;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final DomesticBeer other = (DomesticBeer) obj;
		if (this.brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!this.brand.equals(other.brand)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!this.price.equals(other.price)) {
			return false;
		}
		return true;
	}

}
