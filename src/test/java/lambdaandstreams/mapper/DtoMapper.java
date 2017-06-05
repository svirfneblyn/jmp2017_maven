package lambdaandstreams.mapper;

import com.domain.Dispatcher;
import com.dto.DispatcherDto;

import java.util.function.Function;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class DtoMapper implements Function<Dispatcher, DispatcherDto> {
    @Override
    public DispatcherDto apply(Dispatcher dispatcher) {
        return new DispatcherDto()
                .setCreateTime(dispatcher.getCreateDate())
                .setDispatcherFrase(dispatcher.getDispatcherFrase())
                .setDispatcherName(dispatcher.getDispatcherName());
    }
}
