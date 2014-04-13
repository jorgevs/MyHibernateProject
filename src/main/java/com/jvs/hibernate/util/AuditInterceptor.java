package com.jvs.hibernate.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.jvs.hibernate.entity.AuditBaseEntityImpl;
import com.jvs.hibernate.entity.User;

public class AuditInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = -3921415340618120683L;

	
	private static ThreadLocal userPerThread = new ThreadLocal();

	/**
	 * Store the user for the current thread.
	 * @param user
	 * Cannot be null or empty.
	 */
	public static void setUserIdForCurrentThread(Long userId) {
		userPerThread.set(userId);
	}

	/**
	 * Get the user for the current thread. 
	 * (Used primarily for testing).
	 * @return the current user.
	 */
	public static Long getUserIdForCurrentThread() {
		return (Long) userPerThread.get();
	}


	// This method is called when an object gets updated
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		boolean changed = false;
	
		if (entity instanceof AuditBaseEntityImpl) {
			changed = updateAuditable(currentState, propertyNames);
		}
		return changed;
	}

	// This method is called when an object gets created 
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] currentState, String[] propertyNames, Type[] types) {
		boolean changed = false;

		if (entity instanceof AuditBaseEntityImpl) {
			changed = updateAuditable(currentState, propertyNames);
		}
		return changed;
	}

	
	private boolean updateAuditable(Object[] currentState, String[] propertyNames) {
		boolean changed = false;
		
		for (int i = 0; i < propertyNames.length; i++) {
			if ("createUserId".equals(propertyNames[i])) {
				if (currentState[i] == null) {
					currentState[i] = userPerThread.get();
					changed = true;
				}
			}
			
			if ("createDate".equals(propertyNames[i])) {
				if (currentState[i] == null) {
					currentState[i] = Calendar.getInstance().getTime();
					changed = true;
				}
			}
			
			if ("updateUserId".equals(propertyNames[i])) {
				currentState[i] = userPerThread.get();
				changed = true;
			}
			
			if ("updateDate".equals(propertyNames[i])) {
				currentState[i] = Calendar.getInstance().getTime();
				changed = true;				
			}			
		}
		return changed;
	}

}
