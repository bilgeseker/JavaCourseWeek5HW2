package Kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Technologies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Technology {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="techId")
	private int id;
	
	@Column(name="techName")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id")
	private ProgrammingLanguage language;
}
