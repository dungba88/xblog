package org.xblog.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xblog.app.models.entry.Entry;
import org.xblog.app.models.entry.EntryDAO;
import org.xblog.framework.advices.filters.DataTransformer;
import org.xblog.framework.controllers.XblogController;
import org.xblog.impl.models.entry.EntrySummaryAssembler;

@RestController
public class EntryController extends XblogController {
	
	@Autowired
	private EntryDAO entryDAO;

	@RequestMapping("/post/{alias}")
	public Entry get(@PathVariable("alias") String alias) {
		return entryDAO.getByAlias(alias);
	}
	
	@DataTransformer(EntrySummaryAssembler.class)
	@RequestMapping("/posts")
	public List<Entry> index() {
		return entryDAO.getEntries();
	}
}
