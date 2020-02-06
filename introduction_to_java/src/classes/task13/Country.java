package classes.task13;

/*
 * Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль
 * столицу, количество областей, площадь, областные центры.
 */

public class Country {
    private double area;
    private Town capital;
    private District[] districts;

    public Country(Town capital, District[] districts) {
        this.capital = capital;
        this.districts = districts;
    }

    public void capital() {
        System.out.println(capital.getName());
    }

    public void getCountDistrict() {
        System.out.println(districts.length);
    }

    public void getAreaCountry() {
        for (District district : districts) {
            area += district.getArea();
        }
        System.out.println(area);
    }

    public void getDistrictCenters() {
        for (District district : districts) {
            System.out.println(district.getDistrictCenter().getName());
        }
    }

    public static void main(String[] args) {
        Region[] mogilevski = {new Region(15.5), new Region(20), new Region(35.6)};
        District mogilev = new District(mogilevski, new Town("Mogilev"));
        Region[] vitebski = {new Region(24), new Region(15), new Region(56.8)};
        District vitebsk = new District(vitebski, new Town("Vitebsk"));
        Region[] gomelski = {new Region(45.6), new Region(55.7), new Region(98)};
        District gomel = new District(gomelski,new Town("Gomel"));
        District[] utopia = {mogilev, vitebsk, gomel};

        Country newLook = new Country(new Town("Orsha"), utopia);
        newLook.capital();
        newLook.getAreaCountry();
        newLook.getCountDistrict();
        newLook.getDistrictCenters();
    }
}
