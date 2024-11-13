package elevar.gerenciamento.Deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Deserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = parser.getText();
        List<String> imgUrls = new ArrayList<>();
        if (value != null && !value.isEmpty()) {
            imgUrls.add(value);
        }
        if (parser.isExpectedStartArrayToken()) {
            imgUrls = parser.readValueAs(List.class);
        }

        return imgUrls;
    }
}


