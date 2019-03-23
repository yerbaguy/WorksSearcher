package com.ebartmedia.workssearch.models

data class AddPersonsResponse (

    val error: Boolean,
    val message: String,
    val persons: Persons
)