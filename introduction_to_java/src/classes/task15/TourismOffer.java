package classes.task15;

public class TourismOffer {
    private String typeRest;
    private String typeTransport;
    private String typeNutrition;
    private int countDay;

    public TourismOffer(String typeRest, String typeTransport, String typeNutrition, int countDay) {
        this.typeRest = typeRest;
        this.typeTransport = typeTransport;
        this.typeNutrition = typeNutrition;
        this.countDay = countDay;
    }

    public String getTypeRest() {
        return typeRest;
    }

    public String getTypeTransport() {
        return typeTransport;
    }

    public String getTypeNutrition() {
        return typeNutrition;
    }

    public int getCountDay() {
        return countDay;
    }

    public void toScreen() {
        System.out.println("Туристическая путевка на " + typeRest +", доступны следующие виды траспорта: " +
                typeTransport + "\n, доступно питание: " + typeNutrition+
                ", путевка рассчитана на "+ countDay + " дней.");
    }
}
