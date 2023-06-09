package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class PetStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long petStoreId;
	private String petStoreName;
	private Integer petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private Integer petStoreZip;
	private Integer petStorePhoNum;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet_store_customer", joinColumns
			= @JoinColumn(name = "pet_store_id"),
			inverseJoinColumns=@JoinColumn(name =
			"customer_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	Set<Customer> customers = new HashSet<Customer>();
	
	@OneToMany(mappedBy = "petStore", cascade =
			CascadeType.ALL, orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	Set<Employee> employees = new HashSet<Employee>();
	
}
