# The KSA DSL definition

# FEE MANAGEMENT DSL definitions

[keyword][]and = &&
[keyword][]equals = ==

# LHS definitions
[when][]\({constraints}\) = context : BrmContext({constraints})
[when][]Student account ID is "{userId}" = account.id == "{userId}"
[when][]Student is resident = feeManagementService.isResident(feeBase)
[when][]Student is not resident = !feeManagementService.isResident(feeBase)
[when][]Student is graduate = feeManagementService.isGraduate(feeBase)
[when][]Student is not graduate = !feeManagementService.isGraduate(feeBase)
[when][]LU code is "{luCodes}" with status "{statuses}" = feeManagementService.containsLearningUnitCode(feeBase, "{luCodes}", "{statuses}")
[when][]Major is "{majorCodes}" = feeManagementService.containsMajorCode(feeBase, "{majorCodes}")
[when][]Section is "{sectionCodes}" with status "{statuses}" = feeManagementService.containsSectionCode(feeBase, "{sectionCodes}", "{statuses}")
[when][]Number of credits is {numberOfCredits} with status "{status}" = feeManagementService.getNumOfCredits(feeBase, "{status}") == {numberOfCredits}
[when][]Number of credits > {numberOfCredits} with status "{status}" = feeManagementService.getNumOfCredits(feeBase, "{status}") > {numberOfCredits}
[when][]Number of credits < {numberOfCredits} with status "{status}" = feeManagementService.getNumOfCredits(feeBase, "{status}") < {numberOfCredits}
[when][]Key pair "{key}" is "{values}" = feeManagementService.containsKeyPair(feeBase, "{key}", "{values}")

# RHS definitions
[then][]Use code "{transactionTypeId}" to charge ${amount} = context.getTransactionService().createTransaction("{transactionTypeId}",context.getAccount().getId(), new Date(), new BigDecimal({amount}));
[then][]Use code "{transactionTypeId}" to credit ${amount} = context.getTransactionService().createTransaction("{transactionTypeId}",context.getAccount().getId(), new Date(), new BigDecimal({amount}));
[then][]Set status to "{status}", key pair "{key}" to "{value}" where code is "{luCodes}" = context.getFeeManagementService().setCourseStatusForLearningUnits(feeBase,"{luCodes}","{status}","{key}","{value}");
[then][]Set status to "{status}", key pair "{key}" to "{value}" where section is "{sectionCodes}" = context.getFeeManagementService().setCourseStatusForSections(feeBase,"{sectionCodes}","{status}","{key}","{value}");
[then][]Set status to "{newStatus}", key pair "{key}" to "{value}" where status is "{oldStatus}" = context.getFeeManagementService().setCourseStatusForStatus(feeBase,"{oldStatus}","{newStatus}","{key}","{value}");
[then][]Number of credits for LU code "{luCodes}" with status "{statuses}" = context.getFeeManagementService().getNumOfCreditsByLearningUnitCodes(feeBase,"{luCodes}","{statuses}");
[then][]Use "{transactionTypeId}" to charge ${amountPerCredit} per credit where section is "{sectionCodes}" with status "{statuses}" = context.getFeeManagementService().createTransactionForNumberOfCredits(feeBase,"{transactionTypeId}",new BigDecimal({amountPerCredit}),"{sectionCodes}","{statuses}");


# PAYMENT APPLICATION DSL definitions

# LHS definitions
[when][]Context is initialized = isInitialized()

# RHS definitions
[then][]Set global variable "{globalVariable}" to "{attributeValue}" = context.getBrmPaymentService().setGlobalVariableToAttributeValue("{globalVariable}", "{attributeValue}", context);
[then][]Initialize list of transactions as "{transactions}" = context.getAttributes().put("{transactions}", TransactionUtils.newTransactionList());
[then][]Initialize list of GL transactions as "{glTransactions}" = context.getAttributes().put("{glTransactions}", TransactionUtils.newGlTransactionList());
[then][]Get list of transactions from "{startDate}" to "{endDate}", store result in "{transactions}" = context.getBrmPaymentService().getActiveTransactions("{startDate}", "{endDate}", "{transactions}", context);
[then][]Remove allocations from "{transactions}", add result to "{glTransactions}" = context.getBrmPaymentService().removeAllocations("{transactions}", "{glTransactions}", context);
[then][]Remove "{entries}" from "{transactions}" = context.getBrmPaymentService().removeTransactions("{entries}", "{transactions}", context);
[then][]Allocate reversals for "{transactions}", add result to "{glTransactions}" = context.getBrmPaymentService().allocateReversals("{transactions}", "{glTransactions}", context);
[then][]Apply payments for "{transactions}", add result to "{glTransactions}" = context.getBrmPaymentService().applyPayments("{transactions}", "{glTransactions}", context);
[then][]Apply payments with maximum amount ${amount} for "{transactions}", add result to "{glTransactions}" = context.getBrmPaymentService().applyPayments(new BigDecimal({amount}), "{transactions}", "{glTransactions}", context);
[then][]Calculate matrix scores for "{transactions}" = context.getBrmPaymentService().calculateMatrixScores("{transactions}", context);
[then][]Summarize GL transactions "{glTransactions}" = context.getBrmPaymentService().summarizeGlTransactions("{glTransactions}", context);

# Transaction sorting
[then][]Sort "{transactions}" by matrix score in ascending order = context.getBrmPaymentService().sortByMatrixScore("{transactions}", true, context);
[then][]Sort "{transactions}" by matrix score in descending order = context.getBrmPaymentService().sortByMatrixScore("{transactions}", false, context);
[then][]Sort "{transactions}" by priority in ascending order = context.getBrmPaymentService().sortByPriority("{transactions}", true, context);
[then][]Sort "{transactions}" by priority in descending order = context.getBrmPaymentService().sortByPriority("{transactions}", false, context);
[then][]Sort "{transactions}" by effective date in ascending order = context.getBrmPaymentService().sortByEffectiveDate("{transactions}", true, context);
[then][]Sort "{transactions}" by effective date in descending order = context.getBrmPaymentService().sortByEffectiveDate("{transactions}", false, context);

# Transaction filters
[then][]Get payments from "{transactions}" for {year} year, store result in "{payments}" = context.getBrmPaymentService().filterTransactions(TransactionTypeValue.PAYMENT, {year}, "{transactions}", "{payments}", context);
[then][]Get payments from "{transactions}", store result in "{payments}" = context.getBrmPaymentService().filterTransactions(TransactionTypeValue.PAYMENT, "{transactions}", "{payments}", context);
[then][]Get payments with tag "{tag}" from "{transactions}" for {year} year, store result in "{payments}" = context.getBrmPaymentService().filterTransactions(TransactionTypeValue.PAYMENT, {year}, "{tag}", "{transactions}", "{payments}", context);
[then][]Get charges from "{transactions}" for {year} year, store result in "{charges}" = context.getBrmPaymentService().filterTransactions(TransactionTypeValue.CHARGE, {year}, "{transactions}", "{charges}", context);
[then][]Get charges from "{transactions}", store result in "{charges}" = context.getBrmPaymentService().filterTransactions(TransactionTypeValue.CHARGE, "{transactions}", "{charges}", context);
[then][]Get charges with tag "{tag}" from "{transactions}" for {year} year, store result in "{charges}" = context.getBrmPaymentService().filterTransactions(TransactionTypeValue.CHARGE, {year}, "{tag}", "{transactions}", "{charges}", context);

