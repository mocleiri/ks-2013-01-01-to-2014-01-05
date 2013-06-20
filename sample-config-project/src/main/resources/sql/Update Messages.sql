update KSMG_MESSAGE 
set MSG_VALUE = 'My School CM'
where id in (select id from KSMG_MESSAGE where msg_id like 'application%')