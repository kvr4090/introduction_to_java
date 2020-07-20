package by.tc.task01.main;

import by.tc.task01.entity.*;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliance) {

		for (Appliance currentAppliance : appliance) {

			if (currentAppliance instanceof Laptop) {
				System.out.print(Laptop.class.getSimpleName() + " : ");
				soutArray(((Laptop) currentAppliance).getProperties());
			}

			if (currentAppliance instanceof Oven) {
				System.out.print(Oven.class.getSimpleName() + " : ");
				soutArray(((Oven) currentAppliance).getProperties());
			}

			if (currentAppliance instanceof Refrigerator) {
				System.out.print(Refrigerator.class.getSimpleName() + " : ");
				soutArray(((Refrigerator) currentAppliance).getProperties());
			}

			if (currentAppliance instanceof Speakers) {
				System.out.print(Speakers.class.getSimpleName() + " : ");
				soutArray(((Speakers) currentAppliance).getProperties());
			}

			if (currentAppliance instanceof TabletPC) {
				System.out.print(TabletPC.class.getSimpleName() + " : ");
				soutArray(((TabletPC) currentAppliance).getProperties());
			}

			if (currentAppliance instanceof VacuumCleaner) {
				System.out.print(VacuumCleaner.class.getSimpleName() + " : ");
				soutArray(((VacuumCleaner) currentAppliance).getProperties());
			}
		}
	}
	
	private static void soutArray(String[] props) {
		for (int i = 1; i < props.length - 1; i += 2) {
			System.out.print(props[i] + ", " + props[i + 1] + ", ");
		}
		System.out.println();
	} 
}
