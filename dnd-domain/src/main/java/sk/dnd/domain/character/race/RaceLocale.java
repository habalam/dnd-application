package sk.dnd.domain.character.race;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DND_RACE_L")
public class RaceLocale {

	private RaceLocalePk raceLocalePk;

	private String name;
	private String age;
	private String alignment;
	private String size;
	private String description;

	private Race race;

	@EmbeddedId
	public RaceLocalePk getRaceLocalePk() {
		return raceLocalePk;
	}

	public void setRaceLocalePk(RaceLocalePk raceLocalePk) {
		this.raceLocalePk = raceLocalePk;
	}

	public void setLangCode(String langCode) {
		if(getRaceLocalePk() == null) {
			setRaceLocalePk(new RaceLocalePk());
		}
		getRaceLocalePk().setLangCode(langCode);
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DND_RACE_ID", nullable = false, updatable = false, insertable = false)
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
		if (race != null) {
			setRaceId(race.getId());
		}
	}

	public void setRaceId(Integer raceId) {
		if(getRaceLocalePk() == null) {
			setRaceLocalePk(new RaceLocalePk());
		}
		getRaceLocalePk().setRaceId(raceId);
	}

	@NotNull
	@Column(name = "AGE", nullable = false)
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@NotNull
	@Column(name = "ALIGNMENT")
	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	@NotNull
	@Column(name = "SIZE")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@NotNull
	@Lob
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
