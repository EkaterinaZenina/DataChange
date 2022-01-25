import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    private static LocalDate today = LocalDate.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String getName() {
        return faker.name().name();
    }

    public static String getPhone() {
        return faker.numerify("+7##########");
    }

    public static String getCity() {
        String[] list = new String[]{"Омск", "Казань", "Томск", "Владивосток", "Архангельск",
                "Мурманск", "Горно-Алтайск", "Череповец", "Чебоксары", "Хабаровск", "Иркутск", "Ростов-на-Дону",
                "Махачкала", "Белгород", "Саранск",
                "Саратов", "Хабаровск", "Рязань", "Брянск", "Великий Новгород", "Курган", "Владимир", "Вологда", "Самара",
                "Чебоксары", "Москва", "Санкт-Петербург", "Ульяновск", "Кострома", "Липецк",  "Симферополь"};
        int city = new Random().nextInt(list.length);
        return list[city];
    }
}


