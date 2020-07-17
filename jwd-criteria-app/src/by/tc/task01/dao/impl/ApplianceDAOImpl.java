package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO{

	private List<Appliance> result;



	@Override
	public List<Appliance> find(Criteria criteria) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("F:\\appliances_db.txt"));
		String line = reader.readLine();
		result = new ArrayList<>();

		while (line != null) {

			if (splitPropertiesDevice(line)[0].trim().equals("Laptop")) {
				result.add(new Laptop(splitPropertiesDevice(line)));
			}

			if (splitPropertiesDevice(line)[0].trim().equals("Oven")) {
				result.add(new Oven(splitPropertiesDevice(line)));
			}

			if (splitPropertiesDevice(line)[0].trim().equals("Refrigerator")) {
				result.add(new Refrigerator(splitPropertiesDevice(line)));
			}

			if (splitPropertiesDevice(line)[0].trim().equals("Speakers")) {
				result.add(new Speakers(splitPropertiesDevice(line)));
			}

			if (splitPropertiesDevice(line)[0].trim().equals("TabletPC")) {
				result.add(new TabletPC(splitPropertiesDevice(line)));
			}

			if (splitPropertiesDevice(line)[0].trim().equals("VacuumCleaner")) {
				result.add(new VacuumCleaner(splitPropertiesDevice(line)));
			}

			line = reader.readLine();
		}

		return result;
	}

	private String[] splitPropertiesDevice(String string) {
		Pattern pattern = Pattern.compile("[=:,]");
		return pattern.split(string);
	}

}


