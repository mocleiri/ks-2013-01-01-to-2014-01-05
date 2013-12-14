# The KSA DSL definition

# Commonly used DSL definitions

[keyword][]and = &&
[keyword][]eq = ==
[keyword][]lt = <
[keyword][]gt = >
[keyword][]lte = <=
[keyword][]gte = >=

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

########################################################################################################################

# FEE MANAGEMENT DSL definitions

# LHS definitions
[when][]account key "{key}" is "{value}" = fmService.compareAccountKeyPair("{key}","{value}","==",context)
[when][]account key "{key}" is not "{value}" = fmService.compareAccountKeyPair("{key}","{value}","!=",context)
[when][]account key "{key}" gt "{value}" = fmService.compareAccountKeyPair("{key}","{value}",">",context)
[when][]account key "{key}" gte "{value}" = fmService.compareAccountKeyPair("{key}","{value}",">=",context)
[when][]account key "{key}" lt "{value}" = fmService.compareAccountKeyPair("{key}","{value}","<",context)
[when][]account key "{key}" lte "{value}" = fmService.compareAccountKeyPair("{key}","{value}","<=",context)
[when][]session key "{key}" is "{value}" = fmService.compareSessionKeyPair("{key}","{value}","==",context)
[when][]session key "{key}" is not "{value}" = fmService.compareSessionKeyPair("{key}","{value}","!=",context)
[when][]session key "{key}" gt "{value}" = fmService.compareSessionKeyPair("{key}","{value}",">",context)
[when][]session key "{key}" gte "{value}" = fmService.compareSessionKeyPair("{key}","{value}",">=",context)
[when][]session key "{key}" lt "{value}" = fmService.compareSessionKeyPair("{key}","{value}","<",context)
[when][]session key "{key}" lte "{value}" = fmService.compareSessionKeyPair("{key}","{value}","<=",context)
[when][]signup key "{key}" is "{value}" = fmService.compareSignupKeyPair("{key}","{value}","==",context)
[when][]signup key "{key}" is not "{value}" = fmService.compareSignupKeyPair("{key}","{value}","!=",context)
[when][]signup key "{key}" gt "{value}" = fmService.compareSignupKeyPair("{key}","{value}",">",context)
[when][]signup key "{key}" gte "{value}" = fmService.compareSignupKeyPair("{key}","{value}",">=",context)
[when][]signup key "{key}" lt "{value}" = fmService.compareSignupKeyPair("{key}","{value}","<",context)
[when][]signup key "{key}" lte "{value}" = fmService.compareSignupKeyPair("{key}","{value}","<=",context)
[when][]signup rate key "{key}" is "{value}" = fmService.compareSignupRateKeyPair("{key}","{value}","==",context)
[when][]signup rate key "{key}" is not "{value}" = fmService.compareSignupRateKeyPair("{key}","{value}","!=",context)
[when][]signup rate key "{key}" gt "{value}" = fmService.compareSignupRateKeyPair("{key}","{value}",">",context)
[when][]signup rate key "{key}" gte "{value}" = fmService.compareSignupRateKeyPair("{key}","{value}",">=",context)
[when][]signup rate key "{key}" lt "{value}" = fmService.compareSignupRateKeyPair("{key}","{value}","<",context)
[when][]signup rate key "{key}" lte "{value}" = fmService.compareSignupRateKeyPair("{key}","{value}","<=",context)
[when][]account type is "{accountTypeCode}" = fmService.compareAccountType("{accountTypeCode}","==",context)
[when][]account type is not "{accountTypeCode}" = fmService.compareAccountType("{accountTypeCode}","!=",context)
[when][]account status is "{accountStatusCode}" = fmService.compareAccountStatus("{accountStatusCode}","==",context)
[when][]account status is not "{accountStatusCode}" = fmService.compareAccountStatus("{accountStatusCode}","!=",context)
[when][]session atp is "{atpId}" = fmService.compareSessionAtp("{atpId}","==",context)
[when][]session atp is not "{atpId}" = fmService.compareSessionAtp("{atpId}","!=",context)
[when][]account has flag "{flagTypeCode}" = fmService.accountHasFlag("{flagTypeCode}",null,"==",context)
[when][]account has flag "{flagTypeCode}" with severity {severity} = fmService.accountHasFlag("{flagTypeCode}",{severity},"==",context)
[when][]account has flag "{flagTypeCode}" with severity above {severity} = fmService.accountHasFlag("{flagTypeCode}",{severity},">",context)
[when][]account has flag "{flagTypeCode}" with severity below {severity} = fmService.accountHasFlag("{flagTypeCode}",{severity},"<",context)
[when][]account has applied hold "{holdIssueName}" = fmService.accountHasAppliedHold("{holdIssueName}",context)


# RHS definitions
[then][]set account key "{key}" to "{value}" = context.getFmService().setAccountKey("{key}","{value}",context);
[then][]set session key "{key}" to "{value}" = context.getFmService().setSessionKey("{key}","{value}",context);
[then][]set signup key "{key}" to "{value}" = context.getFmService().setSignupKey("{key}","{value}",context);


########################################################################################################################

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

