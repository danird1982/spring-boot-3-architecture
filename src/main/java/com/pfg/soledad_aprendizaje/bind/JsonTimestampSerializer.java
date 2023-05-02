package com.pfg.soledad_aprendizaje.bind;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.pfg.soledad_aprendizaje.constant.Constant;

@Component
public class JsonTimestampSerializer extends JsonSerializer<Timestamp> {

	private DateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT_DB);

	@Override
	public void serialize(Timestamp time, JsonGenerator generator, SerializerProvider arg2) throws IOException, JsonProcessingException {

		String strDate = dateFormat.format(time.getTime());
		generator.writeString(strDate);
	}

}
