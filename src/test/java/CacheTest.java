import com.domain.Dispatcher;
import com.dto.DispatcherDto;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class CacheTest {

    @Test
    public void search() {
        List<Dispatcher> globalDisp = new ArrayList<>();
        List<String> availiable = initAvail();
        List<Dispatcher> disps = initDisp();

        availiable.forEach(a -> getByName(disps, a, globalDisp));
        globalDisp.forEach(System.out::println);
    }

    public void getByName(List<Dispatcher> disps, String name, List<Dispatcher> globalDisp) {
        List<Dispatcher> temp = disps.stream()
                .filter(n -> n.getDispatcherName().equals(name))
                .collect(Collectors.toList());
        globalDisp.addAll(temp);

    }

    public List<Dispatcher> initDisp() {
        List<Dispatcher> disps = new ArrayList<>();
        disps.add(new Dispatcher().setDispatcherFrase("asd1").setCreateDate(System.currentTimeMillis()).setDispatcherName("a"));
        disps.add(new Dispatcher().setDispatcherFrase("asd2").setCreateDate(System.currentTimeMillis()).setDispatcherName("a"));
        disps.add(new Dispatcher().setDispatcherFrase("asd3").setCreateDate(System.currentTimeMillis()).setDispatcherName("a"));
        disps.add(new Dispatcher().setDispatcherFrase("bbb1").setCreateDate(System.currentTimeMillis()).setDispatcherName("b"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("bb"));
        disps.add(new Dispatcher().setDispatcherFrase("bbb2").setCreateDate(System.currentTimeMillis()).setDispatcherName("b"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("cv"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("sdf"));
        disps.add(new Dispatcher().setDispatcherFrase("asd4").setCreateDate(System.currentTimeMillis()).setDispatcherName("a"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("sd"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("asd"));

        return disps;
    }

    public List<String> initAvail() {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("bb");
        strings.add("sdf");
        strings.add("asd");
        strings.add("a");

        return strings;
    }
}
