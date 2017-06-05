package lambdaandstreams;

import com.domain.Dispatcher;
import com.dto.DispatcherDto;
import lambdaandstreams.functionalinterfaces.ChatBotStringAbility;
import lambdaandstreams.functionalinterfaces.IChatBot;
import lambdaandstreams.functionalinterfaces.IDispatcherCreator;
import lambdaandstreams.mapper.DtoMapper;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */

/* Streams, Lambdas, use filter, sort, forEach, map, reduce, collect, peek, min, max, ...<br />
- Сделайте стрим параллельным<br /> - Comparator - создание компараторов в коде<br />
- JavaScript engine - напишите простенький javascript-код и запустите его в JVM<br /> - Optional + ifPresent</p>*/

public class LambdaTest {
    Dispatcher dispatcher;
    DispatcherDto dto;
    static List<Dispatcher> dispList;

    @BeforeAll
    static void initCollection() {
        IDispatcherCreator dc = Dispatcher::new;
        int count = 1000000;
        dispList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            dispList.add(dc.getDispatsher()
                    .setCreateDate(System.currentTimeMillis())
                    .setDispatcherFrase("I'm dispatcher number " + i)
                    .setDispatcherName("D_" + i));
        }

    }

    @Ignore
    @Test
    void lambdaTests() {
        IChatBot activateBotTalkAbility = System.out::println;
        ChatBotStringAbility toUpperCase = String::toUpperCase;
        ChatBotStringAbility replaseChars = string -> string.replace("a", "TT");
        ChatBotStringAbility getFirestChars = string -> string.substring(0, 3);

        activateBotTalkAbility.print("I'm chat bot");
        activateBotTalkAbility.print(lambdaOperation("pi kawa lybi java", toUpperCase));
        activateBotTalkAbility.print(lambdaOperation("pi kawa lybi java", replaseChars));
        activateBotTalkAbility.print(lambdaOperation("pi kawa lybi java", getFirestChars));

        /*
        * output :
        *
        *    I'm chat bot
        *    PI KAWA LYBI JAVA
        *    pi kTTwTT lybi jTTvTT
        *    pi
        *
        * */
    }

    private String lambdaOperation(String string, ChatBotStringAbility ability) {
        return ability.returnString(string);
    }

    @Test
    void streamTest() {
        List<DispatcherDto> dtoList = new ArrayList<>();
        Map<String, DispatcherDto> dtoMap = new HashMap<>();
        DtoMapper dtoMapper = new DtoMapper();
        System.out.println(dispList.size());
        Long timeBefore = System.currentTimeMillis();
        dtoList = dispList.stream()
                //   dtoMap =    dispList.stream()
           /*Допустимы так же : .map(d -> dtoMapper.apply(d)) и map(dtoMapper::apply)*/
                .map(dtoMapper)
                .filter(d -> Long.parseLong(d.getDispatcherName().substring(2)) % 2 == 0)
                .filter(d -> d.getDispatcherFrase().length() > 10)
                .sorted(Comparator.comparing(DispatcherDto::getDispatcherName))
//ограничивет стрим первыми N Элементами , указываемые в
                .limit(1000000)
// пропускает заданное колличество элементов                 .skip()
                /*метод peek нужен для дебага. позволяет проверить значение интересующих переменных в стриме. при выводе на консоль
                  замедляет тест значительно*/
                //      .peek(dispatcherDto -> System.out.println(dispatcherDto.getDispatcherName()) )
                .collect(Collectors.toList())
        //   .collect(Collectors.toMap(DispatcherDto::getDispatcherName, d -> d))
        // sort нельзя применить после collect :  .sort((Comparator.comparing(DispatcherDto::getCreateTime)))
        // - применяется на готовую коллекцию и сортирует её
        ;
        Long timeAfter = System.currentTimeMillis();
        dtoList.sort((Comparator.comparing(DispatcherDto::getCreateTime)));
        //  System.out.println(dtoMap.size());
/*Для использования min max нужно определить компоратор и передать его в функцию*/
        Comparator<DispatcherDto> cd = Comparator.comparingInt(d1 -> d1.getDispatcherFrase().length());
        System.out.println(" DispatcherDto with MAX length frase : " + dtoList.stream().max(cd).get());
        System.out.println(" DispatcherDto with MIN frase length : " + dtoList.stream().min(cd).get());

        /* DispatcherDto with MAX length frase : DispatcherDto(dispatcherName=D_100000, dispatcherFrase=I'm dispatcher number 100000, createTime=1496598245693)
          DispatcherDto with MIN frase length : DispatcherDto(dispatcherName=D_0, dispatcherFrase=I'm dispatcher number 0, createTime=1496598245626)*/

        System.out.println("operation took " + getStreamTime(timeBefore, timeAfter) + "ms");
        System.out.println(dtoList.size());

        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        Long timeBeforePararlel = System.currentTimeMillis();

        dtoList = dispList.parallelStream()
                .map(dtoMapper)
                .filter(d -> Long.parseLong(d.getDispatcherName().substring(2)) % 2 == 0)
                .filter(d -> d.getDispatcherFrase().length() > 10)
                .parallel()
                .sorted(Comparator.comparing(DispatcherDto::getDispatcherName))
                .limit(1000000)
                .collect(Collectors.toList());
        Long afterParalel = System.currentTimeMillis();
        System.out.println("Pararlel stream operation took " + getStreamTime(timeBeforePararlel, afterParalel) + "ms");
        System.out.println("processors : " + availableProcessors);

        /*Siquence operation took 184ms -
          * Pararlel stream operation took 135ms*/
    }

    private Long getStreamTime(Long before, Long after) {
        return after - before;
    }

    @Test
    void reduceTest() {
        List<Integer> intList = Arrays.asList(1, 11, 22, 33, 44, 33, 11, 223, 22);
        // reduce принимает два значения, текущее и следующее , и кусок кода для манипуляции со значениями.
        // ifPresent - срабатывает если есть результат.
        // isPresent - boolean возвращает true, если присутствует элемент.
        intList.stream()
                .reduce((i1, i2) -> (i1 + i2))
                .ifPresent(sum -> System.out.println("Sum = " + sum));
       /* OUTPUT :
        * Sum = 400
        */
    }

    @Test
    void optionalTest() {
        Optional<Dispatcher> optionalDispatcher = Optional.empty();
        Dispatcher disp = optionalDispatcher
                .orElse(new Dispatcher().setCreateDate(System.currentTimeMillis())
                        .setDispatcherFrase("I'm Optioanal dispatcher ")
                        .setDispatcherName("D_opt"));
        System.out.println(disp.toString());
        ;
    }

    @Test
    void jsEngineTest() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("javascript");
        String string = "JAVA";
        Double result = null;


        try {
            engine.eval("var x = 10;");
            engine.eval("var y = 20;");
            engine.eval("print('" + string + "')");
            //Работает с Double только ? при Integer exception
            result = (Double) engine.eval("x + y");

        } catch (ScriptException e) {
            System.out.println("Error executing script: " + e.getMessage());
        }

        System.out.println(result.toString());
    }
}

