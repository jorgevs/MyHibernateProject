package com.jvs.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AuditBaseEntityImpl extends BaseEntityImpl implements AuditBaseEntity {

	@Column(name = "CREATE_USERID")
	protected Long createUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIMESTAMP")
	protected Date createDate;
	
	@Column(name = "UPDATE_USERID")
	protected Long updateUserId;

	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "UPDATE_TIMESTAMP")
	protected Date updateDate;

	
	
	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
