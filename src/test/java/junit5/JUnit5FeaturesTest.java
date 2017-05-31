package junit5;

import com.Application;
import com.domain.Dispatcher;
import com.domain.Quizz;
import com.domain.relations.manytomany.TopicManyToMany;
import com.resource.mock.MockitoExtension;
import com.service.manytomany.ITopicMtM;
import com.service.onetomany.IAnswerOneToMany;
import com.service.onetomany.IQuestionOneToMany;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class JUnit5FeaturesTest {
    @Autowired
    private ITopicMtM iTopicMtM;
    @Autowired
    private static IQuestionOneToMany repo;
    @Autowired
    private IAnswerOneToMany iAnswerRepo;

    /*Beforeclass заменена на BeforeAll*/

    @BeforeAll
    static void beforeAll() {
        initMock();
        assertNotNull(repo.exists(1L));
        System.out.println("Before All");
    }

    void initMock(@Mock Quizz quizz) {
        when(quizz.getName()).thenReturn("QUIZZ");
    }

    @Test
    void mockTest(@Mock Quizz quizz) {
        assertEquals("QUIZZ", quizz.getName());
    }

    /*
     *Dynamic test
     *
     */
    @TestFactory
    @DisplayName("Dynamic tests ")
    Iterable<DynamicTest> selectFromTablesTest() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        return ids.stream()
                .map(id -> DynamicTest.dynamicTest("Test findOne by ID: " + id, () -> {
                    TopicManyToMany topic = iTopicMtM.findOne(id);
                    assertNotNull(topic);
                })).collect(Collectors.toList());
    }

    /*Поддержка лямбды в ассертах.*/
    @Test
    void findOneByIdAndCheckIsActiveTest() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        ids.forEach(id ->
                assertTrue(() -> iAnswerRepo.findOne(id).isActive()));
    }

    @Test
    void assertAllTest() {
        Executable[] executables = {
                () -> assertTrue(findByName(getFilledDispatcherList("unique_name1", "unique_name2"), "unique_name1").equals("asd1")),
                () -> assertTrue(findByName(getFilledDispatcherList("unique_name1", "unique_name2"), "unique_name2").equals("frase_2"))};

        Assertions.assertAll("Get fraes by names", executables);
        getFilledDispatcherList("unique_name1", "unique_name2");
        Assertions.assertAll("Get fraes by names one more time", executables);
    }


    public void showFilteredFrases() {
        List<Dispatcher> globalDisp = new ArrayList<>();
        List<String> availiable = getNameList();
        List<Dispatcher> disps = getFilledDispatcherList("unique_name1", "unique_name2");
        availiable.forEach(a -> fillEmptyList(disps, a, globalDisp));
        globalDisp.forEach(System.out::println);
    }

    public void fillEmptyList(List<Dispatcher> disps, String name, List<Dispatcher> globalDisp) {
        List<Dispatcher> temp = disps.stream()
                .filter(n -> n.getDispatcherName().equals(name))
                .collect(Collectors.toList());
        globalDisp.addAll(temp);
    }

    public String findByName(List<Dispatcher> disps, String name) {
        final String[] frase = new String[1];
        disps.stream().filter(n -> n.getDispatcherName().equals(name))
                .map(n -> frase[0] = n.getDispatcherFrase());

        ;
        return frase[0];
    }

    public List<Dispatcher> getFilledDispatcherList(String name1, String name2) {
        List<Dispatcher> disps = new ArrayList<>();
        disps.add(new Dispatcher().setDispatcherFrase("asd1").setCreateDate(System.currentTimeMillis()).setDispatcherName(name1));
        disps.add(new Dispatcher().setDispatcherFrase("asd2").setCreateDate(System.currentTimeMillis()).setDispatcherName("a"));
        disps.add(new Dispatcher().setDispatcherFrase("asd3").setCreateDate(System.currentTimeMillis()).setDispatcherName("a"));
        disps.add(new Dispatcher().setDispatcherFrase("bbb1").setCreateDate(System.currentTimeMillis()).setDispatcherName("b"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("bb"));
        disps.add(new Dispatcher().setDispatcherFrase("bbb2").setCreateDate(System.currentTimeMillis()).setDispatcherName("b"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("cv"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("sdf"));
        disps.add(new Dispatcher().setDispatcherFrase("frase_2").setCreateDate(System.currentTimeMillis()).setDispatcherName(name2));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("sd"));
        disps.add(new Dispatcher().setDispatcherFrase("asd").setCreateDate(System.currentTimeMillis()).setDispatcherName("asd"));

        return disps;
    }

    public List<String> getNameList() {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("bb");
        strings.add("sdf");
        strings.add("asd");
        strings.add("a");

        return strings;
    }

}
