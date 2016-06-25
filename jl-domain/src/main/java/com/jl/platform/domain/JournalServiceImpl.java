package com.jl.platform.domain;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Procedure;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.domain.mongodb.BuildingMongoDBStore;
import com.jl.platform.domain.mongodb.JournalMongoDBStore;
import com.jl.platform.domain.mongodb.StaffMongoDBStore;
import com.jl.platform.service.JournalService;
import com.jl.platform.service.form.JournalForm;
import com.jl.platform.service.form.UpdateJournalForm;
import com.jl.platform.service.model.Building;
import com.jl.platform.service.model.Journal;
import com.jl.platform.service.model.Staff;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service("journalService")
public class JournalServiceImpl implements JournalService {
	@Resource
	private JournalMongoDBStore journalMongoDBStore;
	@Resource
	private StaffMongoDBStore staffMongoDBStore;
	@Resource
	private BuildingMongoDBStore buildingMongoDBStore;

	@Override
	public Result<String> save(JournalForm journalForm) {
		Result<Staff> staffResult = staffMongoDBStore.findByName(journalForm
				.getStaff());
		if (staffResult == null || staffResult.getData() == null) {
			return Result.create(StatusCode.STAFF_NOT_FOUND);
		}
		Result<Building> buildingResult = buildingMongoDBStore
				.findByName(journalForm.getBuilding());
		if (buildingResult == null || buildingResult.getData() == null) {
			return Result.create(StatusCode.BUILDING_NOT_FOUND);
		}
		Building building = buildingResult.getData();

		Journal journal = new Journal();
		journal.setStaff(staffResult.getData());
		journal.setBuilding(building);
		journal.setProcedure(Procedure.valueOf(journalForm.getProcedure()));
		journal.setCreateDate(String.valueOf(new Date().getTime()));
		journal.setUpdateDate(String.valueOf(new Date().getTime()));

		return journalMongoDBStore.save(journal);

	}

	@Override
	public Result<Pagination<Journal>> pageQery(PageQuery pageQuery) {
		return journalMongoDBStore.pageQery(pageQuery);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.JournalService#delete(java.lang.String)
	 */
	@Override
	public Result delete(String id) {
		return journalMongoDBStore.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jl.platform.service.JournalService#update(com.jl.platform.service
	 * .form.JournalForm)
	 */
	@Override
	public Result update(UpdateJournalForm updateJournalForm) {

		Result<Staff> staffResult = staffMongoDBStore
				.findByName(updateJournalForm.getStaff());
		if (staffResult == null || staffResult.getData() == null) {
			return Result.create(StatusCode.STAFF_NOT_FOUND);
		}
		Result<Building> buildingResult = buildingMongoDBStore
				.findByName(updateJournalForm.getBuilding());
		if (buildingResult == null || buildingResult.getData() == null) {
			return Result.create(StatusCode.BUILDING_NOT_FOUND);
		}
		Building building = buildingResult.getData();

		Result<Journal> journalResult = journalMongoDBStore
				.findById(updateJournalForm.getId());
		if (journalResult == null || journalResult.getData() == null) {
			return Result.create(StatusCode.JOURNAL_NOT_FOUND);
		}

		Journal journal = journalResult.getData();
		journal.setStaff(staffResult.getData());
		journal.setBuilding(building);
		journal.setProcedure(Procedure.valueOf(updateJournalForm.getProcedure()));
		journal.setCreateDate(String.valueOf(new Date().getTime()));
		journal.setUpdateDate(String.valueOf(new Date().getTime()));

		return journalMongoDBStore.update(journal);
	}
}
