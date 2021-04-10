package com.github.caioreigot.model

data class Email (
    val user: String,
    val subject: String,
    val preview: String,
    val date: String,
    val stared: Boolean,
    val unread: Boolean,
    var selected: Boolean = false
)

class EmailBuilder {
    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var date: String = ""
    var stared: Boolean = false
    var unread: Boolean = false

    fun build(): Email {
        return Email(user, subject, preview, date, stared, unread, false)
    }
}

fun email(block: EmailBuilder.() -> Unit): Email {
    // .apply vai sobrescrever os membros da classe, depois irá dar um .build() com os novos membros
    return EmailBuilder().apply(block).build()
}

fun fakeEmails() = mutableListOf(
    email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais para dominar C++"
        preview = "Olá Caio, você precisa ver esse site para dominar os fundamentos de C++"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "Um amigo quer que você curta uma página dele!"
        preview = "Fulano convidou você para curtir a sua página"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Curso em Vídeo acabou de enviar um vídeo"
        preview = "Curso em Vídeo enviou KOTLIN M00A00 - Conheça a Linguagem Kotlin"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Instagram"
        subject = "Veja nossas três dicas principais para dominar C++"
        preview = "Olá Caio, você precisa ver esse site para dominar os fundamentos de C++"
        date = "26 jun"
        stared = true
    },
    email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais para dominar C++"
        preview = "Olá Caio, você precisa ver esse site para dominar os fundamentos de C++"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "Um amigo quer que você curta uma página dele!"
        preview = "Fulano convidou você para curtir a sua página"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Curso em Vídeo acabou de enviar um vídeo"
        preview = "Curso em Vídeo enviou KOTLIN M00A00 - Conheça a Linguagem Kotlin"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Jornal"
        subject = "Veja nossas últimas notícias"
        preview = "Um carro foi abandonado após colidir com um poste de energia. O acidente aconteceu nessa sexta-feira (9) no bairro Monte Retiro, em Campo Grande. Segundo o Batalhão de Polícia Militar de Trânsito, o motorista fugiu logo após bater na estrutura. Eles informaram ainda que moradores do local penduram um lençol branco para poder sinalizar os fios que estavam pela rua."
        date = "26 jun"
        stared = false
    },
    email {
        user = "Instagram"
        subject = "Veja nossas três dicas principais para dominar C++"
        preview = "Olá Caio, você precisa ver esse site para dominar os fundamentos de C++"
        date = "26 jun"
        stared = true
    },
    email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais para dominar C++"
        preview = "Olá Caio, você precisa ver esse site para dominar os fundamentos de C++"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "Um amigo quer que você curta uma página dele!"
        preview = "Fulano convidou você para curtir a sua página"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Curso em Vídeo acabou de enviar um vídeo"
        preview = "Curso em Vídeo enviou KOTLIN M00A00 - Conheça a Linguagem Kotlin"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "Veja nossas três dicas principais para você conseguir"
        preview = "Olá Caio, você precisa ver esse site para dominar os fundamentos de C++"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Curso em Vídeo acabou de enviar um vídeo"
        preview = "Curso em Vídeo enviou KOTLIN M00A00 - Conheça a Linguagem Kotlin"
        date = "26 jun"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "Um amigo quer que você curta uma página dele!"
        preview = "Fulano convidou você para curtir a sua página"
        date = "26 jun"
        stared = false
    },
)