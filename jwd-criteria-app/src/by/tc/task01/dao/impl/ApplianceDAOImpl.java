package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO{

	private List<Appliance> result;

	@Override
	public List<Appliance> find(Criteria criteria) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("F:\\appliances_db.txt"));
		String line;
		result = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			String[] temp = splitPropertiesDevice(line);

			if (criteria.getGroupSearchName().equals("Laptop") && isCondition(criteria,temp)) {
				result.add(new Laptop(temp));
			} else if (criteria.getGroupSearchName().equals("Oven") && isCondition(criteria, temp)) {
				result.add(new Oven(temp));
			} else if (criteria.getGroupSearchName().equals("Refrigerator") && isCondition(criteria, temp)) {
				result.add(new Refrigerator(temp));
			} else if (criteria.getGroupSearchName().equals("Speakers") && isCondition(criteria, temp)) {
				result.add(new Speakers(temp));
			} else if (criteria.getGroupSearchName().equals("TabletPC") && isCondition(criteria, temp)) {
				result.add(new TabletPC(temp));
			} else if (criteria.getGroupSearchName().equals("VacuumCleaner") && isCondition(criteria, temp)) {
				result.add(new VacuumCleaner(temp));
			}
		}

		return result;
	}

	private String[] splitPropertiesDevice(String string) {
		Pattern pattern = Pattern.compile("[=:,]");
		return pattern.split(string);
	}

	private boolean isCondition(Criteria crt, String[] props) {
		int counter = crt.getCriteria().size();
		int currentCounter = 0;


		for (int i = props.length - 1; i > 2 ; i -= 2) {
			for (Map.Entry<String, Object> current : crt.getCriteria().entrySet()) {

				if (current.getKey().trim().equalsIgnoreCase(props[i-1].trim()) && current.getValue().toString().trim().equalsIgnoreCase(props[i].trim())) {
					currentCounter++;
				}
			}

		}

		return currentCounter == counter;
	}

}


