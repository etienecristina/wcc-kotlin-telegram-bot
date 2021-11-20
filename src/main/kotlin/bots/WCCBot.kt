package bots

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update


class WCCBot : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        return "TreinamentoKotlinBot"
    }

    override fun getBotToken(): String {
        return "2059263538:AAFIwo1TLldhMjAUJpyTEsAY4tWHtiIUi6E"
    }

    override fun onUpdateReceived(update: Update?) {

        val nomeUsuario = update?.message?.from?.firstName
        val mensagemUsuario = update?.message?.text



        when (mensagemUsuario) {
            "/start" -> {
                val mensagemResposta = SendDocument()

                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/kH6CqYiquZawmU1HI6/giphy.gif")
                mensagemResposta.caption = """Olá, $nomeUsuario!
                    Digite algum comando do Git para obter informações:
                    Lembre-se de colocar a barra (/) antes da palavra e escrevê-las juntas!
                    
                    Caso queira acessar a documentação completa, escreva: /documentacao
                                                                      
                    """.trimMargin()

                execute(mensagemResposta)
            }

            ("/documentacao") -> {
                val mensagemResposta = SendMessage()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.text = ("https://git-scm.com/docs/git/pt_BR")

                execute(mensagemResposta)
            }

            ("/gitinit") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif")
                mensagemResposta.caption =
                    "Esse comando cria um repositório vazio ou transforma uma pasta que você já tem, " +
                            "e que não está com controle de versão, em um repositório."

                execute(mensagemResposta)
            }

            ("/gitstatus") -> {
                val mensagemResposta = SendMessage()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.text =
                    "O comando Git Status fornece algumas informações sobre a branch em que você estiver no momento, " +
                            "como seu nome, se ela está atualizada em relação à master e quais arquivos foram alterados."

                execute(mensagemResposta)
            }

            ("/gitclone") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/TlK63EA6F1qRb7lll6M/giphy.gif")
                mensagemResposta.caption =
                    "O Git clone é um comando para baixar o código-fonte existente de um repositório remoto " +
                            "(como o Github, por exemplo)."

                execute(mensagemResposta)
            }

            ("/gitbranch") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/PQzS26JMdv1EzlsZAn/giphy-downsized-large.gif")
                mensagemResposta.caption =
                    "O comando Git Branch permite criar, listar, renomear e excluir ramificações, vários desenvolvedores " +
                            "podem trabalhar paralelamente no mesmo projeto. " +
                            "Assim, cada um pode codar a sua parte sem se atrapalharem."
                execute(mensagemResposta)
            }


            ("/gitcheckout") -> {
                val mensagemResposta = SendMessage()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.text =
                    "O Git Checkout pode ser usado para criar localmente uma branch remota. " +
                            "Se você fizer o clone de algum repositório, será criado localmente somente a branch master. " +
                            "Se você desejar trabalhar em cima de outra branch, " +
                            "basta executar o comando git checkout nova-branch , e a branch será criada localmente."

                execute(mensagemResposta)
            }

            ("/gitcommit") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/XITSlI6EriGDEzw6iL/giphy.gif")
                mensagemResposta.caption = "Salva mudanças no repositório local e adiciona mensagem de commit."
                execute(mensagemResposta)
            }


            ("/gitlog") -> {
                val mensagemResposta = SendMessage()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.text = "Mostra histórico de alterações em ordem cronológica."

                execute(mensagemResposta)
            }

            ("/gitdiff") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/ezSHWBV6btGX1befHM/giphy.gif")
                mensagemResposta.caption =
                    "Faz a comparação entre dois commits. Mostra quais foram os arquivos alterados, novos e removidos. " +
                            "Além disso, mostra também quais foram as linhas alteradas."

                execute(mensagemResposta)
            }

            ("/gitpull") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/BTYPaGRiUAwi9l0YLc/giphy.gif")
                mensagemResposta.caption =
                    "Atualiza repositório local com a última versão da origem da branch. " +
                            "É necessário commitar as mudanças para executar essa ação."

                execute(mensagemResposta)
            }

            ("/gitpush") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/dXFkMqRL9LB2jJGRh1/giphy.gif")
                mensagemResposta.caption =
                    "Faz o envio das mudanças comitadas localmente para a origem da branch rastreada"

                execute(mensagemResposta)
            }


            ("/gitmerge") -> {
                val mensagemResposta = SendDocument()
                mensagemResposta.chatId = update?.message?.chatId.toString()
                mensagemResposta.document =
                    InputFile().setMedia("https://media.giphy.com/media/cFkiFMDg3iFoI/giphy.gif")
                mensagemResposta.caption =
                    "O comando Git Merge é o que unifica algum histórico bifurcado. Resumindo, " +
                            "o Git merge permite que você pegue as linhas criadas a partir do Git branch e " +
                            "faça uma integração para a ramificação principal."

                execute(mensagemResposta)
            }
        }
    }
}

