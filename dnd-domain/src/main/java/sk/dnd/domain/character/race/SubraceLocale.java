package sk.dnd.domain.character.race;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DND_SUBRACE_L")
public class SubraceLocale {

	private SubraceLocalePk subraceLocalePk;
	private String name;
	private String description;

	private Subrace subrace;

	@EmbeddedId
	public SubraceLocalePk getSubraceLocalePk() {
		return subraceLocalePk;
	}

	public void setSubraceLocalePk(SubraceLocalePk subraceLocalePk) {
		this.subraceLocalePk = subraceLocalePk;
	}

	public void setLangCode(String langCode) {
		if(getSubraceLocalePk() == null) {
			setSubraceLocalePk(new SubraceLocalePk());
		}
		getSubraceLocalePk().setLangCode(langCode);
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "DND_SUBRACE_ID", nullable = false, updatable = false, insertable = false)
	public Subrace getSubrace() {
		return subrace;
	}

	public void setSubrace(Subrace subrace) {
		this.subrace = subrace;
		if (subrace != null) {
			setSubraceId(subrace.getId());
		}
	}

	private void setSubraceId(Integer subraceId) {
		if(getSubraceLocalePk() == null) {
			setSubraceLocalePk(new SubraceLocalePk());
		}
		getSubraceLocalePk().setSubraceId(subraceId);
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
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
