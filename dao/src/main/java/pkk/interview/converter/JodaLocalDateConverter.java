package pkk.interview.converter;

import org.joda.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;

/**
 * Created by root on 06.12.2016.
 */

@Converter(autoApply = true)
public class JodaLocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : new Date(locDate.toDate().getTime()));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : new LocalDate(sqlDate));
    }
}
