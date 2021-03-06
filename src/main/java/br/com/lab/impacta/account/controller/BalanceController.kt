package br.com.lab.impacta.account.controller

import br.com.lab.impacta.account.application.AccountApplication
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/accounts")
class BalanceController(val accountApplication : AccountApplication) {

    @GetMapping("/{accountId}/balance")
    fun balance(@PathVariable accountId: Long): ResponseEntity<AccountBalanceResponse> {
        val accountBalanceResponse: AccountBalanceResponse = accountApplication.balance(accountId)
        return ResponseEntity.ok(accountBalanceResponse)
    }
}