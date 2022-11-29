package Kodlama.io.Devs.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Languages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class ProgrammingLanguage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="langName")
	private String name;
	
	@OneToMany(mappedBy="language")
	private Set<Technology> technologies;
}
