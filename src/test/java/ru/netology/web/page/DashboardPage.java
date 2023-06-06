package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

  private final String startBalance = "баланс: ";
  private final String finishBalance = " р.";
  private final SelenideElement heading = $("[data-test-id=dashboard]");
  private final ElementsCollection cards = $$(".list__item div");

  public DashboardPage() {
    heading.shouldBe(visible);
  }

  public int getCardBalance (DataHelper.CardInfo cardInfo) {
    var text = cards.findBy(Condition.text(cardInfo.getCardNumber().substring(15))).getText();
    return extractBalance(text);
  }

  private int extractBalance (String text){
    var start = text.indexOf(startBalance);
    var finish = text.indexOf(finishBalance);
    var value = text.substring(start + startBalance.length(), finish);
    return Integer.parseInt(value);
  }

  public TransferPage selectCardToTransfer(DataHelper.CardInfo cardInfo) {
    cards.findBy(attribute("data-test-id", cardInfo.getTestId())).$("button").click();
    return new TransferPage();
  }






}
