package com.attiead.student.common.command

interface CommandHandler<T> where T : Command {
    fun handle(message: T)
}
