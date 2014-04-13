package com.jvs.hibernate.entity;

import java.util.Date;

public interface AuditBaseEntity extends BaseEntity {

	public Long getCreateUserId();

	public void setCreateUserId(Long createUserId);

	public Long getUpdateUserId();

	public void setUpdateUserId(Long updateUserId);

	public Date getCreateDate();

	public void setCreateDate(Date createDate);

	public Date getUpdateDate();

	public void setUpdateDate(Date updateDate);

}
