package br.com.lab.impacta.account.model

import lombok.Data
import javax.persistence.*

@Data
@Entity
class Account () {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "number")
    var number: Long = 0

    @Column(name = "balance")
    var balance: Double = 0.0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    lateinit var customer: Person

    fun debit (valueOfDebit : Double) : Boolean {
        if ( this.balance < valueOfDebit) {
            return false
        }

        var debitedAmount: Double = this.balance - valueOfDebit
        this.balance = debitedAmount

        return true
    }

}