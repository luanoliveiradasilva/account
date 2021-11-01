package br.com.lab.impacta.account.handler.exception


class AccountWithoutBalanceException(override val message: String,
                                     val description: String): RuntimeException(message) {
}