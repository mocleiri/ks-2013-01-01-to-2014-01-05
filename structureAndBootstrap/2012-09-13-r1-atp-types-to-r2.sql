-- KSAP_ATP to KSEN_ATP Type Data Migration

-- KSAP_ATP_TYPE to KSEN_TYPE table
INSERT INTO KSEN_TYPE
SELECT type_key, obj_id, nvl(name,' '), type_desc, type_desc, eff_dt, expir_dt, 'http://student.kuali.org/wsdl/atp/AtpInfo',
    'http://student.kuali.org/wsdl/atp/AtpService', nvl(ver_nbr,0), to_date('2012/09/12','YYYY/MM/DD'), 'CMATPUPGRADE', null, null
FROM KSAP_ATP_TYPE WHERE type_key NOT IN (SELECT TYPE_KEY FROM KSEN_TYPE)
/

-- KSAP_ATP_DUR_TYPE to KSEN_TYPE table
INSERT INTO KSEN_TYPE
SELECT type_key, obj_id, nvl(name,' '), type_desc, type_desc, eff_dt, expir_dt, 'http://student.kuali.org/wsdl/atp/AtpInfo',
    'http://student.kuali.org/wsdl/atp/AtpService', nvl(ver_nbr,0), to_date('2012/09/12','YYYY/MM/DD'), 'CMATPUPGRADE', null, null
FROM KSAP_ATP_DUR_TYPE WHERE type_key NOT IN (SELECT TYPE_KEY FROM KSEN_TYPE)
/

-- KSAP_ATP_SEASONAL_TYPE to KSEN_TYPE table
INSERT INTO KSEN_TYPE
SELECT type_key, obj_id, nvl(name,' '), type_desc, type_desc, eff_dt, expir_dt, 'http://student.kuali.org/wsdl/atp/AtpInfo',
    'http://student.kuali.org/wsdl/atp/AtpService', nvl(ver_nbr,0), to_date('2012/09/12','YYYY/MM/DD'), 'CMATPUPGRADE', null, null
FROM KSAP_ATP_SEASONAL_TYPE WHERE type_key NOT IN (SELECT TYPE_KEY FROM KSEN_TYPE)
/

-- KSAP_ATP_DUR_TYPE to ksen_typetype_reltn table
insert into ksen_typetype_reltn
select 'kuali.type.type.relation.type.group.'||a.type_key||'.'||d.type_key,
null,
'kuali.type.type.relation.type.group',
'kuali.type.type.relation.state.active',
d.eff_dt,
d.expir_dt,
a.type_key,
d.type_key,
0,
nvl(d.ver_nbr,0),
to_date('2012/09/12','YYYY/MM/DD'),
'CMATPUPGRADE',
null,
null
from KSAP_ATP_TYPE a, ksap_atp_dur_type d
where a.dur_type = d.type_key
and 'kuali.type.type.relation.type.group.'||a.type_key||'.'||d.type_key not in (select id from ksen_typetype_reltn)
and 'kuali.type.type.relation.type.group.'||d.type_key||'.'||a.type_key not in (select id from ksen_typetype_reltn)
/

-- KSAP_ATP_SEASONAL_TYPE to ksen_typetype_reltn table
insert into ksen_typetype_reltn
select 'kuali.type.type.relation.type.group.'||a.type_key||'.'||d.type_key,
null,
'kuali.type.type.relation.type.group',
'kuali.type.type.relation.state.active',
d.eff_dt,
d.expir_dt,
a.type_key,
d.type_key,
0,
nvl(d.ver_nbr,0),
to_date('2012/09/12','YYYY/MM/DD'),
'CMATPUPGRADE',
null,
null
from KSAP_ATP_TYPE a, ksap_atp_seasonal_type d
where a.seasonal_type = d.type_key
and 'kuali.type.type.relation.type.group.'||a.type_key||'.'||d.type_key not in (select id from ksen_typetype_reltn)
and 'kuali.type.type.relation.type.group.'||d.type_key||'.'||a.type_key not in (select id from ksen_typetype_reltn)
/