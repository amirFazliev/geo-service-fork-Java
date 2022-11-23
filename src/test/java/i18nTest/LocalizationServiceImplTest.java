package i18nTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    public void localeTestInRussia() {
        Country countrySUT = Country.RUSSIA;
        LocalizationServiceImpl localizationServiceSUT = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";

        String result = localizationServiceSUT.locale(countrySUT);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void localeTestInNoneRussia() {
        Country countrySUT = Country.BRAZIL;
        LocalizationServiceImpl localizationServiceSUT = new LocalizationServiceImpl();
        String expected = "Welcome";

        String result = localizationServiceSUT.locale(countrySUT);

        Assertions.assertEquals(expected, result);
    }
}
