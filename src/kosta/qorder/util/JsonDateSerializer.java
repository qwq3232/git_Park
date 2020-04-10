package kosta.qorder.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<Date>
{
	public void serialize(Date date, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException 
	{
	      gen.writeString(new SimpleDateFormat("yyyyMMdd").format(date));
	}
}
