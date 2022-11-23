package senderTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    @Test
    public void sendTestInRussia() {
        String ipAdr = "172.123.12.19";

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ipAdr))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAdr);
        String result = messageSenderImpl.send(map);

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, result);
        System.out.println();
    }

    @Test
    public void sendTestInUSA() {
        String ipAdr = "96.123.12.19";

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ipAdr))
                .thenReturn(new Location("New York", Country.USA, null,  0));

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAdr);
        String result = messageSenderImpl.send(map);

        String expected = "Welcome";

        Assertions.assertEquals(expected, result);
        System.out.println();
    }
}
