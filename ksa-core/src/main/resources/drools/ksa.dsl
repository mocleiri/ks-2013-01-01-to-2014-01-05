# The KSA DSL definition

# Commonly used DSL definitions

[keyword][]and = &&
[keyword][]equals = ==

# LHS definitions

[when][]\({constraints}\) = context : BrmContext({constraints})
[when][]Account ID is "{userId}" = account.id == "{userId}"
[when][]ATP is "{atpIds}" = CommonUtils.containsAny(atpIds, "{atpIds}", ",")
[when][]Transaction type is "{transactionTypeIds}" = CommonUtils.containsAny(transactionTypeIds, "{transactionTypeIds}", ",")
[when][]Hold issue is "{holdIssueNames}" = CommonUtils.containsAny(holdIssueNames, "{holdIssueNames}", ",")
[when][]Permission is "{permissionNames}" = CommonUtils.containsAny(permissionNames, "{permissionNames}", ",")
[when][]Account type is "{accountTypeNames}" = CommonUtils.containsAny(accountTypeNames, "{accountTypeNames}", ",")
[when][]Transaction amount is ${amount} = new BigDecimal({amount}).toString().equals(transactionAmount.toString())
[when][]Transaction amount > ${amount} = transactionAmount.doubleValue() > {amount}
[when][]Transaction amount < ${amount} = transactionAmount.doubleValue() < {amount}
[when][]Flag type is "{flagTypeCodes}" = CommonUtils.containsAny(flagTypeCodes, "{flagTypeCodes}")

# RHS definitions
[then][]Use code "{debitTypeId}" to charge ${debitAmount} = context.getTransactionService().createCharge("{debitTypeId}",context.getAccount().getId(), new Date(), new BigDecimal({debitAmount}));
[then][]Use code "{creditTypeId}" to credit ${creditAmount} = context.getTransactionService().createPayment("{creditTypeId}",context.getAccount().getId(), new Date(), new BigDecimal({creditAmount}));


# FEE MANAGEMENT DSL definitions

# LHS definitions
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
[then][]Set status to "{status}", key pair "{key}" to "{value}" where code is "{luCodes}" = context.getFeeManagementService().setCourseStatusForLearningUnits(feeBase,"{luCodes}","{status}","{key}","{value}");
[then][]Set status to "{status}", key pair "{key}" to "{value}" where section is "{sectionCodes}" = context.getFeeManagementService().setCourseStatusForSections(feeBase,"{sectionCodes}","{status}","{key}","{value}");
[then][]Set status to "{newStatus}", key pair "{key}" to "{value}" where status is "{oldStatus}" = context.getFeeManagementService().setCourseStatusForStatus(feeBase,"{oldStatus}","{newStatus}","{key}","{value}");
[then][]Number of credits for LU code "{luCodes}" with status "{statuses}" = context.getFeeManagementService().getNumOfCreditsByLearningUnitCodes(feeBase,"{luCodes}","{statuses}");
[then][]Use "{transactionTypeId}" to charge ${amountPerCredit} per credit where section is "{sectionCodes}" with status "{statuses}" = context.getFeeManagementService().createTransactionForNumberOfCredits(feeBase,"{transactionTypeId}",new BigDecimal({amountPerCredit}),"{sectionCodes}","{statuses}");


# ACCOUNT BLOCKING DSL definitions
# Assumption: transactionTypeIds, atpIds, holdIssueNames, permissionNames are global parameters

# RHS definitions
[then][]Apply block = blockNames.add(drools.getRule().getName());

# PAYMENT BOUNCING DSL definitions

# RHS definitions
[then][]Use flag type "{flagTypeCode}", access level "{accessLevelCode}", severity {severity} to create flag expiring in {days} days = context.getInformationService().createFlag(context.getAccount().getId(), "{flagTypeCode}", "{accessLevelCode}", {severity}, new Date(), CalendarUtils.addCalendarDays(new Date(), {days}));
[then][]Use access level "{accessLevelCode}" to create alert "{alertText}" expiring in {days} days = context.getInformationService().createAlert(context.getAccount().getId(), "{alertText}", "{accessLevelCode}", new Date(), CalendarUtils.addCalendarDays(new Date(), {days}));
[then][]Use access level "{accessLevelCode}" to create memo "{memoText}" expiring in {days} days = context.getInformationService().createMemo(context.getAccount().getId(), "{memoText}", "{accessLevelCode}", new Date(), CalendarUtils.addCalendarDays(new Date(), {days}), null);
[then][]Use hold issue type "{holdIssueType}", hold issue name "{holdIssueName}" to create hold "{holdName}" with description "{holdDescription}" expiring in {days} days = context.getHoldService().createAppliedHold(context.getAccount().getId(), "{holdIssueType}", "{holdIssueName}", "{holdName}", "{holdDescription}", new Date(), CalendarUtils.addCalendarDays(new Date(), {days}));

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

