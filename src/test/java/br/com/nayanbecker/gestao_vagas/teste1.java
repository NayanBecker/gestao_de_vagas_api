package br.com.nayanbecker.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class teste1 {

    @Test
    public void shouldBeReturnCalculateTwoNumbers(){
        var result = calculate(2, 3);
        assertEquals(5, result);

    }

    public static int calculate(int num1, int num2){
        return num1 + num2;
    }
}
