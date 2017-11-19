package sk.dnd.domain.character;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import sk.dnd.domain.util.DndConsts;
import com.google.common.base.Objects;

@Entity
@Table(
	name = "DND_CLASSIFICATION_L",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"DND_CLASSIFICATION_ID", "LANG_CODE"})}
)
public class ClassificationLocale implements Serializable {

	private ClassificationLocalePk classificationLocalePk;

	private String name;
	private String description;

	private Classification classification;

	@EmbeddedId
	public ClassificationLocalePk getClassificationLocalePk() {
		return classificationLocalePk;
	}

	public void setClassificationLocalePk(ClassificationLocalePk classificationLocalePk) {
		this.classificationLocalePk = classificationLocalePk;
	}

	public void setLangCode(String langCode) {
		if(getClassificationLocalePk() == null) {
			setClassificationLocalePk(new ClassificationLocalePk());
		}
		getClassificationLocalePk().setLangCode(langCode);
	}

	@NotNull
	@Length(max = DndConsts.CLASSIFICATION_NAME_LEN)
	@Column(name = "NAME", length = DndConsts.CLASSIFICATION_NAME_LEN)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	@JoinColumn(name = "DND_CLASSIFICATION_ID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
		if(classification != null) {
			setIdClass(classification.getId());
		}
	}

	public void setIdClass(Integer idClass) {
		if (getClassificationLocalePk() == null) {
			setClassificationLocalePk(new ClassificationLocalePk());
		}
		getClassificationLocalePk().setClassificationId(idClass);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getClassificationLocalePk());
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj
			|| obj instanceof ClassificationLocale
			&& Objects.equal(getClassificationLocalePk(), ((ClassificationLocale) obj).getClassificationLocalePk());
	}
}
