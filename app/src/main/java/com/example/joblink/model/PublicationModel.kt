package com.example.joblink.model

data class PublicationModel(
    var id: Long = 0,
    var name: String = "",
    var title: String = "",
    var profission: String = "",
    var description: String = "",
    var datePublication: String = "",
    var urlImage: String = "",
    var urgency: Int = 0,
    var attendance: Int = 0,
    var is_announcement: Boolean = true,
    var freelancerNote: Float = 1.0f
)