package com.jl.platform.service.impl;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Journal;
import com.jl.platform.dao.mongo.BuildingDao;
import com.jl.platform.dao.mongo.JournalDao;
import com.jl.platform.dao.mongo.StaffDao;
import com.jl.platform.form.JournalForm;
import com.jl.platform.service.JournalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service("journalService")
public class JournalServiceImpl implements JournalService {
	@Resource
	private JournalDao journalDao;
	@Resource
	private StaffDao staffDao;
	@Resource
	private BuildingDao buildingDao;


	@Override
	public Result<String> save(JournalForm journalForm) {
		return null;
	}

	@Override
	public Result<Pagination<Journal>> pageQuery(PageQuery pageQuery) {
		return null;
	}

	@Override
	public Result delete(String id) {
		return null;
	}

	@Override
	public Result update(JournalForm journalForm) {
		return null;
	}

	@Override
	public Result queryById(String id) {
		return null;
	}
}
