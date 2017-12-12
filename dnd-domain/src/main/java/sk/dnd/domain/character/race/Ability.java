package sk.dnd.domain.character.race;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import sk.dnd.domain.infra.BaseObject;

@Entity
@Table(name = "DND_ABILITY")
//TODO nezohladnuje fungovanie abilit, iba popis
//TODO premenovat - ability su hlavne staty postavy
public class Ability extends BaseObject<Integer> {

	private Map<String, AbilityLocale> locales;

	@Override
	@Id
	@Column(name = "DND_ABILITY_ID", nullable = false)
	@GeneratedValue(generator = "DND_RACE_ABILITY_GEN")
	@GenericGenerator(name = "DND_RACE_ABILITY_GEN",
		strategy = "sk.dnd.domain.infra.PoolIdGenerator",
		parameters = {
			@Parameter(name = "table", value = "SYS_SEQUENCE"),
			@Parameter(name = "primary_key_column", value = "SEQ_NAME"),
			@Parameter(name = "value_columen", value = "SEQ_VALUE"),
			@Parameter(name = "primary_key_value", value = "DND_ABILITY_ID"),
			@Parameter(name = "pool_size", value = "20")
		}
	)
	public Integer getId() {
		return super.getId();
	}

	@NotNull
	@OneToMany(mappedBy = "ability", fetch = FetchType.LAZY)
	@MapKey(name = "abilityLocalePk.langCode")
	public Map<String, AbilityLocale> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, AbilityLocale> locales) {
		this.locales = locales;
	}
}
