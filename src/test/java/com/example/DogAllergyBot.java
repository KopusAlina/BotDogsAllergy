import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DogAllergyBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "YourBotUsername";
    }

    @Override
    public String getBotToken() {
        return "YOUR_BOT_TOKEN";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                sendMsg(chatId, "Добро пожаловать в бот для подбора корма для собак! Бот поможет вам определить на что у вашей собаки аллергия.");
            }
            // Add more command handling here
        } else if (update.hasMessage() && update.getMessage().hasPhoto()) {
            long chatId = update.getMessage().getChatId();
            // Handle photo message
        }
    }

    private void sendMsg(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // Добавьте сюда больше методов для анализа и обработки пользовательских настроек.
}
