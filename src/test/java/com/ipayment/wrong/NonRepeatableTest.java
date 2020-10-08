package com.ipayment.wrong;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonRepeatableTest {

    @Test
    void shouldReturnPMAfterNoon() {
        PartOfDay partOfDay = new PartOfDay();
        assertEquals("PM", partOfDay.find());
    }


    static class PartOfDay {

        String find() {
            if(LocalTime.now().isBefore(LocalTime.NOON)) {
                return "AM";
            }
            return "PM";
        }
    }
}
