package junit.demoqa;

import junit.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    public void checkForm() {
        textBoxPage.openPage()
                .setFullName("Иван", "Иванов")
                .setUserEmail("fgdfg@yandex.ru")
                .setCurrentAddress("some address1")
                .setPermanentAddress("some address2")
                .clickSubmitButton();

        textBoxPage.verifyResult("Иван Иванов", "fgdfg@yandex.ru",
                "some address1", "some address2");
    }
}
