package classes.task15;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 * различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
 * возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */

public class Selection {
    TourismOffer[] tourismOffers;

    public void sortOffersCountDays() {
        Comparator<TourismOffer> comparator = (Comparator.comparingInt(TourismOffer::getCountDay));
        Arrays.sort(tourismOffers, comparator);
    }

    public void sortOffersTransport() {
        Comparator<TourismOffer> comparator = (Comparator.comparing(TourismOffer::getTypeTransport));
        Arrays.sort(tourismOffers, comparator);
    }

    public void sortOffersNutrition() {
        Comparator<TourismOffer> comparator = (Comparator.comparing(TourismOffer::getTypeNutrition));
        Arrays.sort(tourismOffers, comparator);
    }

    public void select(String requestTypeRest, String requestTransport, String requestNutrition, int requestCountDays) {
        for (TourismOffer offer : tourismOffers) {
            if (offer.getTypeRest().equals(requestTypeRest) &&
                    offer.getTypeTransport().equals(requestTransport) &&
                    offer.getTypeNutrition().equals(requestNutrition) &&
                    offer.getCountDay()==requestCountDays) {

                offer.toScreen();
            }
        }
    }
}
