package com.neptuz.neptuz.Objects

class OUser {

    var username: String
    var email: String
    var password: String
    var signed_in: String
    var status: String


    constructor(username: String, email: String, password: String, signed_in: String, status: String) {

        this.username = username
        this.email = email
        this.password = password
        this.signed_in = signed_in
        this.status = status

    }

}