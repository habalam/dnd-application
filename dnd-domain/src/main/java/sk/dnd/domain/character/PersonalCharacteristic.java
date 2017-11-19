package sk.dnd.domain.character;

import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.character.support.PersonalCharacteristicType;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_PERSONAL_CHARACTERISTIC")
public class PersonalCharacteristic extends BaseObject<Integer> {

	private PersonalCharacteristicType type;
	private Map<String, PersonalCharacteristicLocale> locales;

	@Override
	@Id
	@NotNull
	@Column(name = "DND_PERSONAL_CHARACTERISTIC_ID", nullable = false)
	@GeneratedValue(generator = "DND_PERSONAL_CHARACTERISTIC_ID")
	@GenericGenerator(
		name = "DND_PERSONAL_CHARACTERISTIC_ID",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_PERSONAL_CHARACTERISTIC_ID"),
			@Parameter(name = "pool_size", value = "20")
		})
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	public PersonalCharacteristicType getType() {
		return type;
	}

	public void setType(PersonalCharacteristicType type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "personalCharacteristic", fetch = FetchType.LAZY)
	@MapKey(name = "personalCharacteristicLocalePk.langCode")
	public Map<String, PersonalCharacteristicLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, PersonalCharacteristicLocale> locales) {
		this.locales = locales;
	}
}
