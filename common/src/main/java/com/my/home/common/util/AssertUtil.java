/**
 * guanyuhuhu 2016年6月18日
 */
package com.my.home.common.util;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.my.home.common.BizException;
import com.my.home.common.StatusCode;

/**
 * @author zhanglu
 */
public class AssertUtil {
	/**
	 * @param status
	 * @param params
	 *            void
	 */
	public static void assertNotNull(StatusCode status, Object... params) {
		for (Object obj : params) {
			if (obj == null) {
				throw new BizException(status);
			}

			if (obj instanceof String) {
				if (StringUtils.isEmpty(obj)) {
					throw new BizException(status);
				}
			}
			if (obj instanceof Collection || obj instanceof Map) {
				if (CollectionUtils.isEmpty((Collection) obj)) {
					throw new BizException(status);
				}
			}
		}

	}

	/**
	 * @param state
	 * @param status
	 *            void
	 */
	public static void state(boolean state, StatusCode status) {
		if (!state) {
			throw new BizException(status);
		}
	}
}
