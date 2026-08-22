package br.com.erudio.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String gender, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (gender == null) {
            gen.writeNull();
            return;
        }

        String formattedGender = switch (gender.toUpperCase()) {
            case "M", "MALE" -> "Male";
            case "F", "FEMALE" -> "Female";
            default -> gender;
        };
        gen.writeString(formattedGender);
    }
}
