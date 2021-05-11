package com.example.joblink.datasource

import com.example.joblink.model.Publication

class Datasource {

    companion object {
        fun getPublications(): ArrayList<Publication>{
            var publications = ArrayList<Publication>()

            publications.add(Publication(1, "Matheus Henrique", "10/05/2021", "Elestricista","Primeira Publicação no App", 5.0f))
            publications.add(Publication(2, "Rilary Laisa", "10/05/2021", "Elestricista", "Segunda Publicação no App", 5.0f))
            publications.add(Publication(3, "Fernando Henrique", "11/05/2021","Elestricista","kfgkdegpkdfgpkdef Publicação no App", 5.0f))
            publications.add(Publication(4, "Roberta Laisa", "12/05/2021", "Elestricista","fyfyuhhhhhhh na Publicação no App", 5.0f))

            return publications
        }
    }
}