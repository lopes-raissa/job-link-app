package com.example.joblink.model

class JobLink {

    var name = ""
    var sexo = ""
    var birthDate = ""
    var email = ""
    var cpf = ""
    var password = ""

    override fun toString(): String {
        return "JobLink(name='$name', sexo='$sexo', birthDate='$birthDate', email='$email', cpf='$cpf', password='$password')"
    }
}