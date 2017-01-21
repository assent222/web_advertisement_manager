package pkk.interview.converter;

import org.joda.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;

/**
 * Created by root on 06.12.2016.
 */

@Converter(autoApply = true)
public class JodaLocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return (locDateTime == null ? null : new Timestamp(locDateTime.toDateTime().getMillis()));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return (sqlTimestamp == null ? null : new LocalDateTime(sqlTimestamp));
    }
}
