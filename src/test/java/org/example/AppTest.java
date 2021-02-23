package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    App sut= new App();

    @ParameterizedTest
    @ValueSource(ints = {1,2,7,38,92})
    public void shouldReturnInput(int input){
        shouldReturnExpected(input,Integer.toString(input));
    }

    @ParameterizedTest
    @ValueSource( ints = { 3,6,9,21,99} )
    public void shouldReturnFizz(int input) {
        shouldReturnExpected(input, "fizz");
    }

    @ParameterizedTest
    @ValueSource( ints = { 5,10,20,100 } )
    public void shouldReturnBuzz(int input) {
        shouldReturnExpected(input, "buzz");
    }

    @ParameterizedTest
    @ValueSource( ints = { 15,30,45,60,75,90 } )
    public void shouldReturnFizzBuzz(int input) {
        shouldReturnExpected(input, "fizzbuzz");
    }

    private void shouldReturnExpected(int input, String expected) {
        Object actual = sut.fizzbuzz(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
