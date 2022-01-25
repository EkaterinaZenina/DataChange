import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class ShouldRegByAccountTest {
    String planingDate = DataGenerator.generateDate(3);
    @Test
    public void shouldRegByAccount() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        $("[data-test-id='city'] input").setValue(DataGenerator.getCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(DataGenerator.generateDate(3));
        $("[data-test-id='name'] input").setValue(DataGenerator.getName());
        $x("//*[@name='phone']").setValue(DataGenerator.getPhone());
        $(".checkbox__box").click();
        $("button.button").click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + planingDate), Duration.ofSeconds(15)).shouldBe(visible);

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(DataGenerator.generateDate(6));
        $$(".button").find(text("Запланировать")).click();
        $$(".button__text").find(text("Перепланировать")).click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + DataGenerator.generateDate(6)), Duration.ofSeconds(15)).shouldBe(visible);
    }
}



