package bots

import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.bots.DefaultAbsSender
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.io.File

class WCCBot : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "TreinamentoKotlinBot"
    }

    override fun getBotToken(): String {
        // Return bot token from BotFather
        return "2059263538:AAFIwo1TLldhMjAUJpyTEsAY4tWHtiIUi6E"
    }

    override fun onUpdateReceived(update: Update?) {

        // We check if the update has a message and the message has text
        val nameSender = update?.message?.from?.firstName
        val chatId = update?.message?.chatId.toString()
        val messageCommand = update?.message?.text

        try {
            if (messageCommand == "/welcome") {
              val sendAudio = SendAudio().apply {
                    val file = File("/home/etiene/Documentos/audio.mp3")
                    this.chatId = chatId
                    this.audio = InputFile().setMedia(file)
                    this.caption =
                        getMessage(messageCommand, nameSender)
                    this.parseMode = "MarkdownV2"
                }
                execute(sendAudio)

            } else {
                val sendDocument = SendDocument().apply {
                    this.chatId = chatId
                    this.caption =
                        getMessage(messageCommand, nameSender) //EmojiParser.parseToUnicode("Oláaa $nameSender :smile:")
                    this.document = InputFile().setMedia("https://media.giphy.com/media/Cmr1OMJ2FN0B2/giphy.gif")
                    this.parseMode = "MarkdownV2"
                }
                execute(sendDocument)
            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

    private fun getMessage(command: String?, nameSender: String?) = when (command) {
        "/info" -> EmojiParser.parseToUnicode("No momento não possuímos mais informações :weary:, novidades em breve :smiley: ")
        "/start" -> home(nameSender)
        "/welcome" -> "Welcome"

        else -> "Por favor, selecione uma das opções anteriores"
    }


    private fun home(nameSender: String?) = """
        *Olá $nameSender, tudo bem\?*
        
        Por favor, selecione uma das opções:
        
        \/start \- começar o projeto
        \/welcome \- Bem vindo
        \/info \- para saber mais sobre o projeto
        
    """.trimMargin()

    /* private fun welcome(nameSender: String?) = """
         *Olá $nameSender, tudo bem\?*

         Por favor, selecione uma das opções:

         \/start \- começar o projeto
         \/info \- para saber mais sobre o projeto
     """.trimMargin()*/
}

