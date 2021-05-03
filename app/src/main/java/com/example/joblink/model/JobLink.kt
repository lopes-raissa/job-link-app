package com.example.joblink.model

class JobLink {

    var name = ""
    var sexo = ""
    var dataNasc = ""
    var email = ""
    var cpf = ""
    var senha = ""

    override fun toString(): String {
        return "JobLink(name='$name', sexo='$sexo', dataNasc='$dataNasc', email='$email', cpf='$cpf', senha='$senha')"
    }

}