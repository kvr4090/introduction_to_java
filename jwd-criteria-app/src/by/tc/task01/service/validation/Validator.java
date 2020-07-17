package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {

		for (Map.Entry<String, Object> pair : criteria.getCriteria().entrySet()) {

			if (pair.getKey() == null || pair.getValue() == null) {
				return false;
			}
		}

		return true;
	}

}
