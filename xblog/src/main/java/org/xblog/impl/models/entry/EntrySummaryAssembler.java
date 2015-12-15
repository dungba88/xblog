package org.xblog.impl.models.entry;

import org.xblog.app.models.entry.Entry;
import org.xblog.framework.advices.filters.IDataTransformer;

public class EntrySummaryAssembler implements IDataTransformer<Entry> {

	@Override
	public Object assemble(Entry model) {
		model.setContent(null);
		model.setMarkdownContent(null);
		return model;
	}
}
