import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodParser {

    public List<String> parseIngredients(String url) {
        List<String> ingredients = new ArrayList<>();
        try {
            // Получаем HTML документ по указанному URL
            Document doc = Jsoup.connect(url).get();

            // Находим элементы, содержащие информацию о составе корма
            // Пример селектора, который нужно настроить под конкретный сайт
            Elements elements = doc.select(".ingredient-list-class");

            // Извлекаем текст из найденных элементов
            for (Element element : elements) {
                ingredients.add(element.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
}
