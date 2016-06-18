package com.jl.platform.domain;

import java.util.List;

import javax.annotation.Resource;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import com.jl.platform.common.BizException;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.common.util.AssertUtil;
import com.jl.platform.service.StaffStoreService;
import com.jl.platform.service.model.Staff;
import com.jl.platform.service.model.common.PageQueryRequest;
import com.jl.platform.service.model.common.PageResult;

@Service("staffStoreService")
public class StaffStoreServiceImpl implements StaffStoreService {
	@Resource
	private CouchDbClient couchDbClient;

	@Override
	public Result<String> saveStaff(Staff staff) {
		AssertUtil.assertNotNull(StatusCode.NULL_PARAM, staff);
		Response response = null;
		try {
			response = couchDbClient.save(staff);
		} catch (Exception e) {
			throw new BizException(StatusCode.SYSTEM_ERROR);
		}

		AssertUtil.assertNotNull(StatusCode.SYSTEM_ERROR, response);
		return new Result<String>(response.getId());
	}

	@Override
	public PageResult<List<Staff>> queryPages(PageQueryRequest pageReq) {
		AssertUtil.assertNotNull(StatusCode.NULL_PARAM, pageReq);

		List<Staff> staffs = couchDbClient.view("staff/queryPage")
				.includeDocs(true).skip(pageReq.getPageNo() - 1)
				.limit(pageReq.getPageSize()).query(Staff.class);

		PageResult<List<Staff>> result = new PageResult<List<Staff>>(staffs);
		result.setPageSize(pageReq.getPageSize());

		return result;
	}
}
