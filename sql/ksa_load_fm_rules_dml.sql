


-----------------------------------------------------------------------------------------------------------------------
--- Inserting Fee Managements rules ---

Insert into KSSA_RULE_SET (ID, NAME, RULE_TYPE_ID_FK, HEADER) values (101, 'Fee Management 1', 3,
'import java.util.*;
import java.math.*;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.model.rule.*;
import com.sigmasys.kuali.ksa.service.brm.*;
import com.sigmasys.kuali.ksa.service.fm.*;
import com.sigmasys.kuali.ksa.model.security.*;
import com.sigmasys.kuali.ksa.util.*;
import org.apache.commons.lang.*;

expander ksa.dsl

global FeeManagementSession fmSession;


')!

Insert into KSSA_RULE (ID, NAME, RULE_TYPE_ID_FK, PRIORITY, HEADER, LHS, RHS) values (5001, 'FM Rule 1', 3, 0, null,
'(Transaction type is "cash, finaid" and Transaction amount > $2000)',
'Use flag type "OverLimit", access level "DEF_FLAG_LEVEL_CD", severity 10 to create flag expiring in 90 days
 Use code "1020" to charge $850.45
 ')!

-- FM rule associations
Insert into KSSA_RULE_SET_RULE ( RULE_SET_ID_FK, RULE_ID_FK ) values (101, 5001)!


-----------------------------------------------------------------------------------------------------------------------