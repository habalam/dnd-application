package sk.dnd.domain.character;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import com.google.common.collect.ComparisonChain;
import sk.dnd.domain.util.DndConsts;
import com.google.common.base.Objects;

@Embeddable
public class ClassificationLocalePk implements Comparable<ClassificationLocalePk>, Serializable {

	private String langCode;
	private Integer classificationId;

	@NotNull
	@Column(name = "DND_CLASSIFICATION_ID", nullable = false, insertable = false, updatable = false)
	public Integer getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}

	@NotNull
	@Column(name = "LANG_CODE", nullable = false, length = DndConsts.LANG_CODE_LEN)
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	@Override
	public int compareTo(ClassificationLocalePk other) {
		return ComparisonChain.start().compare(classificationId, other.getClassificationId()).compare(langCode, other.getLangCode()).result();
	}

	public int hashCode () {
		return Objects.hashCode(classificationId, langCode);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj
			|| obj instanceof ClassificationLocalePk
			&& Objects.equal(classificationId, ((ClassificationLocalePk) obj).getClassificationId())
			&& Objects.equal(langCode, ((ClassificationLocalePk) obj).getLangCode());
	}
}
