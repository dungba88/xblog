package org.xblog.framework.advices.filters;

public interface IDataTransformer<T> {

	public Object assemble(T model);
}
