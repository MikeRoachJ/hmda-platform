package hmda.validation.rules.lar.validity

import hmda.model.filing.lar.LoanApplicationRegister
import hmda.model.filing.lar.enums._
import hmda.validation.dsl.PredicateCommon._
import hmda.validation.dsl.PredicateSyntax._
import hmda.validation.dsl.ValidationResult
import hmda.validation.rules.EditCheck

object V678_2 extends EditCheck[LoanApplicationRegister] {
  override def name: String = "V678-2"

  override def parent: String = "V678"

  override def apply(lar: LoanApplicationRegister): ValidationResult =
    when(lar.action.actionTakenType is equalTo(PurchasedLoan)) {
      lar.loan.prepaymentPenaltyTerm is oneOf("NA", "Exempt")
    }
}
