package hmda.validation.rules.lar.validity

import hmda.model.filing.lar.LoanApplicationRegister
import hmda.model.filing.lar.enums._
import hmda.validation.dsl.PredicateCommon._
import hmda.validation.dsl.PredicateSyntax._
import hmda.validation.dsl.ValidationResult
import hmda.validation.rules.EditCheck

object V694_3 extends EditCheck[LoanApplicationRegister] {
  override def name: String = "V694-3"

  override def parent: String = "V694"

  override def apply(lar: LoanApplicationRegister): ValidationResult =
    when(lar.action.actionTakenType is equalTo(LoanOriginated)) {
      lar.payableToInstitution is oneOf(PayableToInstitutionExempt, InititallyPayableToInstitution, NotInitiallyPayableToInstitution)
    }
}
