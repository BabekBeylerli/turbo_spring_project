package com.example.turbospringproject.json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BooleanDefaultFalseSerializer extends JsonSerializer<Boolean> {

    @Override
    public void serialize(Boolean value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeBoolean(value);
        } else {
            gen.writeBoolean(false);
        }
    }
}