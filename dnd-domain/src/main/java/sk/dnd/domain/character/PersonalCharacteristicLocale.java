package sk.dnd.domain.character;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DND_PERSONAL_CHARACTERISTIC_L")
public class PersonalCharacteristicLocale implements Serializable {

	private PersonalCharacteristicLocalePk personalCharacteristicLocalePk;

	private String name;
	private String description;

	private PersonalCharacteristic personalCharacteristic;

	@EmbeddedId
	public PersonalCharacteristicLocalePk getPersonalCharacteristicLocalePk() {
		return personalCharacteristicLocalePk;
	}

	public void setPersonalCharacteristicLocalePk(PersonalCharacteristicLocalePk personalCharacteristicLocalePk) {
		this.personalCharacteristicLocalePk = personalCharacteristicLocalePk;
	}

	public void setLangCode(String langCode) {
		if(getPersonalCharacteristicLocalePk() == null) {
			setPersonalCharacteristicLocalePk(new PersonalCharacteristicLocalePk());
		}
		getPersonalCharacteristicLocalePk().setLangCode(langCode);
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DND_PERSONAL_CHARACTERISTIC_ID", nullable = false, insertable = false, updatable = false)
	public PersonalCharacteristic getPersonalCharacteristic() {
		return personalCharacteristic;
	}

	public void setPersonalCharacteristic(PersonalCharacteristic personalCharacteristic) {
		this.personalCharacteristic = personalCharacteristic;
		if(personalCharacteristic != null) {
			setId(personalCharacteristic.getId());
		}
	}

	public void setId(Integer id) {
		if(getPersonalCharacteristicLocalePk() == null) {
			setPersonalCharacteristicLocalePk(new PersonalCharacteristicLocalePk());
		}
		getPersonalCharacteristicLocalePk().setPersonalCharactericId(id);
	}
}
