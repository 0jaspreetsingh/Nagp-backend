package com.nagarro.nagpmanagement.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.nagarro.nagpmanagement.model.Activity;

public class ActivityIdGenerator implements IdentifierGenerator {

	public int generateRandomId() {
		Random random = new Random();
		return random.nextInt(100);
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Activity activity = (Activity) object;
		String key = null;
		if (activity.getActivity_id() != null) {
			key = activity.getActivity_id();
		} else {
			key = "BATCH_" + this.generateRandomId() + Calendar.getInstance().getTimeInMillis();
			System.out.println(key);
		}
		return key;
	}

}
