package geoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    public void byIpTestLocalhost(){
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location(null, null, null, 0);

        Location result = geoService.byIp("127.0.0.1");

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void byIpTestMoscowIp() {
        String ipAdr = "172.";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);

        Location result = geoService.byIp(ipAdr);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void byIpTestNYIp(){
        String ipAdr = "96.";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, null, 0);

        Location result = geoService.byIp(ipAdr);

        Assertions.assertEquals(expected, result);
    }




}
