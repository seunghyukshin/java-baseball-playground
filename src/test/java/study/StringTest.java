package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
//        assertThat(actual).isEqualTo("adc");
        String expected = "adc";
        Assertions.assertEquals(actual, expected);
    }
    @Test
    @DisplayName("�䱸����1")
    void split(){
        // �䱸���� 1
        String input = "1,2";
        String[] actual = input.split(",");
        String expected = "1";
        assertThat(actual).contains(expected);
    }

    @Test
    @DisplayName("�䱸����2")
    void substring(){
        String input = "(1,2)";
        String actual = input.substring(1,input.length() - 1);
        String expected = "1,2";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Ư�� ��ġ ���� ��ȸ")
    void charAt(){
        String testData = "abc";

        assertThatThrownBy(() -> {
            String actual = String.valueOf(testData.charAt(1));
            String expected = "b";

            assertThat(actual).isEqualTo(expected);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");

    }
}
