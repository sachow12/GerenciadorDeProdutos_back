package elevar.gerenciamento.Deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Deserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getText();
        if (value != null && !value.isEmpty()) {
            return Collections.singletonList(value);  // Retorna a URL em uma lista
        }
        return Collections.emptyList();  // Retorna lista vazia se o campo for vazio
    }
}
