package domain.home;

import java.util.List;

import javax.annotation.Resource;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import com.my.home.common.BizException;
import com.my.home.common.Result;
import com.my.home.common.StatusCode;
import com.my.home.common.util.AssertUtil;
import com.my.home.service.StaffStoreService;
import com.my.home.service.model.Staff;
import com.my.home.service.model.common.PageQueryRequest;
import com.my.home.service.model.common.PageResult;

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
