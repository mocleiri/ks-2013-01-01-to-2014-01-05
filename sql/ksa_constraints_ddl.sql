
-- Creating constraints

alter table KSSA_ACCESS_LEVEL add constraint UK_taldp2gbih3ka801e17c0dlp2 unique (CODE);
alter table KSSA_ACCESS_LEVEL add constraint UK_t8a8q7kxfs5c9uyebhfqmhfo2 unique (NAME);
alter table KSSA_ALLOWABLE_GL_ACCOUNT add constraint UK_ga9k2hnldofojvdi6ov9x39rt unique (PATTERN);
alter table KSSA_CASH_LIMIT_EVENT_TRANS add constraint UK_r8972ddjiu8r7so7qxbk8glqm unique (TRANSACTION_ID_FK);
alter table KSSA_CURRENCY add constraint UK_nm8gb8le6wm4us4hjdpa6hc28 unique (CODE);
alter table KSSA_CURRENCY add constraint UK_by344cnmek51sxc8srg4neecc unique (NAME);
alter table KSSA_FLAG_TYPE add constraint UK_ckc9k6g5xv6yhacdj7387g55x unique (CODE);
alter table KSSA_LANGUAGE add constraint UK_9aak1l0nffyaasjc8afohwcnn unique (LOCALE);
alter table KSSA_PB_PLAN add constraint UK_i4pcljunyigo3plb5fir5ijpn unique (CODE);
alter table KSSA_PB_QUEUE add constraint UK_5icskdmhcv7g9mbk5hu4002jy unique (ACNT_ID_FK, PB_PLAN_ID_FK);
alter table KSSA_RATE add constraint UK_sprnbc42tmcbuqoon4w4j9636 unique (CODE, SUB_CODE, RATE_CATALOG_ATP_ID_FK);
alter table KSSA_RATE_AMOUNT add constraint UK_3w5jur4jsn8g10nuncm4jleyt unique (RATE_ID_FK, UNITS);
alter table KSSA_RATE_TYPE add constraint UK_oy0lm1b29qn3wuyf2g6glpdy0 unique (CODE);
alter table KSSA_ROLLUP add constraint UK_a5siumys8px17i943stb7w8fd unique (CODE);
alter table KSSA_RULE add constraint UK_53nu3ypotqtt3om1i2oxwsm2i unique (NAME);
alter table KSSA_RULE_SET add constraint UK_pjuv5c6oi216yq84k2k5m5jfi unique (NAME);
alter table KSSA_RULE_TYPE add constraint UK_itu35fr0prv4skk97ue5pef8u unique (NAME);
alter table KSSA_TAG add constraint UK_6s9tx85pq8qflvavg4bdamv9s unique (CODE);
alter table KSSA_TP_PLAN add constraint UK_qap8yfixn5wavg2f35o4w9dt9 unique (CODE);
alter table KSSA_TP_PLAN_MEMBER add constraint UK_bgpig0htwb0jod2er246bnuwq unique (ACNT_ID_FK, TP_PLAN_ID_FK);
alter table KSSA_TRANSFER_TYPE add constraint UK_s2dw32xke2xgxl2510qha56c0 unique (CODE);
alter table KSSA_ACNT add constraint FK_rny2i3fu0wn844s0jd9xa8rfy foreign key (ACNT_TYPE_ID_FK) references KSSA_ACNT_TYPE;
alter table KSSA_ACNT add constraint FK_kplrufxwsiaxw5qgl5cmurg4k foreign key (ORG_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_ACNT add constraint FK_cbb7ylmp2mcedx63h4jes17g3 foreign key (ACNT_STATUS_TYPE_ID_FK) references KSSA_ACNT_STATUS_TYPE;
alter table KSSA_ACNT add constraint FK_sl2a9wguvw7869x63obkeqyxp foreign key (LATE_PERIOD_ID_FK) references KSSA_LATE_PERIOD;
alter table KSSA_ACNT_AUTHZ add constraint FK_t9hd2icgr1y01gjwdonxr1x4k foreign key (AUTHZ_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_AUTHZ add constraint FK_aw8ih806967cq63gatunr5gnq foreign key (DEPENDENT_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_BLOCK_OVERRIDE add constraint FK_i1iklxcrjfs9ton6qv7d5dqgq foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_BLOCK_OVERRIDE add constraint FK_dqo6vcc1pqimnd95c71fgp9vl foreign key (RULE_ID_FK) references KSSA_RULE;
alter table KSSA_ACNT_ELECTRONIC_CONTACT add constraint FK_rfi6uptp2k1iis4g0bya1t7cm foreign key (ELECTRONIC_CONTACT_ID_FK) references KSSA_ELECTRONIC_CONTACT;
alter table KSSA_ACNT_ELECTRONIC_CONTACT add constraint FK_rt5h9xiggvhuk9yo9vcb0i3v1 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_KEY_PAIR add constraint FK_eswwhqsxf4j6fo0mb5l30wpma foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_ACNT_KEY_PAIR add constraint FK_37qp9ryy6qxquwyfmhjk1n24s foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_PERSON_NAME add constraint FK_ohgaf1y1rg915f82jvw810kx6 foreign key (PERSON_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_ACNT_PERSON_NAME add constraint FK_3dtqsls9l23tlj2hhivu84bw2 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_POSTAL_ADDRESS add constraint FK_bgtfccij1firxpwkb4p511ndo foreign key (POSTAL_ADDRESS_ID_FK) references KSSA_POSTAL_ADDRESS;
alter table KSSA_ACNT_POSTAL_ADDRESS add constraint FK_chdjhwm928x9dkems76n6fi6f foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ACNT_PROTECTED_INFO add constraint FK_4yw1yw5hs0m98sg5exgr9hy42 foreign key (BANK_TYPE_ID_FK) references KSSA_BANK_TYPE;
alter table KSSA_ACNT_PROTECTED_INFO add constraint FK_t82i1uucifu2ornq9pxanpkyc foreign key (ID_TYPE_ID_FK) references KSSA_ID_TYPE;
alter table KSSA_ACNT_PROTECTED_INFO add constraint FK_rrxp1v8rp6m6ptukayc29yd5p foreign key (TAX_TYPE_ID_FK) references KSSA_TAX_TYPE;
alter table KSSA_ALLOCATION add constraint FK_3vtigr174ifh5kkju59brj8r0 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_ALLOCATION add constraint FK_ngcdv99in4bxtutrh2gmd7suu foreign key (TRANSACTION_ID_1_FK) references KSSA_TRANSACTION;
alter table KSSA_ALLOCATION add constraint FK_eu326n7xih6bhsiv6httk46h6 foreign key (TRANSACTION_ID_2_FK) references KSSA_TRANSACTION;
alter table KSSA_BATCH_RECEIPT add constraint FK_j19t6p5h8jf87669v91ky3xwg foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BATCH_RECEIPT add constraint FK_i8hxvwmoe4pirws8yxmyput9w foreign key (INCOMING_XML_ID_FK) references KSSA_XML;
alter table KSSA_BATCH_RECEIPT add constraint FK_1t5tg5xvvdrkmet3escp1i5kb foreign key (OUTGOING_XML_ID_FK) references KSSA_XML;
alter table KSSA_BILL_AUTHORITY add constraint FK_9c0270se0m4q01yia6sjc6ge6 foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BILL_AUTHORITY add constraint FK_7jx57o5s4qbxc90dhaj8r0ga4 foreign key (ELECTRONIC_CONTACT_ID_FK) references KSSA_ELECTRONIC_CONTACT;
alter table KSSA_BILL_AUTHORITY add constraint FK_c0rp5x1tmpkbbg52rl021roqm foreign key (PERSON_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_BILL_AUTHORITY add constraint FK_4lvr1ao9tbbca997jp1n3dkmh foreign key (POSTAL_ADDRESS_ID_FK) references KSSA_POSTAL_ADDRESS;
alter table KSSA_BILL_RECEIVER add constraint FK_cnhmuyjcryep2tep3g6mgpdsj foreign key (OWNER_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BILL_RECEIVER add constraint FK_je54b59d8npkiuvd5qhajg7x9 foreign key (RECEIVER_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BILL_RECORD add constraint FK_2lbeuxpcu8xsxc19ra84rgo3e foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_BILL_RECORD_TRANSACTION add constraint FK_qwhj8h74b34vj31cf65qtkqx3 foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_BILL_RECORD_TRANSACTION add constraint FK_982899ea00ph95aoovq8eijm1 foreign key (BILL_RECORD_ID_FK) references KSSA_BILL_RECORD;
alter table KSSA_CASH_LIMIT_EVENT add constraint FK_jwg32a5bgowpgagwdy059ebt4 foreign key (XML_ID_FK) references KSSA_XML;
alter table KSSA_CASH_LIMIT_EVENT_TRANS add constraint FK_r8972ddjiu8r7so7qxbk8glqm foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_CASH_LIMIT_EVENT_TRANS add constraint FK_5w11v78u0riw580vt2admpgm6 foreign key (CASH_LIMIT_EVENT_ID_FK) references KSSA_CASH_LIMIT_EVENT;
alter table KSSA_CASH_LIMIT_PARAMETER add constraint FK_s2ricy2gxqg7qlwyk9sjoqgn7 foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_COLLECTION_ACNT add constraint FK_oq2m419ekcgli91u4crql3nfa foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_COLLECTION_ACNT add constraint FK_i0gl45ygw1kkrjy9gg5uu01s7 foreign key (AGENCY_ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_CREDIT_PERMISSION add constraint FK_nx4h4jeey7e7qapqav2wx5cm6 foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_EXTERNAL_STATEMENT add constraint FK_e6sflyj4sjg593c3fj7yy6n81 foreign key (BILL_RECORD_ID_FK) references KSSA_BILL_RECORD;
alter table KSSA_FAILED_GL_TRANSACTION add constraint FK_c4y9moylu3v6pqwot2bmq22sy foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_FLAG_TYPE add constraint FK_if1mrx5to67a5boufy199t5ut foreign key (ACCESS_LEVEL_ID_FK) references KSSA_ACCESS_LEVEL;
alter table KSSA_FM_MANIFEST add constraint FK_h06ye14dj0idwxqnhmiexnubl foreign key (LINKED_MANIFEST_ID_FK) references KSSA_FM_MANIFEST;
alter table KSSA_FM_MANIFEST add constraint FK_jey91dljqmlol37k3m6jqv5em foreign key (RATE_ID_FK) references KSSA_RATE;
alter table KSSA_FM_MANIFEST add constraint FK_qk9prbtxwimcs9bqsmoiuc4bk foreign key (ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_FM_MANIFEST add constraint FK_m0t5soerssvydxb0kpeayjfpp foreign key (FM_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_MANIFEST add constraint FK_okidyejxrdxx3e8pyuvnnl17a foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_FM_MANIFEST_KEY_PAIR add constraint FK_kyq9iitu20tpgm6e6gfjan8g6 foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_FM_MANIFEST_KEY_PAIR add constraint FK_8tpgdtscgdn5tiw8jven2bx02 foreign key (FM_MANIFEST_ID_FK) references KSSA_FM_MANIFEST;
alter table KSSA_FM_MANIFEST_TAG add constraint FK_cel25cdjyxtabfwy0brdq07j2 foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_FM_MANIFEST_TAG add constraint FK_60r3krqtnpgayrhj6lmll0gw6 foreign key (FM_MANIFEST_ID_FK) references KSSA_FM_MANIFEST;
alter table KSSA_FM_SESSION add constraint FK_pax8bc8tmvdktmwuoga7v9rod foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_FM_SESSION add constraint FK_a9l7uantuxme293v9bh4uryrx foreign key (NEXT_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SESSION add constraint FK_e7ul4assnqu8orwx36d0rnioh foreign key (PREV_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SESSION_KEY_PAIR add constraint FK_502reu486shpdr9kvvtht1rg foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_FM_SESSION_KEY_PAIR add constraint FK_iub7os1js9jst1j7mnllehpqx foreign key (FM_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SESSION_LOG add constraint FK_t1aw2yyvku7yvarfdjad6pplo foreign key (FM_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SIGNUP add constraint FK_1qsj1xraejqayh2u016ljifd3 foreign key (FM_SESSION_ID_FK) references KSSA_FM_SESSION;
alter table KSSA_FM_SIGNUP_KEY_PAIR add constraint FK_f35c4uwfwn9nuihubrubryqrq foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_FM_SIGNUP_KEY_PAIR add constraint FK_8empwnaevo2gj3nvvv2l6h799 foreign key (FM_SIGNUP_ID_FK) references KSSA_FM_SIGNUP;
alter table KSSA_FM_SIGNUP_RATE add constraint FK_fh3bjqq7obfias749jef77g90 foreign key (RATE_ID_FK) references KSSA_RATE;
alter table KSSA_FM_SIGNUP_RATE add constraint FK_2iqwwtphquog8crh6lrk40iei foreign key (FM_SIGNUP_ID_FK) references KSSA_FM_SIGNUP;
alter table KSSA_FM_SIGNUP_RATE_AMOUNT add constraint FK_1621keodclft9nqolfjpikc0x foreign key (FM_SIGNUP_RATE_ID_FK) references KSSA_FM_SIGNUP_RATE;
alter table KSSA_GL_BATCH_BASELINE add constraint FK_6vfoe8870gcc3g89iru5r3qee foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;
alter table KSSA_GL_BREAKDOWN add constraint FK_igimx73mm08d9q3a0r0xjjv6u foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;
alter table KSSA_GL_BREAKDOWN add constraint FK_3slcuwlfr4cpin7urgkj6eoox foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_GL_BREAKDOWN_OVERRIDE add constraint FK_5b4g2ghwetsdf4agptrhcddh9 foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_GL_BREAKDOWN_OVERRIDE add constraint FK_79x0v4eviwyrbuxiohongnkd4 foreign key (FM_MANIFEST_ID_FK) references KSSA_FM_MANIFEST;
alter table KSSA_GL_TRANSACTION add constraint FK_su2jjuk4e5o6nx4g4q3co3f8r foreign key (GL_RECOGNITION_PERIOD_ID_FK) references KSSA_GL_RECOGNITION_PERIOD;
alter table KSSA_GL_TRANSACTION add constraint FK_n3woi85vtq6b49o4ef7iyltfm foreign key (GL_TRANSMISSION_ID_FK) references KSSA_GL_TRANSMISSION;
alter table KSSA_GL_TRANSMISSION add constraint FK_8mko5up4hnngxb6v952fwlqva foreign key (GL_RECOGNITION_PERIOD_ID_FK) references KSSA_GL_RECOGNITION_PERIOD;
alter table KSSA_GL_TRANS_TRANSACTION add constraint FK_fsal0p74o9x1dknoj5dmj497h foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_GL_TRANS_TRANSACTION add constraint FK_1my950k340rmx2c3ydexadmii foreign key (GL_TRANSACTION_ID_FK) references KSSA_GL_TRANSACTION;
alter table KSSA_INFORMATION add constraint FK_gy8g1avxg2det6j1tl283kuva foreign key (ACCESS_LEVEL_ID_FK) references KSSA_ACCESS_LEVEL;
alter table KSSA_INFORMATION add constraint FK_jkmvsju06ltyhp1m4dhx7jt8p foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_INFORMATION add constraint FK_9w42lpdu788owfio9c1yv0ls foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_INFORMATION add constraint FK_uhpxb6v7kivqiaqebsrktivo foreign key (NEXT_ID) references KSSA_INFORMATION;
alter table KSSA_INFORMATION add constraint FK_apdxe9rlaruk7p1n1x8geltge foreign key (PREV_ID) references KSSA_INFORMATION;
alter table KSSA_INFORMATION add constraint FK_ga8qrg1b82u3ni0olwintyqlj foreign key (FLAG_TYPE_ID_FK) references KSSA_FLAG_TYPE;
alter table KSSA_IRS_1098T add constraint FK_qwl4b4v2oxppgrmh6r6fsjgrl foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_IRS_1098T add constraint FK_j0uib0dd0178l66216i5imjre foreign key (STUDENT_POSTAL_ADDRESS_ID_FK) references KSSA_POSTAL_ADDRESS;
alter table KSSA_IRS_1098T add constraint FK_uyku2l4yahd2xk54noldsaoc foreign key (XML_ID_FK) references KSSA_XML;
alter table KSSA_NAME add constraint FK_mb7kcjtkjtgtn6f1t05ve2a36 foreign key (PERSON_NAME_ID_FK) references KSSA_NAME;
alter table KSSA_PB_ALLOWABLE_CHARGE add constraint FK_ml8v087ax87wl6b2d9kv5i90r foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_DATE add constraint FK_kboj3dcocpls09kuoaxvfgwqr foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_DATE add constraint FK_8qt3pk7pms9cwkmbk0gdsm6y6 foreign key (ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_PB_PLAN add constraint FK_13yvajsqvyj6spap0cfmblitt foreign key (TRANSFER_TYPE_ID_FK) references KSSA_TRANSFER_TYPE;
alter table KSSA_PB_QUEUE add constraint FK_sps0lgaamk1wc2nl0j6ub9bnu foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_PB_QUEUE add constraint FK_5r67yv8982htsuabd63a9dk7u foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_QUEUE add constraint FK_l631yl4xp5beuklgqu79mmng3 foreign key (PB_TRANSFER_DETAIL_ID_FK) references KSSA_PB_TRANSFER_DETAIL;
alter table KSSA_PB_SCHEDULE add constraint FK_94xi8hojv6ttnooors25n61t2 foreign key (PB_TRANSFER_DETAIL_ID_FK) references KSSA_PB_TRANSFER_DETAIL;
alter table KSSA_PB_TRANSACTION add constraint FK_e7q3t6g8au8ia4yjx2q9msub0 foreign key (CHARGE_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_PB_TRANSACTION add constraint FK_3f5p2t6y5olyf3mr3avuq4i0q foreign key (PB_TRANSFER_DETAIL_ID_FK) references KSSA_PB_TRANSFER_DETAIL;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FK_39q2i1d9posaigwf5hf05ekpk foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FK_t67u745pq3y95e8y9hf8vhdkv foreign key (FLAT_FEE_CHARGE_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FK_6d4mfj2cr61wna2im6g3dvowu foreign key (PB_PLAN_ID_FK) references KSSA_PB_PLAN;
alter table KSSA_PB_TRANSFER_DETAIL add constraint FK_psxlaxofe0n39iiw67e2iy1hv foreign key (VAR_FEE_CHARGE_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_RATE add constraint FK_p17jrjywexff43xa68l1q32fb foreign key (RATE_TYPE_ID_FK) references KSSA_RATE_TYPE;
alter table KSSA_RATE add constraint FK_cm9byymv8cy7r3wwetg8nk1t foreign key (DEFAULT_RATE_AMOUNT_ID_FK) references KSSA_RATE_AMOUNT;
alter table KSSA_RATE add constraint FK_2ft2348fawqqefi238tanp16v foreign key (RATE_CATALOG_ATP_ID_FK, RATE_CATALOG_CODE_FK) references KSSA_RATE_CATALOG_ATP;
alter table KSSA_RATE_AMOUNT add constraint FK_emhapxv3hudrdywv5awcduuyc foreign key (RATE_ID_FK) references KSSA_RATE;
alter table KSSA_RATE_CATALOG add constraint FK_hxurjl1wdcub3gk6059j5bxpd foreign key (RATE_TYPE_ID_FK) references KSSA_RATE_TYPE;
alter table KSSA_RATE_CATALOG_ATP add constraint FK_dqmoxkj74pa00s4y0gihjtfcy foreign key (RATE_CATALOG_ID_FK) references KSSA_RATE_CATALOG;
alter table KSSA_RATE_CATALOG_KEY_PAIR add constraint FK_af3avhbh8g11oj5e8iycarc7w foreign key (KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_RATE_CATALOG_KEY_PAIR add constraint FK_j01u5xhkxljdw8tb4adbn7wfy foreign key (RATE_CATALOG_ID_FK) references KSSA_RATE_CATALOG;
alter table KSSA_RATE_KEY_PAIR add constraint FK_7d77ocq8gq1dxts65qotevoq8 foreign key (RATE_KEY_PAIR_ID_FK) references KSSA_KEY_PAIR;
alter table KSSA_RATE_KEY_PAIR add constraint FK_hmx117pku25kl15mpq847o01t foreign key (RATE_ID_FK) references KSSA_RATE;
alter table KSSA_REFUND add constraint FK_5efl32i2bkh8016iguow0lqq5 foreign key (AUTHORIZED_BY_ID_FK) references KSSA_ACNT;
alter table KSSA_REFUND add constraint FK_7bt6bymesld9sict4n3p75qdt foreign key (REFUND_MANIFEST_ID_FK) references KSSA_REFUND_MANIFEST;
alter table KSSA_REFUND add constraint FK_42pnn4jum57gjdlej86vmd3r9 foreign key (REFUND_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_REFUND add constraint FK_4pgd7r8vlc2j4j9xku2acevm2 foreign key (REFUND_TYPE_ID_FK) references KSSA_REFUND_TYPE;
alter table KSSA_REFUND add constraint FK_2i2yh7fhvv9ikt1un8it0fmwy foreign key (REQUESTED_BY_ID_FK) references KSSA_ACNT;
alter table KSSA_REFUND add constraint FK_cmxmif4g9yrovqvsl6l8w8sxg foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_REFUND_MANIFEST add constraint FK_gx69fj9tkp6mqmj9ao0lwr9g3 foreign key (REFUND_ACCOUNT_ID_FK) references KSSA_ACNT;
alter table KSSA_REFUND_MANIFEST add constraint FK_6uo5ukpucckr7g4q8qrb7nuip foreign key (REFUND_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_RULE add constraint FK_6m0653j0foy1e0gtpvn95hyta foreign key (RULE_TYPE_ID_FK) references KSSA_RULE_TYPE;
alter table KSSA_RULE_SET add constraint FK_iphdyo5d9ymf3ykm5yyuibhlc foreign key (RULE_TYPE_ID_FK) references KSSA_RULE_TYPE;
alter table KSSA_RULE_SET_RULE add constraint FK_l9wpfexwactlbgf42dx8muoig foreign key (RULE_ID_FK) references KSSA_RULE;
alter table KSSA_RULE_SET_RULE add constraint FK_sn9vq0g2cyv2ycra5r29mvnlr foreign key (RULE_SET_ID_FK) references KSSA_RULE_SET;
alter table KSSA_TP_ALLOWABLE_CHARGE add constraint FK_su1y91bam0yrjk40e9j4y4gvh foreign key (TP_PLAN_ID_FK) references KSSA_TP_PLAN;
alter table KSSA_TP_PLAN add constraint FK_jqi6qhje3b0rbj414k7ft8ina foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TP_PLAN add constraint FK_i3wh8k1hfuvi2sqwikmqk05dn foreign key (TRANSFER_TYPE_ID_FK) references KSSA_TRANSFER_TYPE;
alter table KSSA_TP_PLAN_MEMBER add constraint FK_pwv98cvv7s1h1n3vkhsuu116t foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TP_PLAN_MEMBER add constraint FK_shh661i7npvr6j8oe489rwrvu foreign key (TP_PLAN_ID_FK) references KSSA_TP_PLAN;
alter table KSSA_TP_TRANSFER_DETAIL add constraint FK_3vqv0vf72n06qi711uavnwq9m foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TP_TRANSFER_DETAIL add constraint FK_6dku2cnsbgm1t6mfd4qj12axb foreign key (TP_PLAN_ID_FK) references KSSA_TP_PLAN;
alter table KSSA_TRANSACTION add constraint FK_5hwubhygex4wlain0kne052yw foreign key (ACNT_ID_FK) references KSSA_ACNT;
alter table KSSA_TRANSACTION add constraint FK_gfnhsishjkdwqhmq6bnx4odd3 foreign key (CURRENCY_ID_FK) references KSSA_CURRENCY;
alter table KSSA_TRANSACTION add constraint FK_ks4lhh31utwkuc3gv69xfpasy foreign key (DOCUMENT_ID_FK) references KSSA_DOCUMENT;
alter table KSSA_TRANSACTION add constraint FK_ha3pd2ughyl2yfuy6o0jv4lgt foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;
alter table KSSA_TRANSACTION add constraint FK_bf2g5srtyc6h39a2cl82qnpjm foreign key (ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_TRANSACTION add constraint FK_3a3c570qabbx3xl5xx9i7eqf3 foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_TRANSACTION_TAG add constraint FK_aj7nulvhhffod5pfgldl21eou foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_TRANSACTION_TAG add constraint FK_b6d0ayhp05jhpyq15lhxr03di foreign key (TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK_owsub0d1673wdy5v0adkudjiy foreign key (DEST_RECIP_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK_hx0akhc17j0qbvtqoinp7wy3p foreign key (DEST_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK_tdopiph4rkfdufxtet3frvf0d foreign key (OFFSET_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK_khoorbgj76fxjw18ojihr1v7f foreign key (SRC_RECIP_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK_ikkigrr362spc23di5w0qanah foreign key (SRC_TRANSACTION_ID_FK) references KSSA_TRANSACTION;
alter table KSSA_TRANSACTION_TRANSFER add constraint FK_hy20bh5cv6hphig336v7vhsh5 foreign key (TRANSFER_TYPE_ID_FK) references KSSA_TRANSFER_TYPE;
alter table KSSA_TRANSACTION_TYPE add constraint FK_s6ql4gws8389trvdb0o2egkye foreign key (DEF_ROLLUP_ID_FK) references KSSA_ROLLUP;
alter table KSSA_TRANSACTION_TYPE_TAG add constraint FK_641br8eh7mko921bxf0b6nihj foreign key (TAG_ID_FK) references KSSA_TAG;
alter table KSSA_TRANSACTION_TYPE_TAG add constraint FK_8gsrb4k7ppadikcb6yjjo2fxq foreign key (TRANSACTION_TYPE_ID_FK, TRANSACTION_TYPE_SUB_CODE_FK) references KSSA_TRANSACTION_TYPE;
alter table KSSA_TRANSFER_TYPE add constraint FK_g7nxhxplqjw0jg0iw8dlqlomg foreign key (GL_TYPE_ID_FK) references KSSA_GL_TYPE;
