package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.form.JournalForm;
import com.jl.platform.service.form.UpdateJournalForm;
import com.jl.platform.service.model.Journal;

public interface JournalService {

	Result<String> save(JournalForm journalForm);

	Result<Pagination<Journal>> pageQery(PageQuery pageQuery);

	/**
	 * @param id
	 * @return Result
	 */
	Result delete(String id);

	/**
	 * @param updateJournalForm
	 * @return Result
	 */
	Result update(UpdateJournalForm updateJournalForm);
}
