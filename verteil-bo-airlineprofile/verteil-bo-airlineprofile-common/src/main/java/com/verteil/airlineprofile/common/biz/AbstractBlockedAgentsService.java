package com.verteil.airlineprofile.common.biz;

import com.verteil.airlineprofile.common.dao.BlockedAgentsDao;
import com.verteil.commons.support.AbstractBaseService;

public abstract class AbstractBlockedAgentsService extends AbstractBaseService implements BlockedAgentsService {

	protected BlockedAgentsDao blockedAgentsDao;

	public BlockedAgentsDao getBlockedAgentsDao() {
		return blockedAgentsDao;
	}

	public void setBlockedAgentsDao(BlockedAgentsDao blockedAgentsDao) {
		this.blockedAgentsDao = blockedAgentsDao;
	}
}
