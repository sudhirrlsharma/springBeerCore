package cybage.spring.model;

import java.math.BigDecimal;

public interface Beer {
	public String getBrand();

	public long getId();

	public BigDecimal getPrice();

	public void setBrand(String brand);

	public void setId(long id);

	public void setPrice(BigDecimal price);
}
