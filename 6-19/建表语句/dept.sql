prompt PL/SQL Developer import file
prompt Created on 2018年6月19日 by Administrator
set feedback off
set define off
prompt Dropping DEPT...
drop table DEPT cascade constraints;
prompt Creating DEPT...
create table DEPT
(
  DEPTNO NUMBER(2) not null,
  DNAME  VARCHAR2(14),
  LOC    VARCHAR2(13)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DEPT
  add constraint PK_DEPT primary key (DEPTNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for DEPT...
alter table DEPT disable all triggers;
prompt Loading DEPT...
insert into DEPT (DEPTNO, DNAME, LOC)
values (10, 'ACCOUNTING', 'NEW YORK');
insert into DEPT (DEPTNO, DNAME, LOC)
values (20, 'RESEARCH', 'DALLAS');
insert into DEPT (DEPTNO, DNAME, LOC)
values (30, 'SALES', 'CHICAGO');
insert into DEPT (DEPTNO, DNAME, LOC)
values (40, 'OPERATIONS', 'BOSTON');
insert into DEPT (DEPTNO, DNAME, LOC)
values (50, '研发二部', '沈阳');
commit;
prompt 5 records loaded
prompt Enabling triggers for DEPT...
alter table DEPT enable all triggers;
set feedback on
set define on
prompt Done.
