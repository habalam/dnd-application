package sk.dnd.domain.infra;

import java.io.Serializable;

import com.google.common.base.Objects;

public abstract class BaseObject<T extends Serializable> implements Serializable  {

	private T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{id=" + getId() + "}";
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj != null && getClass().isAssignableFrom(obj.getClass()) && Objects.equal(getId(), ((BaseObject)obj).getId());
	}

	public static Serializable foreignKeyToString(BaseObject<Integer> baseObject) {
		return baseObject != null ? baseObject.getId() : null;
	}
}
