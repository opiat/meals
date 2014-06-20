package wwirzbicki.util;

import java.io.IOException;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDate> {
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd-MM-yyyy");

	@Override
	public void serialize(LocalDate value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeString(FORMATTER.print(value));
	}

}
