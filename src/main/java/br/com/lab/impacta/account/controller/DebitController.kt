package br.com.lab.impacta.account.controller


import br.com.lab.impacta.account.application.AccountApplication
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/accounts")
class DebitController(val accountApplication: AccountApplication) {

    @PostMapping("/{accountId}/debit")
    fun debit(@PathVariable accountId: Long,
              @RequestBody debitAccountRequest: DebitAccountRequest):
            ResponseEntity<DebitAccountResponse> {
        val debitAccountResponse = accountApplication.debit(accountId, debitAccountRequest)

        return ResponseEntity.ok(debitAccountResponse)
    }
}